package com.test.dubbo.provider.filter;

import java.util.Date;

import com.alibaba.dubbo.rpc.*;
import com.dubbolog.constants.MdcConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.fastjson.JSON;
import com.google.common.base.Throwables;
import org.slf4j.MDC;

@Activate
public class DubboLogFilter implements Filter {
    

    protected final static Logger logger = LoggerFactory.getLogger(DubboLogFilter.class);
    
	@Override
	public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
		logger.info(invocation.toString());
		logger.info(invocation.getAttachment("baseInfo"));
		InvokeLog invokeLog = new InvokeLog();
		RpcContext.getContext().setAttachment("baseInfo",invocation.getAttachment("baseInfo"));


		String traceId = RpcContext.getContext().getAttachment(MdcConstant.TRACE_ID);
		//存放到Slf4j的Mdc容器
		MDC.put(MdcConstant.TRACE_ID, traceId);

		// 传递用户信息
		String bastinfo = RpcContext.getContext().getAttachment(MdcConstant.BASTINFO);
		//存放到Slf4j的Mdc容器
		MDC.put(MdcConstant.BASTINFO, bastinfo);

		return invoker.invoke(invocation);
	}

}
