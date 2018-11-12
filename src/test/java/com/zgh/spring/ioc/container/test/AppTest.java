package com.zgh.spring.ioc.container.test;

import com.zgh.spring.ioc.container.factory.BeanFactory;
import com.zgh.spring.ioc.container.factory.XmlClassPathApplicationContext;
import com.zgh.spring.ioc.container.service.CloudService;

import junit.framework.TestCase;

public class AppTest extends TestCase {
	public void testApp() {

		BeanFactory beanFactory = new XmlClassPathApplicationContext("applicationContext.xml");

		CloudService cloudService = (CloudService) beanFactory.getBean("cloudService");

		cloudService.doService();

	}
}
