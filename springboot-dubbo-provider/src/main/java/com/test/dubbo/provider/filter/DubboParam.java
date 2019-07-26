package com.test.dubbo.provider.filter;

import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.fastjson.JSONObject;
import com.test.dubbo.api.TestObject;
import org.springframework.stereotype.Component;

/**
 * @author al
 * @date 2019/7/2 17:04
 * @description
 */
@Component
public class DubboParam extends TestObject{

    public DubboParam(){

    }

//    public DubboParam(){
//        TestObject object = new TestObject();
//        object = getDubboParam();
//
//    }

    public TestObject getDubboParam(){
        String param = RpcContext.getContext().getAttachment("baseInfo");

        System.out.println(param);

        return JSONObject.parseObject(param,TestObject.class);
    }

}
