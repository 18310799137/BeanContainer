package com.zgh.spring.ioc.container.factory;

import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;

import com.zgh.spring.ioc.container.bean.BeanDefinition;
import com.zgh.spring.ioc.container.bean.BeanProperty;
import com.zgh.spring.ioc.container.bean.BeanPropertys;
/**
 * BeanFactory实现类
 * @author Administrator
 *
 */
public class DefaultBeanFactory extends AbstractBeanFactory {

	/**
	 * 创建完整实例Bean
	 */
	public Object createBean(BeanDefinition beanDefinition) {
		Object object = newInstance(beanDefinition);
		assignmentBeanProperties(object, beanDefinition);
		return object;
	}

	/**
	 * 创建类型实例
	 * @param beanDefinition
	 * @return
	 */
	public Object newInstance(BeanDefinition beanDefinition) {
		Object newInstance = null;
		try {
			newInstance = Class.forName(beanDefinition.getClassName()).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return newInstance;
	}
	
	@Override
	public void assignmentBeanProperties(Object object, BeanDefinition beanDefinition) {
		BeanPropertys beanPropertys = beanDefinition.getBeanPropertys();
		List<BeanProperty> beanProperties = beanPropertys.getBeanProperties();
		Iterator<BeanProperty> iterator = beanProperties.iterator();
		while(iterator.hasNext()) {
			BeanProperty next = iterator.next();
			try {
				Field declaredField = object.getClass().getDeclaredField(next.getPropertyName());
				declaredField.setAccessible(true);
				declaredField.set(object, next.getPropertyValue());
			} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
			
			
		}
	}

}
