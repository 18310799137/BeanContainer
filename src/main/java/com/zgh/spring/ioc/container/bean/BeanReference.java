package com.zgh.spring.ioc.container.bean;

public class BeanReference {

	private String refName;

	public BeanReference(String refName) {
		this.refName=refName;
	}
	public String getRefName() {
		return refName;
	}

	public void setRefName(String refName) {
		this.refName = refName;
	}

}
