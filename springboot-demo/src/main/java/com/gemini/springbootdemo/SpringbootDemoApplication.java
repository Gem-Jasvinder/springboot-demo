package com.gemini.springbootdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class SpringbootDemoApplication {

	public static final Logger logger= LoggerFactory.getLogger(SpringbootDemoApplication.class);

	public static void main(String[] args) {

		SpringApplication.run(SpringbootDemoApplication.class, args);
		logger.info("Hello World");
		System.out.println("Hello Aditya ");
	}

}
