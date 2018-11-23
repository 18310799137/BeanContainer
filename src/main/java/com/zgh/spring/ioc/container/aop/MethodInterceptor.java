package com.zgh.spring.ioc.container.aop;

public interface MethodInterceptor {

      Object invoke(MethodInvocation methodInvocation) throws Exception;
}
