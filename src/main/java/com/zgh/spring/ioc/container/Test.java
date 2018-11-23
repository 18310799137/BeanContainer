package com.zgh.spring.ioc.container;

import com.zgh.spring.ioc.container.context.ApplicationContext;
import com.zgh.spring.ioc.container.context.XmlClassPathApplicationContext;
import com.zgh.spring.ioc.container.service.CloudService;

public class Test {

	public static void main(String[] args) {

		ApplicationContext applicationContext = new XmlClassPathApplicationContext("applicationContext.xml");

		CloudService cloudService = (CloudService) applicationContext.getBean("cloudService");

		cloudService.doService();

		System.out.println("CloudService:" + cloudService);

	}
}
