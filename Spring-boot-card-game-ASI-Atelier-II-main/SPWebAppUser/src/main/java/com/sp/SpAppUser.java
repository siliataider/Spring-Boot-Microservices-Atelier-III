package com.sp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SpAppUser {

	public static void main(String[] args) {
		SpringApplication.run(SpAppUser.class,args);
	}

}

