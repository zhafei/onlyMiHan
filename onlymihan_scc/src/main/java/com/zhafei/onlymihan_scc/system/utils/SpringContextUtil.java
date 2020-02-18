package com.zhafei.onlymihan_scc.system.utils;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 
 * 获取spring容器，以访问容器中定义的其他bean
 * @author
 */
public class SpringContextUtil implements ApplicationContextAware {

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

	}
}
