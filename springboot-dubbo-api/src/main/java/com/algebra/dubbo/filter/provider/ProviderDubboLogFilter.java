package com.algebra.dubbo.filter.provider;

import com.algebra.dubbo.constant.MdcConstant;
import com.alibaba.dubbo.rpc.*;
import lombok.extern.slf4j.Slf4j;
import com.alibaba.dubbo.common.extension.Activate;
import org.slf4j.MDC;

@Slf4j
@Activate
public class ProviderDubboLogFilter implements Filter {

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {

        String traceId = RpcContext.getContext().getAttachment(MdcConstant.TRACE_ID);
        if (traceId != null && !"".equals(traceId)) {
            MDC.put(MdcConstant.TRACE_ID, traceId);
            log.info("生产者生产前------------>>调用链ID：{}", traceId);
            // 传递用户等信息
            String baseInfo = RpcContext.getContext().getAttachment(MdcConstant.BASTINFO);
            MDC.put(MdcConstant.BASTINFO, baseInfo);
        }

        return invoker.invoke(invocation);
    }

}
