package com.jiangdaxian.common.aop.interceptor.service;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.fastjson.JSONObject;
import com.jiangdaxian.common.aop.interceptor.BaseInterceptor;
import com.jiangdaxian.common.base.BaseInfoContext;
import com.jiangdaxian.common.dubbo.filter.constant.DubboFilterConstant;

public abstract class BaseServiceInterceptor extends BaseInterceptor {
	private static final Logger LOGGER = LoggerFactory.getLogger(BaseServiceInterceptor.class);

	/**
	 * 业务拦截器，在指定时间内，增加对相同的请求ID进行拦截，
	 */
	@Around("pointcut()")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		Object targetObject = pjp.getTarget();
		String method = pjp.getSignature().getName();

		Class<?>[] parameterTypes = ((MethodSignature) pjp.getSignature()).getMethod().getParameterTypes();

		try {
			Map<String, String> map = new HashMap<String, String>();
			map.put(DubboFilterConstant.BASE_INFO_CONTEXT, JSONObject.toJSONString(BaseInfoContext.get()));
			RpcContext.getContext().setAttachments(map);

			// 原来的逻辑运行
			if(LOGGER.isDebugEnabled()) {
				LOGGER.debug("aop pjp.proceed() start,{}",System.currentTimeMillis());
			}
			Object result = pjp.proceed();
			if(LOGGER.isDebugEnabled()) {
				LOGGER.debug("aop pjp.proceed() end,{}",System.currentTimeMillis());
			}
			return result;
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			throw e;
		}
	}
}
