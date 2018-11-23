package com.zgh.spring.ioc.container.context;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map.Entry;

import com.zgh.spring.ioc.container.bean.BeanDefinition;
import com.zgh.spring.ioc.container.io.ResourceLoader;
import com.zgh.spring.ioc.container.xml.AbstractResolveXmlBeanDefinitionReader;
import com.zgh.spring.ioc.container.xml.ResolveXmlBeanDefinitionReader;

public class XmlClassPathApplicationContext extends AbstractApplicationContext {

	public XmlClassPathApplicationContext(String location) {
		super(location);
	}

	@Override
	public Object getBean(String beanName) {
		return super.beanFactory.getBean(beanName);
	}

	@Override
	protected void refresh() {
		AbstractResolveXmlBeanDefinitionReader reader = new ResolveXmlBeanDefinitionReader(new ResourceLoader());
		reader.loadResourceToContainer(this.configLocation);
		for (Entry<String, BeanDefinition> entry : reader.getResolveBeanMaps().entrySet()) {
			System.out.println("[" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())
					+ "] Register BeanName:" + entry.getKey() + "\tClass: [" + entry.getValue().getClassName() + "]");
			super.beanFactory.registerBeanDefinition(entry.getKey(), entry.getValue());
		}
	}

}
