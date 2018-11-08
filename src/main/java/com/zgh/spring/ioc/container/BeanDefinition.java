package com.zgh.spring.ioc.container;

public class BeanDefinition {

	private Object bean;
	
	private String className;

	public BeanDefinition(String className) {
		this.className = className;
	}
	
	public void setBean(Object bean) {
		this.bean = bean;
	}

	public Object getBean() {
		return bean;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
	
	
	
}
