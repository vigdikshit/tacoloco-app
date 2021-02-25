package com.tacoLoco.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class TacoLocoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TacoLocoApplication.class, args);
	}

}
