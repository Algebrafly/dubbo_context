package com.algebra.dubbo.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

/**
 * @author al
 * @date 2019/8/30 16:10
 * @description
 */
@EnableBinding(LogSink.class)
@Slf4j
public class LogServiceMsgSink {

    @StreamListener(LogSink.WF_INPUT)
    public void messageSink(String msg) {
        log.info("Received-Msg from {}, msg content : {}", LogSink.WF_INPUT, msg);
        // todo


    }

}
