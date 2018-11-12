package com.zgh.spring.ioc.container.factory;

import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;

import com.zgh.spring.ioc.container.bean.BeanDefinition;
import com.zgh.spring.ioc.container.bean.BeanProperty;
import com.zgh.spring.ioc.container.bean.BeanPropertys;
import com.zgh.spring.ioc.container.bean.BeanReference;
/**
 * BeanFactory实现类
 * @author Administrator
 *
 */
public abstract class BeanCreateFactory extends AbstractBeanFactory {

	/**
	 * 
	 * @Title: createBean
	 * @Description: 创建填充值后完整实例Bean
	 * @param @param beanDefinition
	 * @param @return
	 * @return 
	 * @author Free
	 * @date 2018年11月10日 下午12:00:26 
	 * @throws
	 */
	public Object createBean(BeanDefinition beanDefinition) {
		Object object = newInstance(beanDefinition);
		evaluationBeanProperties(object, beanDefinition);
		return object;
	}

	/**
	 * 
	 * @Title: newInstance
	 * @Description: 创建类型实例
	 * @param @param beanDefinition
	 * @param @return
	 * @return Object
	 * @author Free
	 * @date 2018年11月10日 下午12:00:06 
	 * @throws
	 */
	public Object newInstance(BeanDefinition beanDefinition) {
		Object newInstance = null;
		try {
			newInstance = ClassLoader.getSystemClassLoader().loadClass(beanDefinition.getClassName()).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return newInstance;
	}
	
	/**
	 * 
	 * @Title: evaluationBeanProperties
	 * @Description: bean property 赋值
	 * @param @param object
	 * @param @param beanDefinition
	 * @return 
	 * @author Free
	 * @date 2018年11月10日 上午11:58:07 
	 * @throws
	 */
	public void evaluationBeanProperties(Object object, BeanDefinition beanDefinition) {
		BeanPropertys beanPropertys = beanDefinition.getBeanPropertys();
		List<BeanProperty> beanProperties = beanPropertys.getBeanProperties();
		Iterator<BeanProperty> iterator = beanProperties.iterator();
		while(iterator.hasNext()) {
			BeanProperty next = iterator.next();
			try {
				Field declaredField = object.getClass().getDeclaredField(next.getPropertyName());
				declaredField.setAccessible(true);
				Object propertyValue = next.getPropertyValue();
				if(propertyValue instanceof BeanReference) {
					declaredField.set(object,getBean(((BeanReference)propertyValue).getRefName()));
				}else {
					declaredField.set(object,propertyValue);
				}
			} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
			
			
		}
	}

	/**
	 * 根据资源文件路径 价值Bean到容器
	 *  BeanCreateFactory.
	 *
	 * @param location
	 */
	public BeanCreateFactory(String location) {
		loadResourceToContainer(location);
	}

	public BeanCreateFactory() {
	}

	public abstract void loadResourceToContainer(String location);
}
