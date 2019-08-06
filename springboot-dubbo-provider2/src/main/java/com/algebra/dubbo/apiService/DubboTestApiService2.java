package com.algebra.dubbo.apiService;

import com.algebra.dubbo.api.DubboTestApi2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;

@Service(interfaceClass = DubboTestApi2.class,retries = -1)
@Component
@Slf4j
public class DubboTestApiService2 implements DubboTestApi2 {

	@Override
	public String sayHello2(String name) {

		log.info("调用成功");
		return "Hello2-->"+name;
	}

}
