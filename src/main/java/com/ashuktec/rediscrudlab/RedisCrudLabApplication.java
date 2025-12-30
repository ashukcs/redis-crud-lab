package com.ashuktec.rediscrudlab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class RedisCrudLabApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedisCrudLabApplication.class, args);
	}

}
