package com.test.dubbo.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;

@EnableDubboConfiguration
@SpringBootApplication
public class SpringbootDubboProvider2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDubboProvider2Application.class, args);
	}
}
