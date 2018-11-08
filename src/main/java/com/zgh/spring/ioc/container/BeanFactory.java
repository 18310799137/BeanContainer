package com.zgh.spring.ioc.container;

public interface BeanFactory {

	Object  getBean(String beanName);
	
	void registerBeanDefinition(String className ,BeanDefinition beanDefinition);
	
	
}
