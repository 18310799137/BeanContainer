package com.zgh.spring.ioc.container.bean;

public class BeanDefinition {

	private Object bean;

	private String className;

	private BeanPropertys beanPropertys = new BeanPropertys();

	public BeanPropertys getBeanPropertys() {
		return beanPropertys;
	}

	public void setBeanPropertys(BeanPropertys beanPropertys) {
		this.beanPropertys = beanPropertys;
	}

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
