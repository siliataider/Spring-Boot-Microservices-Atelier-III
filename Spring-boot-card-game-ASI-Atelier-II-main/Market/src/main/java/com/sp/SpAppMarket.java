package com.sp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SpAppMarket {
	
	public static void main(String[] args) {
		SpringApplication.run(SpAppMarket.class,args);
	}


}
