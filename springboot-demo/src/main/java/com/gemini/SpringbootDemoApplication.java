package com.gemini;

import com.gemini.imageUploading.repo.studentRepo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan({ "com.gemini.FactorySession","com.gemini.imageUploading"})
public class SpringbootDemoApplication {

//	@Autowired
//	private static operationFactory  operationFactory;
	public static final Logger logger= LoggerFactory.getLogger(SpringbootDemoApplication.class);

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(SpringbootDemoApplication.class, args);

		logger.info("Hello World");



//		operationFactory operationFactory1 = context.getBean(operationFactory.class);
//		Operations operations = operationFactory1.doOperations("READ");
//		operations.Connection();
//		operations.ExcuteQuery();
//		operations.CloseConnection();
//
//
//		SingletonType1 singletonType1=context.getBean(SingletonType1.class);
//		System.out.println(singletonType1);
//		SingletonType1 singletonType11=context.getBean(SingletonType1.class);
//		System.out.println(singletonType11);
//		SychronisedSingleton sychronisedSingleton=context.getBean(SychronisedSingleton.class);
//		System.out.println(sychronisedSingleton);
//		SychronisedSingleton sychronisedSingleton1=context.getBean(SychronisedSingleton.class);
//		System.out.println(sychronisedSingleton1);

	}

}
