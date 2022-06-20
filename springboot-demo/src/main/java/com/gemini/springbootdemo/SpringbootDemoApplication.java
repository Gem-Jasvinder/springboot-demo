package com.gemini.springbootdemo;

import com.gemini.springbootdemo.singletonPattern.SingletonType1;
import com.gemini.springbootdemo.singletonPattern.SychronisedSingleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Collections;

@SpringBootApplication
public class SpringbootDemoApplication {

	public static final Logger logger= LoggerFactory.getLogger(SpringbootDemoApplication.class);

	public static void main(String[] args) {

		ConfigurableApplicationContext context=SpringApplication.run(SpringbootDemoApplication.class, args);
		logger.info("Hello World");

		SingletonType1 singletonType1=context.getBean(SingletonType1.class);
		System.out.println(singletonType1);
		SingletonType1 singletonType11=context.getBean(SingletonType1.class);
		System.out.println(singletonType11);
		SychronisedSingleton sychronisedSingleton=context.getBean(SychronisedSingleton.class);
		System.out.println(sychronisedSingleton);
		SychronisedSingleton sychronisedSingleton1=context.getBean(SychronisedSingleton.class);
		System.out.println(sychronisedSingleton1);
	}

}
