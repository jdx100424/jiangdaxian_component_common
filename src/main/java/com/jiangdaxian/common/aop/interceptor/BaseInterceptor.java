package com.jiangdaxian.common.aop.interceptor;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 拦截器
 */
public abstract class BaseInterceptor {
	public abstract Object around(ProceedingJoinPoint pjp) throws Throwable;

	/**
	 * 使用标记定义切割范围 例如 @Pointcut("execution(* com.xx.xx.service..*.*(..))")
	 */
	public abstract void pointcut();
}
