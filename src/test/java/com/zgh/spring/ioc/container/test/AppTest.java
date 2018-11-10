package com.zgh.spring.ioc.container.test;

import com.zgh.spring.ioc.container.factory.BeanFactory;
import com.zgh.spring.ioc.container.factory.XmlClassPathApplicationContext;
import com.zgh.spring.ioc.container.service.CloudService;
import com.zgh.spring.ioc.container.service.HelloWorldSpringService;

import junit.framework.TestCase;

public class AppTest extends TestCase {
	public void testApp() {

		BeanFactory beanFactory = new XmlClassPathApplicationContext("applicationContext.xml");

		HelloWorldSpringService helloWorldSpringService = (HelloWorldSpringService) beanFactory
				.getBean("helloSpringService");
		CloudService cloudService = (CloudService) beanFactory
				.getBean("helloSpringServiceCloudService");
		cloudService.doService();

		helloWorldSpringService.doService();

	}
}
