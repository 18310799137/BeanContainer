package com.zgh.spring.ioc.container.factory;

import com.zgh.spring.ioc.container.bean.BeanDefinition;

public interface BeanFactory {

	Object  getBean(String beanName);
	
	void registerBeanDefinition(String className ,BeanDefinition beanDefinition);
	
	
}
