package com.algebra.dubbo.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;

/**
 * @author al
 * @date 2019-7-12
 * @Desc kafka-stream发送消息的服务工具
 */
@EnableBinding(LogSource.class)
@Slf4j
public class KafkaSendService {

	@Autowired
	private LogSource source;

	public void sendMessage(String msg) {
		try {
			source.logOutput().send(MessageBuilder.withPayload(msg).build());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
