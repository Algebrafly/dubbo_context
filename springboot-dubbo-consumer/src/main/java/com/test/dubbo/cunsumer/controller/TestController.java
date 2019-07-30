package com.test.dubbo.cunsumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.test.dubbo.api.DubboTestApi;
import com.test.dubbo.api.DubboTestApi2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class TestController {
	@Reference
	private DubboTestApi dubboTestApi;
	@Reference
	private DubboTestApi2 dubboTestApi2;
	@GetMapping("/dubboTest")
	public String dubboTest() {
		log.info("调用生产者");
		String dubbo = dubboTestApi.sayHello("dubbo");
		log.info("调用结果："+dubbo);
		log.info("调用生产者1");
		String dubbo1 = dubboTestApi2.sayHello2("dubbo");
		log.info("调用结果："+dubbo1);
		return "1:"+dubbo+"----2:"+dubbo1;
	}
}
