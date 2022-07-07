package com.gemini;

import com.gemini.Producer_consumer.Reader;
import com.gemini.Producer_consumer.Writer;
import com.gemini.Producer_consumer.book;
import com.gemini.imageUploading.repo.studentRepo;

import com.gemini.multithreading.Company;
import com.gemini.multithreading.Consumer;
import com.gemini.multithreading.Producer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
//@EnableCaching
//@EnableScheduling
//@ComponentScan({ "com.gemini.FactorySession","com.gemini.imageUploading"})
public class SpringbootDemoApplication {

//	@Autowired
//	private static operationFactory  operationFactory;
	public static final Logger logger= LoggerFactory.getLogger(SpringbootDemoApplication.class);

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(SpringbootDemoApplication.class, args);

		logger.info("Hello World");


//		Company company=new Company();
//		for(int i=0;i<10;i++) {
//			Producer producer = new Producer(company);
//			producer.start();}
//		for (int i=0;i<5;i++){
//			Consumer consumer = new Consumer(company);
//			consumer.start();}
//		//}

//		book book1 =new book();
//
//		for(int i=0;i<=5;i++) {
//			Reader r = new Reader(book1);
//			Writer w = new Writer(book1);
//			w.start();
//			r.start();
//		}








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
