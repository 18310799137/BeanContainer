package com.zgh.spring.ioc.container.aop;

/**
 * Target Object Information
 * @author Administrator
 *
 */
public class TargetObjectDefinition {

	private Class<?> clazz;

	private Object target;

	public TargetObjectDefinition(Class<?> clazz, Object target) {
		super();
		this.clazz = clazz;
		this.target = target;
	}

	public Class<?> getClazz() {
		return clazz;
	}

	public void setClazz(Class<?> clazz) {
		this.clazz = clazz;
	}

	public Object getTarget() {
		return target;
	}

	public void setTarget(Object target) {
		this.target = target;
	}

}
