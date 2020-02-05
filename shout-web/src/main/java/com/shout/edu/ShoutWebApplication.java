package com.shout.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class ShoutWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoutWebApplication.class, args);
	}

}
