package com.zgh.spring.ioc.container.service;

public class UserService {

	private String userName;
	
	public void doService() {
		System.out.println("My name is "+userName);
	}
}
