package com.zgh.spring.ioc.container.aop;

/**
 * Target Object Invoke Condition
 * @author Administrator
 *
 */
public class AdvisedSupport {

	private TargetObjectDefinition targetObjectDefinition;
	
	private MethodInterceptor methodInterceptor;

	public TargetObjectDefinition getTargetObjectDefinition() {
		return targetObjectDefinition;
	}

	public void setTargetObjectDefinition(TargetObjectDefinition targetObjectDefinition) {
		this.targetObjectDefinition = targetObjectDefinition;
	}

	public MethodInterceptor getMethodInterceptor() {
		return methodInterceptor;
	}

	public void setMethodInterceptor(MethodInterceptor methodInterceptor) {
		this.methodInterceptor = methodInterceptor;
	}
	
	
	
}
