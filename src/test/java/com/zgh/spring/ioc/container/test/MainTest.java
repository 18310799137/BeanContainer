package com.zgh.spring.ioc.container.test;

import com.zgh.spring.ioc.container.HelloWorldSpringService;
import com.zgh.spring.ioc.container.bean.BeanDefinition;
import com.zgh.spring.ioc.container.bean.BeanProperty;
import com.zgh.spring.ioc.container.bean.BeanPropertys;
import com.zgh.spring.ioc.container.factory.BeanFactory;
import com.zgh.spring.ioc.container.factory.DefaultBeanFactory;

public class MainTest {

	public static void main(String[] args) {

		BeanFactory beanFactory = new DefaultBeanFactory();

		BeanDefinition beanDefinition = new BeanDefinition("com.zgh.spring.ioc.container.HelloWorldSpringService");
		
		BeanPropertys beanPropertys = beanDefinition.getBeanPropertys();
		beanPropertys.addBeanProperty(new BeanProperty("stringText","Hello! This is Field Stringtext Value!"));
		beanPropertys.addBeanProperty(new BeanProperty("stringValue","Hello! This is Field stringValue Text!"));
		
		beanFactory.registerBeanDefinition("helloSpringService", beanDefinition);

		HelloWorldSpringService helloWorldSpringService = (HelloWorldSpringService) beanFactory
				.getBean("helloSpringService");

		helloWorldSpringService.doService();

	}
}
