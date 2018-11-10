package com.zgh.spring.ioc.container.factory;

public class DefaultBeanFactory extends BeanCreateFactory {

	public DefaultBeanFactory(String location) {
		super(location);
	}

	public DefaultBeanFactory() {
	}

	@Override
	public void loadResourceToContainer(String resource) {
	}

}
