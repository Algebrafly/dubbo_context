package com.algebra.dubbo.controller;

import com.algebra.dubbo.api.ISayHelloService;
import com.algebra.dubbo.api.IGetInfoService;
import com.algebra.dubbo.filter.DubboParam;
import com.alibaba.dubbo.config.annotation.Reference;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author haha
 */
@RestController
@Slf4j
public class SayHelloController {

    @Reference
    private ISayHelloService sayHelloService;
    @Reference
    private IGetInfoService getInfoService;

    @GetMapping("/getInfoTest")
    public String getInfoTest(@RequestParam("name") String name){
        log.info("[consumer-01]--------->>调用成功,traceId = {}",DubboParam.getInstance().getTraceId());
        return sayHelloService.sayHello(name);
    }

    @GetMapping("/dubboTest")
    public String dubboTest() {

        String time;
        time = "开始时间:" + new Date().toString();
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        for (int i = 0; i < 10000; i++) {
            log.info("调用生产者");
            String dubbo = sayHelloService.sayHello("dubbo");
            log.info("调用结果：" + dubbo);
        }
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

        System.out.println(time);
        System.out.println("结束时间:" + new Date().toString());
        time += "结束时间:" + new Date().toString();

//		log.info("调用生产者1");
//		String dubbo1 = IGetInfoService.sayHello2("dubbo");
//		log.info("调用结果："+dubbo1);
//		return "1:"+dubbo+"----2:"+dubbo1;
        return time;
    }

    @GetMapping("/dubbo")
    public String dubbo() {
        log.info("调用生产者");
        String dubbo = sayHelloService.sayHello("dubbo");
        log.info("调用结果：" + dubbo);

        log.info("调用生产者1");
        String dubbo1 = getInfoService.getInfo("dubbo");
        log.info("调用结果：" + dubbo1);
        return "1:" + dubbo + "----2:" + dubbo1;
    }


}
