package com.algebra.logservice.kafka;

import com.algebra.dubbo.kafka.LogSink;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

import java.util.HashMap;

/**
 * @author al
 * @date 2019-07-12
 * @desc kafka消息监听类
 */
@EnableBinding(LogSink.class)
@Slf4j
public class LogMsgSink {


	@StreamListener(LogSink.WF_INPUT)
	public void messageSink(String msg) {
		log.info("Received-Msg from {}, msg content : {}", LogSink.WF_INPUT, msg);
		HashMap msgMap = JSON.parseObject(msg,HashMap.class);



	}

}
