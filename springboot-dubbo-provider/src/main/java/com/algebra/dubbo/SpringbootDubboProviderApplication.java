package com.algebra.dubbo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;

@EnableDubboConfiguration
@SpringBootApplication
public class SpringbootDubboProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDubboProviderApplication.class, args);
	}
}
