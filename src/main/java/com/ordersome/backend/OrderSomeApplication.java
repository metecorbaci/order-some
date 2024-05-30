package com.ordersome.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan("com.ordersome.backend.model")
@SpringBootApplication
public class OrderSomeApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderSomeApplication.class, args);
	}

}
