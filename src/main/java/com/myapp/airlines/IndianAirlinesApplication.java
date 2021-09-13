package com.myapp.airlines;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication()
public class IndianAirlinesApplication {

	public static void main(String[] args) {
		SpringApplication.run(IndianAirlinesApplication.class, args);
	}

}
