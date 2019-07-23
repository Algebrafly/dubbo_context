package com.test.dubbo.cunsumer.filter;

import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.rpc.*;
import com.alibaba.fastjson.JSON;
import com.dubbolog.constants.MdcConstant;
import com.google.common.base.Throwables;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.util.Date;

@Activate
public class DubboLogFilter implements Filter {
    

    protected final static Logger logger = LoggerFactory.getLogger(DubboLogFilter.class);
    
	@Override
	public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {

		// 传递日志唯一标识
		String traceId = MDC.get(MdcConstant.TRACE_ID);
		RpcContext.getContext().setAttachment(MdcConstant.TRACE_ID, traceId);
		// 传递用户信息
		String bastinfo = MDC.get(MdcConstant.BASTINFO);
		RpcContext.getContext().setAttachment(MdcConstant.BASTINFO, bastinfo);

	
	return invoker.invoke(invocation);
	}
	
}
