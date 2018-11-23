package com.zgh.spring.ioc.container.context;

import com.zgh.spring.ioc.container.factory.AbstractBeanFactory;
import com.zgh.spring.ioc.container.factory.BeanCreateFactory;

public abstract class AbstractApplicationContext implements ApplicationContext {

	protected AbstractBeanFactory beanFactory;

	protected String configLocation;

	protected AbstractApplicationContext(String location) {
		this.beanFactory = new BeanCreateFactory();
		this.configLocation = location;
		refresh();
	}

	protected abstract void refresh();
}
