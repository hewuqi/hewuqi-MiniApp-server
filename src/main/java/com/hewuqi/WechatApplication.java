package com.hewuqi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@MapperScan("com.hewuqi.*.dao")
public class WechatApplication {
	public static void main(String[] args) {
		SpringApplication.run(WechatApplication.class, args);
	}
}
