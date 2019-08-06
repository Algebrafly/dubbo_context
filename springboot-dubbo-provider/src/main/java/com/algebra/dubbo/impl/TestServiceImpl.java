package com.algebra.dubbo.impl;

import com.algebra.dubbo.filter.DubboParam;
import com.algebra.dubbo.interfaces.ITestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
/**
 * @author haha
 */
@Slf4j
@Service
public class TestServiceImpl implements ITestService {

    @Override
    public String hello(String info) {
        log.info("[provider-01]--------->>调用成功,traceId = {}",DubboParam.getInstance().getTraceId());
        String name = info.split(":")[0];
        return "Hello "+name +"---------->>{TraceInfo："+DubboParam.getInstance().getTraceId()+"}";
    }

}
