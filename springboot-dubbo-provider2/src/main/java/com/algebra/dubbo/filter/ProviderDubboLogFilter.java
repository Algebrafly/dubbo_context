package com.algebra.dubbo.filter;

import com.algebra.dubbo.constant.MdcConstant;
import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.rpc.*;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
@Slf4j
@Activate
public class ProviderDubboLogFilter implements Filter {
    

    protected final static Logger logger = LoggerFactory.getLogger(ProviderDubboLogFilter.class);
    
	@Override
	public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
//		logger.info(invocation.toString());
//		logger.info(invocation.getAttachment("baseInfo"));
//		InvokeLog invokeLog = new InvokeLog();
//		RpcContext.getContext().setAttachment("baseInfo",invocation.getAttachment("baseInfo"));
//

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
