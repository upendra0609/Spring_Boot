package com.sikku;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.sikku.*")
public class App04JdbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(App04JdbcApplication.class, args);
	}

}
