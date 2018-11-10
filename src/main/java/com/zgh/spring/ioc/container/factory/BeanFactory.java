package com.zgh.spring.ioc.container.factory;

import com.zgh.spring.ioc.container.bean.BeanDefinition;

public interface BeanFactory {

	/**
	 * 
	 * @Title: getBean
	 * @Description: 对象获取
	 * @param @param beanName
	 * @param @return
	 * @return Object
	 * @author Free
	 * @date 2018年11月10日 下午12:00:59 
	 * @throws
	 */
	Object  getBean(String beanName);
	/**
	 * 
	 * @Title: registerBeanDefinition
	 * @Description: 对象注册
	 * @param @param className
	 * @param @param beanDefinition
	 * @return void
	 * @author Free
	 * @date 2018年11月10日 下午12:00:47 
	 * @throws
	 */
	void registerBeanDefinition(String className ,BeanDefinition beanDefinition);
	
	
}
