package com.zgh.spring.ioc.container.bean;

public class BeanProperty {

	private String propertyName;

	private Object propertyValue;

	
	public BeanProperty(String propertyName, Object propertyValue) {
		super();
		this.propertyName = propertyName;
		this.propertyValue = propertyValue;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public Object getPropertyValue() {
		return propertyValue;
	}

	public void setPropertyValue(Object propertyValue) {
		this.propertyValue = propertyValue;
	}

	@Override
	public String toString() {
		return "BeanProperty [propertyName=" + propertyName + ", propertyValue=" + propertyValue + "]";
	}
	
	 

}
