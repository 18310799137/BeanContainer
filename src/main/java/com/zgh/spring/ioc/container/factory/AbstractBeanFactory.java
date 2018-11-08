package com.zgh.spring.ioc.container.factory;

import java.util.HashMap;
import java.util.Map;

import com.zgh.spring.ioc.container.bean.BeanDefinition;

/**
 * Hello world!
 *
 */
public abstract class AbstractBeanFactory implements BeanFactory
{
	private Map<String, BeanDefinition>map = new HashMap<>();
	@Override
	public Object getBean(String beanName) {
		return map.get(beanName).getBean();
	}
	@Override
	public void registerBeanDefinition(String beanName ,BeanDefinition beanDefinition) {
		Object createBean = createBean(beanDefinition);
		beanDefinition.setBean(createBean);
		map.put(beanName, beanDefinition);
	}
   
	public abstract Object createBean(BeanDefinition beanDefinition);
	
	
	public abstract void assignmentBeanProperties(Object object,BeanDefinition beanDefinition);
	
}
