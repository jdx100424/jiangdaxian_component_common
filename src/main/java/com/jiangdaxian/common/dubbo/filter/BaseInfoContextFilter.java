package com.jiangdaxian.common.dubbo.filter;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.dubbo.rpc.Filter;
import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.Result;
import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.dubbo.rpc.RpcException;
import com.alibaba.dubbo.rpc.RpcInvocation;
import com.alibaba.fastjson.JSONObject;
import com.jiangdaxian.common.base.BaseInfoContext;
import com.jiangdaxian.common.dubbo.filter.constant.DubboFilterConstant;

public class BaseInfoContextFilter implements Filter{
	private static final Logger LOG = LoggerFactory.getLogger(BaseInfoContextFilter.class);

	@Override
	public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
		Map<String,String> map = RpcContext.getContext().getAttachments();
		LOG.info("BaseInfoContextFilter map is:{}",JSONObject.toJSONString(map));
		BaseInfoContext baseInfoContext = JSONObject.parseObject(map.get(DubboFilterConstant.BASE_INFO_CONTEXT),BaseInfoContext.class);
		if(baseInfoContext!=null){
			BaseInfoContext.get().setRequestId(baseInfoContext.getRequestId());
		}
		if(invocation instanceof RpcInvocation){
			((RpcInvocation)invocation).setInvoker(invoker);
		}
		return invoker.invoke(invocation);
	}
}
