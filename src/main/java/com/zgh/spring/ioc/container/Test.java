package com.zgh.spring.ioc.container;

import com.zgh.spring.ioc.container.bean.BeanDefinition;
import com.zgh.spring.ioc.container.bean.BeanProperty;
import com.zgh.spring.ioc.container.bean.BeanPropertys;
import com.zgh.spring.ioc.container.factory.BeanFactory;
import com.zgh.spring.ioc.container.factory.DefaultBeanFactory;
import com.zgh.spring.ioc.container.service.HelloWorldSpringService;

public class Test {

	public static void main(String[] args) {

		BeanFactory beanFactory = new DefaultBeanFactory();

		BeanDefinition beanDefinition = new BeanDefinition("com.zgh.spring.ioc.container.service.HelloWorldSpringService");
		
		BeanPropertys beanPropertys = beanDefinition.getBeanPropertys();
		beanPropertys.addBeanProperty(new BeanProperty("stringText","Hello! This is Field Stringtext Value!"));
		beanPropertys.addBeanProperty(new BeanProperty("stringValue","Hello! This is Field stringValue Text!"));
		
		beanFactory.registerBeanDefinition("helloSpringService", beanDefinition);

		HelloWorldSpringService helloWorldSpringService = (HelloWorldSpringService) beanFactory
				.getBean("helloSpringService");

		helloWorldSpringService.doService();

	}
}
