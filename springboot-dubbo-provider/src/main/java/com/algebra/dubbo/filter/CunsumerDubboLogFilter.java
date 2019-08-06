package com.algebra.dubbo.filter;

import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.rpc.*;
import com.dubbolog.constants.MdcConstant;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;

@Slf4j
@Activate
public class CunsumerDubboLogFilter implements Filter {

	@Override
	public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {

		// 传递日志唯一标识
		String traceId = MDC.get(MdcConstant.TRACE_ID);
		RpcContext.getContext().setAttachment(MdcConstant.TRACE_ID, traceId);
		log.info("消费者消费前：调用链ID："+traceId);
		// 传递用户信息
		String bastinfo = MDC.get(MdcConstant.BASTINFO);
		RpcContext.getContext().setAttachment(MdcConstant.BASTINFO, bastinfo);

	
	return invoker.invoke(invocation);
	}
	
}
