package com.sikku.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.sikku.*")
public class Test {

	public static void main(String[] args) {
		System.out.println("spring Boot Application");
		SpringApplication.run(Test.class, args);
	}

}
