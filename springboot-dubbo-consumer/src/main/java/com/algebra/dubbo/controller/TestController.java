package com.algebra.dubbo.controller;

import com.algebra.dubbo.api.DubboTestApi;
import com.algebra.dubbo.api.DubboTestApi2;
import com.alibaba.dubbo.config.annotation.Reference;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@Slf4j
public class TestController {
    @Reference
    private DubboTestApi dubboTestApi;
    @Reference
    private DubboTestApi2 dubboTestApi2;

    @GetMapping("/dubboTest")
    public String dubboTest() {

        String time;
        time = "开始时间:" + new Date().toString();
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        for (int i = 0; i < 10000; i++) {
            log.info("调用生产者");
            String dubbo = dubboTestApi.sayHello("dubbo");
            log.info("调用结果：" + dubbo);
        }
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

        System.out.println(time);
        System.out.println("结束时间:" + new Date().toString());
        time += "结束时间:" + new Date().toString();

//		log.info("调用生产者1");
//		String dubbo1 = dubboTestApi2.sayHello2("dubbo");
//		log.info("调用结果："+dubbo1);
//		return "1:"+dubbo+"----2:"+dubbo1;
        return time;
    }

    @GetMapping("/dubbo")
    public String dubbo() {
        log.info("调用生产者");
        String dubbo = dubboTestApi.sayHello("dubbo");
        log.info("调用结果：" + dubbo);

        log.info("调用生产者1");
        String dubbo1 = dubboTestApi2.sayHello2("dubbo");
        log.info("调用结果：" + dubbo1);
        return "1:" + dubbo + "----2:" + dubbo1;
    }


}
