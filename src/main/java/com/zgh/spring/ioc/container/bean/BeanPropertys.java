package com.zgh.spring.ioc.container.bean;

import java.util.ArrayList;
import java.util.List;

public class BeanPropertys {

	private List<BeanProperty> beanProperties = new ArrayList<BeanProperty>();

	public List<BeanProperty> getBeanProperties() {
		return beanProperties;
	}

	public void addBeanProperty(BeanProperty beanProperty) {
		this.beanProperties.add(beanProperty);
	}

	@Override
	public String toString() {
		return "BeanPropertys [beanProperties=" + beanProperties + "]";
	}

}
