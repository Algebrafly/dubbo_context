package com.algebra.dubbo.apiService;


import com.algebra.dubbo.api.DubboTestApi;
import com.algebra.dubbo.api.DubboTestApi2;
import com.alibaba.dubbo.config.annotation.Reference;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;

@Service(interfaceClass = DubboTestApi.class,retries = -1)
@Component
@Slf4j
public class DubboTestApiService implements DubboTestApi{

    @Reference
    DubboTestApi2 dubboTestApi2;

    @Autowired
	TestService testService;
	@Override
	public String sayHello(String name) {

		log.info("调用成功");

		 name = dubboTestApi2.sayHello2(name);
		testService.hello(name);
		return "Hello1-->"+name ;
	}

}
