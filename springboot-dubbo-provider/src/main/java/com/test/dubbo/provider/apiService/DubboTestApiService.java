package com.test.dubbo.provider.apiService;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.rpc.RpcContext;
import com.dubbolog.annotation.Log;
import com.dubbolog.annotation.LogTrack;
import com.dubbolog.annotation.LogTypeEnum;
import com.test.dubbo.api.DubboTestApi2;
import com.test.dubbo.api.TestObject;
import com.test.dubbo.provider.filter.DubboParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.test.dubbo.api.DubboTestApi;

@Service(interfaceClass = DubboTestApi.class,retries = -1)
@Component
public class DubboTestApiService implements DubboTestApi{

//    @Reference
//    DubboTestApi2 dubboTestApi2;
//    @Autowired
//    DubboParam dubboParam;
Logger logger = LoggerFactory.getLogger(DubboTestApiService.class);
    @Log(prefix = "生产者", value = LogTypeEnum.ALL)
    @LogTrack
	@Override
	public String sayHello(String name) {
//        TestObject object = dubboParam.getDubboParam();
//        System.out.println(object.toString());
        logger.info("调用成功");
		return "Hello:"+name ;
//        ","+ dubboTestApi2.sayHello2(name)
	}

}
