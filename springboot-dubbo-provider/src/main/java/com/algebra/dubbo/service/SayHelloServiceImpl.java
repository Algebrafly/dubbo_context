package com.algebra.dubbo.service;


import com.algebra.dubbo.api.IGetInfoService;
import com.algebra.dubbo.api.ISayHelloService;
import com.algebra.dubbo.filter.DubboParam;
import com.algebra.dubbo.interfaces.ITestService;
import com.alibaba.dubbo.config.annotation.Reference;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;

/**
 * @author haha
 */
@Service(timeout = 3000)
@Component
@Slf4j
public class SayHelloServiceImpl implements ISayHelloService {

    @Reference
    IGetInfoService getInfoService;
    @Autowired
    ITestService testService;

	@Override
	public String sayHello(String name) {

		log.info("[provider-01]--------->>调用成功,traceId = {}",DubboParam.getInstance().getTraceId());
		String result = getInfoService.getInfo(name);
		return testService.hello(result);
	}

}
