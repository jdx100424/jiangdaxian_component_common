/**
 * Copyright (c) 2005-2011 springside.org.cn
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * $Id: PropertiesUtils.java 1504 2011-03-08 14:49:20Z calvinxiu $
 */
package com.jiangdaxian.common.util.properties;

import java.util.Properties;             

/**
 * Properties文件工具类.
 * 
 */
public abstract class PropertiesUtils {

	private static Properties defaultInitProperties;

	public static void setInitProperty(Properties props) {
		defaultInitProperties = props;
	}

	public static String getProperty(String name) {
		return defaultInitProperties.getProperty(name);
	}

	public static String getProperty(String name, String defaultValue) {
		if (defaultInitProperties.getProperty(name) == null || defaultInitProperties.getProperty(name).equals("")) {
			return defaultValue;
		}
		return defaultInitProperties.getProperty(name);
	}

}
