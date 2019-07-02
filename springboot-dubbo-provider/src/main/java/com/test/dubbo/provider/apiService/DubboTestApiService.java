package com.test.dubbo.provider.apiService;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.rpc.RpcContext;
import com.test.dubbo.api.DubboTestApi2;
import com.test.dubbo.api.TestObject;
import com.test.dubbo.provider.filter.DubboParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.test.dubbo.api.DubboTestApi;

@Service(interfaceClass = DubboTestApi.class,retries = -1)
@Component
public class DubboTestApiService implements DubboTestApi{

    @Reference
    DubboTestApi2 dubboTestApi2;
    @Autowired
    DubboParam dubboParam;

	@Override
	public String sayHello(String name) {
        TestObject object = dubboParam.getDubboParam();
        System.out.println(object.toString());
		return "Hello:"+name +","+ dubboTestApi2.sayHello2(name);
	}

}
