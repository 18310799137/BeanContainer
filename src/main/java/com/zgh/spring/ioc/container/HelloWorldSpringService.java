package com.zgh.spring.ioc.container;

public class HelloWorldSpringService {

	private String stringText;

	private String stringValue;

	public void doService() {
		System.out.println(stringText + " \n" + stringValue);
	}

}
