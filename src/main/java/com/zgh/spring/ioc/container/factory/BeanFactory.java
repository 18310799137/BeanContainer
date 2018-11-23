package com.zgh.spring.ioc.container.factory;

public interface BeanFactory {

	/**
	 * 
	 * @Title: getBean
	 * @Description: 对象获取
	 * @param @param beanName
	 * @param @return
	 * @return Object
	 * @author Free
	 * @date 2018年11月10日 下午12:00:59 
	 * @throws
	 */
	Object getBean(String beanName);

}
