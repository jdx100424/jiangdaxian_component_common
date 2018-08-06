package com.jiangdaxian.common.aop.interceptor.service;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(0)
public class DefaultServiceInterceptor extends BaseServiceInterceptor {
	private static final Logger LOGGER = LoggerFactory.getLogger(DefaultServiceInterceptor.class);

	public DefaultServiceInterceptor() {
		LOGGER.info("{} {}_service Interceptor is start", DefaultServiceInterceptor.class.getName());
	}

	@Override
	@Pointcut("execution(* com.jiangdaxian.*.service.*.*(..))")
	public void pointcut() {

	}
}
