package com.algebra.dubbo.apiService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
@Slf4j
@Service
public class TestService {

    public String hello(String name)
    {
        log.info("log:"+name);
        return "hello"+name;
    }

}
