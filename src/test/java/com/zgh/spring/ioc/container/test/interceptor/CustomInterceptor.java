package com.zgh.spring.ioc.container.test.interceptor;

import com.zgh.spring.ioc.container.aop.MethodInterceptor;
import com.zgh.spring.ioc.container.aop.MethodInvocation;

public class CustomInterceptor implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation methodInvocation) throws Exception {
		String name = methodInvocation.getMethod().getName();
		System.err.println(">>>>>Interceptor>>>>>>Run Target Method [" + name + "]Start<<<<<<<<<<<<<<<<<<<<<<<");
		Object proceed = methodInvocation.proceed();
		System.err.println(">>>>>>Interceptor>>>>>Run Target Method [" + name + "]End<<<<<<<<<<<<<<<<<<<<<<<<<");
		return proceed;
	}

}
