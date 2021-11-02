package com.andrewsavich.bajter.cartridgerefillservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class CartridgeRefillServiceApplication {

	public static void main(String[] args) {
		log.info("Starting app");
		SpringApplication.run(CartridgeRefillServiceApplication.class, args);
	}

}
