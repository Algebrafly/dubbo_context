package com.algebra.dubbo.filter.consumer;

import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.rpc.*;
import com.dubbolog.constants.MdcConstant;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;

@Slf4j
@Activate
public class ConsumerDubboLogFilter implements Filter {

	@Override
	public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {

		String traceId = MDC.get(MdcConstant.TRACE_ID);
		if(traceId != null && !"".equals(traceId)){
			RpcContext.getContext().setAttachment(MdcConstant.TRACE_ID, traceId);
			log.info("消费者消费前------------>>调用链ID："+traceId);
			String baseInfo = MDC.get(MdcConstant.BASTINFO);
			RpcContext.getContext().setAttachment(MdcConstant.BASTINFO, baseInfo);
		}

		return invoker.invoke(invocation);
	}
	
}
