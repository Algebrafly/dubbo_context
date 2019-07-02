package com.test.dubbo.provider.apiService;

import com.alibaba.dubbo.rpc.RpcContext;
import com.test.dubbo.api.DubboTestApi2;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.test.dubbo.api.DubboTestApi;

@Service(interfaceClass = DubboTestApi2.class,retries = -1)
@Component
public class DubboTestApiService2 implements DubboTestApi2 {

	@Override
	public String sayHello2(String name) {
		System.out.println(RpcContext.getContext().getAttachment("baseInfo"));
		return name + "go!";
	}

}
