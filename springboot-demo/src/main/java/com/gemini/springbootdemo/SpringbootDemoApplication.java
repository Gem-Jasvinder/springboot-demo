package com.gemini.springbootdemo;

import com.gemini.FactorySession.Operations;
import com.gemini.FactorySession.operationFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.Collections;

@SpringBootApplication
@ComponentScan({ "com.gemini.FactorySession"})
public class SpringbootDemoApplication {

//	@Autowired
//	private static operationFactory  operationFactory;
	public static final Logger logger= LoggerFactory.getLogger(SpringbootDemoApplication.class);

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(SpringbootDemoApplication.class, args);

		logger.info("Hello World");

		operationFactory operationFactory1 = context.getBean(operationFactory.class);
		Operations operations = operationFactory1.doOperations("READ");
		operations.Connection();
		operations.ExcuteQuery();
		operations.CloseConnection();

	}

}
