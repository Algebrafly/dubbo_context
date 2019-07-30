package com.test.dubbo.provider.filter;

import com.alibaba.dubbo.rpc.*;

import com.test.dubbo.api.MdcConstant;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.dubbo.common.extension.Activate;
import org.slf4j.MDC;
@Slf4j
@Activate
public class ProviderDubboLogFilter implements Filter {
    

    protected final static Logger logger = LoggerFactory.getLogger(ProviderDubboLogFilter.class);
    
	@Override
	public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {

		String traceId = RpcContext.getContext().getAttachment(MdcConstant.TRACE_ID);
		//存放到Slf4j的Mdc容器
		MDC.put(MdcConstant.TRACE_ID, traceId);
		log.info("生产者生产前：调用链ID："+traceId);
		// 传递用户信息
		String bastinfo = RpcContext.getContext().getAttachment(MdcConstant.BASTINFO);
		//存放到Slf4j的Mdc容器
		MDC.put(MdcConstant.BASTINFO, bastinfo);

		return invoker.invoke(invocation);
	}

}
