package com.algebra.dubbo.kafka;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @author al
 * @date 2019/7/17 8:52
 * @description log模块专用kafka binder channel
 */
public interface LogSource {

    /**
     * Name of the output channel.
     */
    String WF_OUTPUT = "log_output";

    /**
     * @return output channel
     */
    @Output(LogSource.WF_OUTPUT)
    MessageChannel logOutput();

}
