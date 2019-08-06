package com.algebra.dubbo.kafka;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author al
 * @date 2019/7/17 9:03
 * @description
 */
public interface LogSink {

    /**
     * Input channel name.
     */
    String WF_INPUT = "log_input";

    /**
     * @return input channel.
     */
    @Input(LogSink.WF_INPUT)
    SubscribableChannel logInput();

}
