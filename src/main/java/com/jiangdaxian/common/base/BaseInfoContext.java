package com.jiangdaxian.common.base;

public class BaseInfoContext extends BaseContext{
	public BaseInfoContext(){
		
	}
	
	private static final ThreadLocal<BaseInfoContext> local = new ThreadLocal<BaseInfoContext>(){
		protected BaseInfoContext initialValue(){
			return new BaseInfoContext();
		};
	};
	
	public static BaseInfoContext get(){
		return local.get();
	}
	
	public static void clear(){
		local.remove();
	}
	
	private Long userId;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
}
