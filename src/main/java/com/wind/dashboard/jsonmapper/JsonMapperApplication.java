package com.wind.dashboard.jsonmapper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = "com.wind.dashboard")
@EnableFeignClients
public class JsonMapperApplication {

	public static void main(String[] args) {
		SpringApplication.run(JsonMapperApplication.class, args);
	}

}

