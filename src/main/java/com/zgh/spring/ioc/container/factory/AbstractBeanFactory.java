package com.zgh.spring.ioc.container.factory;

import java.util.HashMap;
import java.util.Map;

import com.zgh.spring.ioc.container.bean.BeanDefinition;

/**
 * 
 * @ClassName: AbstractBeanFactory
 * @Description: 初始化容器 并提供注册方法
 * @author Administrator
 * @date 2018年11月10日
 *
 */
public abstract class AbstractBeanFactory implements BeanFactory {
	private Map<String, BeanDefinition> beanDefinitionMaps = new HashMap<>();

	@Override
	public Object getBean(String beanName) {

		BeanDefinition beanDefinition = this.beanDefinitionMaps.get(beanName);
		if (beanDefinition == null) {
			throw new IllegalArgumentException("no register bean name : " + beanName);
		}
		Object bean = beanDefinition.getBean();
		if (bean == null) {
			bean = createBean(beanDefinition);
		}
		return bean;
	}

	/**
	 * 
	 * @Title: registerBeanDefinition
	 * @Description: 对象注册
	 * @param @param beanName
	 * @param @param beanDefinition
	 * @return 
	 * @author Free
	 * @date 2018年11月10日 上午11:59:50 
	 * @throws
	 */
	public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
		beanDefinitionMaps.put(beanName, beanDefinition);
	}

	public abstract Object createBean(BeanDefinition beanDefinition);

	public abstract void evaluationBeanProperties(Object object, BeanDefinition beanDefinition);

	public boolean containsKey(String beanName) {
		return this.beanDefinitionMaps.containsKey(beanName);
	}

}
