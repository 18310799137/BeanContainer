package com.zgh.spring.ioc.container.xml;

import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.zgh.spring.ioc.container.bean.BeanDefinition;
import com.zgh.spring.ioc.container.io.ResourceLoader;

public abstract class AbstractResolveXmlBeanDefinitionReader {

	private Map<String, BeanDefinition> beanDefintionMaps;

	private ResourceLoader resourceLoader;

	public AbstractResolveXmlBeanDefinitionReader(ResourceLoader resourceLoader) {
		this.beanDefintionMaps = new ConcurrentHashMap<String, BeanDefinition>();
		this.resourceLoader = resourceLoader;
	};

	public AbstractResolveXmlBeanDefinitionReader() {
		this.resourceLoader = new ResourceLoader();
	}

	public Map<String, BeanDefinition> getResolveBeanMaps() {
		return beanDefintionMaps;
	}

	protected InputStream getInpuStream(String location) {
		return this.resourceLoader.loadResource(location).getInputStream();
	}

	public abstract void loadResourceToContainer(String location);

}
