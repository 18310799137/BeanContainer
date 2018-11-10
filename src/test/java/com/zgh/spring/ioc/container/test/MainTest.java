package com.zgh.spring.ioc.container.test;

import com.zgh.spring.ioc.container.factory.BeanFactory;
import com.zgh.spring.ioc.container.factory.XmlClassPathApplicationContext;
import com.zgh.spring.ioc.container.service.CloudService;
import com.zgh.spring.ioc.container.service.HelloWorldSpringService;

public class MainTest {

	public static void main(String[] args) {

		BeanFactory beanFactory = new XmlClassPathApplicationContext("applicationContext.xml");

		// HelloServiceBean doService
		HelloWorldSpringService helloWorldSpringService = (HelloWorldSpringService) beanFactory
				.getBean("helloSpringService");
		helloWorldSpringService.doService();

		// CloudServiceBean doService
		CloudService cloudService = (CloudService) beanFactory.getBean("helloSpringServiceCloudService");
		cloudService.doService();

	}
}
