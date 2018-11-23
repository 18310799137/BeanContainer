package com.zgh.spring.ioc.container.xml;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.zgh.spring.ioc.container.bean.BeanDefinition;
import com.zgh.spring.ioc.container.bean.BeanProperty;
import com.zgh.spring.ioc.container.bean.BeanReference;
import com.zgh.spring.ioc.container.io.Resource;
import com.zgh.spring.ioc.container.io.ResourceLoader;

public class ResolveXmlBeanDefinitionReader extends AbstractResolveXmlBeanDefinitionReader {
	public ResolveXmlBeanDefinitionReader() {
		super();
	}

	public ResolveXmlBeanDefinitionReader(ResourceLoader resourceLoader) {
		super(resourceLoader);
	}

	/**
	 * 
	 * @Title: loadResourceToContainer
	 * @Description: 加载资源文件到容器中
	 * @param @param location
	 * @return 
	 * @author Free
	 * @date 2018年11月10日 下午12:01:57 
	 * @throws
	 */
	public void loadResourceToContainer(String location) {
		ResourceLoader resourceLoader = new ResourceLoader();
		Resource resource = resourceLoader.loadResource(location);
		InputStream inputStream = resource.getInputStream();
		Document document = getDocument(inputStream);
		loadDocumentParseBeanToCantainer(document);
	}

	/**
	 * 
	 * @Title: getDocument
	 * @Description: TODO
	 * @param @param inputStream
	 * @param @return
	 * @return Document
	 * @author Free
	 * @date 2018年11月10日 下午12:02:17 
	 * @throws
	 */
	public Document getDocument(InputStream inputStream) {
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		Document document = null;
		try {
			DocumentBuilder newDocumentBuilder = builderFactory.newDocumentBuilder();
			document = newDocumentBuilder.parse(inputStream);
		} catch (Exception e) {
		}
		return document;
	}

	public void loadDocumentParseBeanToCantainer(Document document) {
		Element rootElement = document.getDocumentElement();
		NodeList beanNodeList = getNodeListByTagName(rootElement, TagNames.bean.getNameStringText());
		disposeBeanNode(beanNodeList);

	}

	/**
	 * 1.定义BeanDefintion
	 * 2.设置Property
	 * 3.RegisterBean
	 * @param beanNodeList
	 * @Title: disposeBeanNode
	 * @Description: 处理bean标签
	 * @param @param beanNodeList
	 * @return void
	 * @author Free
	 * @date 2018年11月10日 下午12:06:22 
	 * @throws
	 */
	public void disposeBeanNode(NodeList beanNodeList) {
		for (int i = 0; i < beanNodeList.getLength(); i++) {
			Element beanNode = (Element) beanNodeList.item(i);
			String beanName = beanNode.getAttribute(TagNames.id.getNameStringText());
			String className = beanNode.getAttribute(TagNames.className.getNameStringText());
			BeanDefinition beanDefinition = new BeanDefinition(className);
			NodeList propertyNodeList = getNodeListByTagName(beanNode, TagNames.property.getNameStringText());
			disposePropertyNode(propertyNodeList, beanDefinition);
			this.getResolveBeanMaps().put(beanName, beanDefinition);
		}
	}

	/**
	 * 
	 * @Title: getAttributeOrChildNodeText
	 * @Description: 解析property的 属性节点或者子节点
	 * @param @param element
	 * @param @param tagNames
	 * @param @return
	 * @return String
	 * @author Free
	 * @date 2018年11月11日 下午11:14:51 
	 * @throws
	 */
	public String getAttributeOrChildNodeText(Element element, TagNames tagNames) {
		// 解析如果Property value 或者ref 为属性节点时
		String textContent = element.getAttribute(tagNames.getNameStringText());
		if (isEmpty(textContent)) {
			// 解析property为value时 在property子节点填写变量时的情况
			if (TagNames.value.equals(tagNames)) {
				NodeList valueNodeList = element.getElementsByTagName(tagNames.getNameStringText());
				for (int i = 0; i < valueNodeList.getLength(); i++) {
					if (valueNodeList.item(i) instanceof Element) {
						textContent = valueNodeList.item(0).getTextContent();
					}
				}
				// 解析property为value时 在property子节点填写变量时的情况
			} else if (TagNames.ref.equals(tagNames)) {
				NodeList refNodeList = element.getElementsByTagName(tagNames.getNameStringText());
				Node refTag = refNodeList.item(0);
				if (refTag instanceof Element) {
					textContent = ((Element) refTag).getAttribute(TagNames.id.getNameStringText());
					if (isEmpty(textContent)) {
						throw new IllegalArgumentException("The ref tag must has id property!");
					}
				}
			}
		}
		return textContent;
	}

	/**
	 * 
	 * @Title: disposePropertyNode
	 * @Description: 处理property属性节点
	 * @param @param propertyNodeList
	 * @param @param beanDefinition
	 * @return void
	 * @author Free
	 * @date 2018年11月10日 上午11:53:14 
	 * @throws
	 */
	public void disposePropertyNode(NodeList propertyNodeList, BeanDefinition beanDefinition) {
		for (int i = 0; i < propertyNodeList.getLength(); i++) {
			Element propertyNode = (Element) propertyNodeList.item(i);
			String propertyName = propertyNode.getAttribute(TagNames.name.getNameStringText());
			TagNames tagNames = checkTagPropertyIsValueOrRef(propertyNode);
			//获取value 或者 ref 值
			String propertyValue = getAttributeOrChildNodeText(propertyNode, tagNames);
			if (tagNames.equals(TagNames.value)) {
				beanDefinition.getBeanPropertys().addBeanProperty(new BeanProperty(propertyName, propertyValue));
			} else {
				// 如果是ref类型的属性标签,则取出容器中存入的 相对应的bean实例
				beanDefinition.getBeanPropertys()
						.addBeanProperty(new BeanProperty(propertyName, new BeanReference(propertyValue)));
			}

		}
	}

	public boolean isEmpty(String str) {
		if (null == str || str.trim().length() < 1) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @Title: checkTagPropertyIsValueOrRef
	 * @Description: 判断属性注入标签为value还是ref <value为String  ref为 Object>
	 * @param @param element
	 * @param @return
	 * @return TagNames
	 * @author Free
	 * @date 2018年11月11日 下午11:01:36 
	 * @throws
	 */
	public TagNames checkTagPropertyIsValueOrRef(Element element) {
		String value = element.getAttribute(TagNames.value.getNameStringText());
		String ref = element.getAttribute(TagNames.ref.getNameStringText());
		NodeList valueNodeList = element.getElementsByTagName(TagNames.value.getNameStringText());
		NodeList refNodeList = element.getElementsByTagName(TagNames.ref.getNameStringText());

		if (isEmpty(value) && isEmpty(ref) && valueNodeList.getLength() != 1 && refNodeList.getLength() != 1) {
			throw new IllegalArgumentException("the property tag attribute must is value or ref");
		}
		if (!isEmpty(value) || valueNodeList.getLength() == 1) {
			return TagNames.value;
		}
		return TagNames.ref;
	}

	public NodeList getNodeListByTagName(Element element, String tagName) {
		NodeList childNodes = element.getElementsByTagName(tagName);
		return childNodes;
	}

}
