package com.algebra.dubbo.interceptor;

import com.algebra.dubbo.constant.MdcConstant;
import com.algebra.dubbo.domain.TestObject;
import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * 权限(Token)验证
 *
 * @author chen
 * @email sunlightcs@gmail.com
 * @date 2017-03-23 15:38
 */
@Component
public class AuthorizationInterceptor extends HandlerInterceptorAdapter {
    Logger logger = LoggerFactory.getLogger(AuthorizationInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler) throws Exception {


        TestObject object = new TestObject();
        object.setHello(UUID.randomUUID().toString());
        object.setName("tom");
        RpcContext.getContext().setAttachment("baseInfo",JSON.toJSONString(object));


        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        MDC.put(MdcConstant.TRACE_ID, uuid);

        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Headers", "Authorization, Content-Type, X-Requested-With, token");
        response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, OPTIONS, POST, PUT, DELETE");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Max-Age", "3600");
    }

}