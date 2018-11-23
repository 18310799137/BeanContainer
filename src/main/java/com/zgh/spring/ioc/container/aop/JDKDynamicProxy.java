package com.zgh.spring.ioc.container.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKDynamicProxy implements AopProxy , InvocationHandler{

	private AdvisedSupport support;
	
	public JDKDynamicProxy(AdvisedSupport support) {
		this.support = support;
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Exception {
		MethodInterceptor methodInterceptor = support.getMethodInterceptor();
		return methodInterceptor
				.invoke(new ReflectiveMethodInvocation(support.getTargetObjectDefinition().getTarget(), method, args));
	}

	public Object getProxyObject() {
		Class<?>[] interfaces = support.getTargetObjectDefinition().getClazz().getInterfaces();
		return Proxy.newProxyInstance(support.getTargetObjectDefinition().getClass().getClassLoader(),
				interfaces, this);
	}

}
