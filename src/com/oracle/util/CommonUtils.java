package com.oracle.util;

import java.util.Map;
import java.util.UUID;

import org.apache.commons.beanutils.BeanUtils;

public class CommonUtils {
	
	public static String uuid() {
		return UUID.randomUUID().toString().replace("-", "").toUpperCase();
	}
	// 把map转换成指定类型的javaBean对象
	public static <T> T toBean(Map map, Class<T> clazz) {
		try {
			/*
			 * 1. 创建指定类型的javabean对象
			 */
			T bean = clazz.newInstance();
			/*
			 * 2. 把数据封装到javabean中
			 */
			BeanUtils.populate(bean, map);
			/*
			 * 3. 返回javabean对象
			 */
			return bean;
		} catch(Exception e) {
			throw new RuntimeException(e);		//如果想让用户调用时不用try-catch，使用throw new RuntimeException(e)来抛出运行异常
		}
	}
}
