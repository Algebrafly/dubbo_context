package com.test.dubbo.cunsumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.rpc.RpcContext;
import com.test.dubbo.api.DubboTestApi;
import com.test.dubbo.api.TestObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@Reference
	private DubboTestApi dubboTestApi;
	
	@GetMapping("/dubboTest")
	public String dubboTest() {
        System.out.println(RpcContext.getContext().getAttachment("baseInfo"));
        System.out.println("============================");
		return dubboTestApi.sayHello("dubbo");
	}
}
