package com.dubbolog.aspect;


import com.dubbolog.constants.MdcConstant;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.UUID;

/**
 * 设置在输出日志钱需要设置sessionID到MDC容器(占时没用)
 *
 * @author yuhao.wang3
 */
@Aspect
@Component
@Order(-10000)
public class LogTrackAspect {
    private static final Logger logger = LoggerFactory.getLogger(LogTrackAspect.class);

    @Pointcut("@annotation(com.dubbolog.annotation.Log) || @annotation(com.dubbolog.annotation.LogTrack)")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        boolean isSuccess = setMdc();
        try {
            // 执行方法，并获取返回值
            return joinPoint.proceed();
        } catch (Throwable t) {
            throw t;
        } finally {
            try {
                if (isSuccess) {
//                    MDC.remove(MdcConstant.BASTINFO);
                    MDC.remove(MdcConstant.TRACE_ID);
                }
            } catch (Exception e) {
                logger.warn(e.getMessage(), e);
            }
        }
    }

    /**
     * 为每个请求设置唯一标示到MDC容器中
     *
     * @return
     */
    private boolean setMdc() {
        try {
            // 设置SessionId
            if (StringUtils.isEmpty(MDC.get(MdcConstant.TRACE_ID))) {
                String sessionId = UUID.randomUUID().toString();
//                String requestId = UUID.randomUUID().toString().replace("-", "");
                MDC.put(MdcConstant.TRACE_ID, sessionId);
//                MDC.put(MdcConstant.REQUEST_KEY, requestId);
                return true;
            }
        } catch (Exception e) {
            logger.warn(e.getMessage(), e);
        }
        return false;
    }

}