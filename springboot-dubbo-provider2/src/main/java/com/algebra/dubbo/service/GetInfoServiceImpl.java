package com.algebra.dubbo.service;

import com.algebra.dubbo.api.IGetInfoService;
import com.algebra.dubbo.filter.DubboParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;

/**
 * @author haha
 */
@Service(timeout = 3000)
@Component
@Slf4j
public class GetInfoServiceImpl implements IGetInfoService {

	@Override
	public String getInfo(String name) {
		log.info("[provider-02]--------->>调用成功,traceId = {}",DubboParam.getInstance().getTraceId());
		return name+":18:male";
	}
}
