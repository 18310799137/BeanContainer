package com.zgh.spring.ioc.container;


public class Test {

	public static void main(String[] args) {

		BeanFactory beanFactory = new DefaultFactoryBean();

		beanFactory.registerBeanDefinition("helloSpringService", new BeanDefinition("com.zgh.spring.ioc.container.HelloWorldSpringService"));

		HelloWorldSpringService beanDefinition = (HelloWorldSpringService) beanFactory.getBean("helloSpringService");

		beanDefinition.doService();

	}
}
