package com.animals;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;

public class Client {
	public static void main(String atgs[]) {
		ApplicationContext context=new ClassPathXmlApplicationContext("config.xml");
		Cat cat=(Cat)context.getBean("cat");
		System.out.println(cat.toString());
		
		Dog dog=(Dog)context.getBean("dog");
		System.out.println(dog.toString());
		
//		Frog frog=(Frog)context.getBean("frog");
//		System.out.println(frog.toString());
	}
}
