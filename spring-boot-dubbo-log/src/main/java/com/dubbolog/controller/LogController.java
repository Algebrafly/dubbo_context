package com.dubbolog.controller;

import com.dubbolog.annotation.Log;
import com.dubbolog.annotation.LogTrack;
import com.dubbolog.annotation.LogTypeEnum;
import com.dubbolog.service.LogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuhao.wang
 */
@RestController
public class LogController {

    @Autowired
    private LogService logService;

    Logger logger = LoggerFactory.getLogger(LogController.class);

    @RequestMapping(value = "log", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Log(prefix = "日志测试接口", value = LogTypeEnum.ALL)
    @LogTrack
    public Object sendMsg() {
//        logService.log();

        logger.info("成功");

        return "发送成功";
    }

}