package com.zgh.spring.ioc.container;

public class DefaultFactoryBean extends AbstractBeanFactory {

	public Object createBean(BeanDefinition beanDefinition) {
		Object newInstance = null;
		try {
			 newInstance = Class.forName(beanDefinition.getClassName()).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return newInstance;
	}

}
