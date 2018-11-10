package com.zgh.spring.ioc.container.factory;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.zgh.spring.ioc.container.bean.BeanDefinition;
import com.zgh.spring.ioc.container.bean.BeanProperty;
import com.zgh.spring.ioc.container.io.Resource;
import com.zgh.spring.ioc.container.io.ResourceLoader;

public class XmlClassPathApplicationContext extends BeanCreateFactory {
	public XmlClassPathApplicationContext(String location) {
		super(location);
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
	@Override
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
			registerBeanDefinition(beanName, beanDefinition);
		}
	}

	/**
	 * 
	 * @Title: getAttributeOrChildNodeText
	 * @Description: 判断value为属性节点 或是子节点,然后获取文本值
	 * @param @param element
	 * @param @param attributeName
	 * @param @return
	 * @return String
	 * @author Free
	 * @date 2018年11月10日 上午11:52:28 
	 * @throws
	 */
	public String getAttributeOrChildNodeText(Element element, String attributeName) {
		String textContent = element.getAttribute(attributeName);
		if (null == textContent || "".equals(textContent.trim())) {
			NodeList valueNodeList = element.getElementsByTagName(attributeName);
			for (int i = 0; i < valueNodeList.getLength(); i++) {
				if (valueNodeList.item(i) instanceof Element) {
					textContent = valueNodeList.item(0).getTextContent();
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
			String propertyValue = getAttributeOrChildNodeText(propertyNode, TagNames.value.getNameStringText());
			beanDefinition.getBeanPropertys().addBeanProperty(new BeanProperty(propertyName, propertyValue));
		}
	}

	public NodeList getNodeListByTagName(Element element, String tagName) {
		NodeList childNodes = element.getElementsByTagName(tagName);
		return childNodes;
	}

}
