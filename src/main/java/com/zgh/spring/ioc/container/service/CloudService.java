package com.zgh.spring.ioc.container.service;

public class CloudService {

	private String cloudServiceText;

	private HelloWorldSpringService helloWorldSpringService;

	private UserService userService;

	public void doService() {
		System.out.println(cloudServiceText);
		userService.doService();
		helloWorldSpringService.doService();
	}
}
