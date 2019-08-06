
package com.algebra.dubbo.filter;

import com.algebra.dubbo.constant.MdcConstant;
import com.algebra.dubbo.domain.SayHello;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;

/**
 * @author al
 * @date 2019/7/2 17:04
 * @description
 */
@Slf4j
@Data
public class DubboParam {

    private String traceId;

    private SayHello sayHello;

    private static DubboParam instance;

    private DubboParam(){
        getDubboParam();
    }

    public static DubboParam getInstance(){
        if (instance == null) {
            synchronized (DubboParam.class) {
                if (instance == null) {
                    instance = new DubboParam();
                }
            }
        }
        return instance;
    }

    /**
     * 从MDC容器中获取链路数据
     */
    private void getDubboParam(){
        traceId = MDC.get(MdcConstant.TRACE_ID);
        String sayHelloStr = MDC.get(MdcConstant.BASTINFO);
        sayHello = JSONObject.parseObject(sayHelloStr,SayHello.class);
        log.info("获取到MDC容器的参数----->>>> {}:{}",traceId,sayHello);
    }

}