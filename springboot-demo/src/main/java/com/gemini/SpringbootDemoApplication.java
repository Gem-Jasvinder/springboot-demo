package com.gemini;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringbootDemoApplication {

	public static final Logger logger= LoggerFactory.getLogger(SpringbootDemoApplication.class);

	public static void main(String[] args) {

		ConfigurableApplicationContext applicationContext =SpringApplication.run(SpringbootDemoApplication.class, args);
		logger.info("Hello World");

		System.out.println("Hello Aditya ");
		System.out.println("Hello DIVYANSH");





		Object bean = applicationContext.getBean("myProp");



		String myProp = (String) bean;



//      ProfileConfig obj1 = new ProfileConfig();

//      Log.info(""+obj1.hashCode());

//      ProfileConfig obj2 = new ProfileConfig();

//      Log.info(""+obj2.hashCode());



		logger.info(" User Welcome to Rest");

		System.out.println(myProp);

	}


}
