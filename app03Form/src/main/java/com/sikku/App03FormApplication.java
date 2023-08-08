package com.sikku;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.sikku.*")
public class App03FormApplication {

	public static void main(String[] args) {
		SpringApplication.run(App03FormApplication.class, args);
	}

}
