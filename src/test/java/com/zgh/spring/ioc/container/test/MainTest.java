package com.zgh.spring.ioc.container.test;

import com.zgh.spring.ioc.container.context.XmlClassPathApplicationContext;
import com.zgh.spring.ioc.container.factory.BeanFactory;
import com.zgh.spring.ioc.container.service.CloudService;

public class MainTest {

	public static void main(String[] args) {

		BeanFactory beanFactory = new XmlClassPathApplicationContext("applicationContext.xml");

		CloudService cloudService = (CloudService) beanFactory.getBean("cloudService");

		cloudService.doService();

	}
}
