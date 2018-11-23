package com.zgh.spring.ioc.container.aop;

import java.lang.reflect.Method;

public class ReflectiveMethodInvocation implements MethodInvocation{

	private Object target;
	
	private Method method;
	
	private Object[] arguments;

	public ReflectiveMethodInvocation(Object target,Method method,Object[] arguments) {
		this.target=target;
		this.method=method;
		this.arguments=arguments;
	}

	@Override
	public Object[] getArguments() {
		return arguments;
	}

	@Override
	public Method getMethod() {
		return method;
	}

	@Override
	public Object proceed() throws Exception  {
		return method.invoke(target, arguments);
	}

}
