package com.test.dubbo.provider.apiService;


import com.alibaba.dubbo.config.annotation.Reference;
import com.test.dubbo.api.DubboTestApi2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.test.dubbo.api.DubboTestApi;

@Service(interfaceClass = DubboTestApi.class,retries = -1)
@Component
@Slf4j
public class DubboTestApiService implements DubboTestApi{

    @Reference
	DubboTestApi2 dubboTestApi2;

	@Override
	public String sayHello(String name) {

		log.info("调用成功");

		 name = dubboTestApi2.sayHello2(name);

		return "Hello1-->"+name ;
	}

}
