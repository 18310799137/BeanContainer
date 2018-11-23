package com.zgh.spring.ioc.container.aop;

import java.lang.reflect.Method;

public interface MethodInvocation {
	Object[] getArguments();
	
	
	Method getMethod();
	
	
	Object proceed() throws Exception;
}
