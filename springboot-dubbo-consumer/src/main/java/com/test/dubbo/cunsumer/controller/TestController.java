package com.test.dubbo.cunsumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.rpc.RpcContext;
import com.dubbolog.annotation.Log;
import com.dubbolog.annotation.LogTrack;
import com.dubbolog.annotation.LogTypeEnum;
import com.test.dubbo.api.DubboTestApi;
import com.test.dubbo.api.TestObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	Logger logger = LoggerFactory.getLogger(TestController.class);
	@Reference
	private DubboTestApi dubboTestApi;
	@Log(prefix = "消费者", value = LogTypeEnum.ALL)
	@LogTrack
	@GetMapping("/dubboTest")
	public String dubboTest() {
		logger.info("调用生产者");
		return dubboTestApi.sayHello("dubbo");
	}
}
