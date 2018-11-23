package com.zgh.spring.ioc.container.test.interceptor;

import com.zgh.spring.ioc.container.aop.AdvisedSupport;
import com.zgh.spring.ioc.container.aop.JDKDynamicProxy;
import com.zgh.spring.ioc.container.aop.TargetObjectDefinition;
import com.zgh.spring.ioc.container.context.XmlClassPathApplicationContext;
import com.zgh.spring.ioc.container.factory.BeanFactory;
import com.zgh.spring.ioc.container.service.ICloudService;

public class JDKDynamicProxyTest {

	public static void main(String[] args) {
		BeanFactory beanFactory = new XmlClassPathApplicationContext("applicationContext.xml");

		ICloudService cloudService = (ICloudService) beanFactory.getBean("cloudService");
 
		
		AdvisedSupport support = new AdvisedSupport();
		support.setMethodInterceptor(new CustomInterceptor());
		support.setTargetObjectDefinition(new TargetObjectDefinition(cloudService.getClass(),cloudService));
		// 获取JDK动态代理对象
		JDKDynamicProxy jdkDynamicProxy = new JDKDynamicProxy(support);
		ICloudService cloudServiceProxy = (ICloudService) jdkDynamicProxy.getProxyObject();
		
		cloudServiceProxy.doService();
		
	}
}
