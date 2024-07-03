package com.samples.Task_1.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;

@Component
public class SpringBootRunner implements CommandLineRunner {
	@Value("${my.info.student.id}")
	private int studId;
	
	@Value("${my.info.student.name}")
	private String studName;
	
	@Value("${my.info.student.classs}")
	private String classs;
	
	@Override
	public String toString() {
		return "SpringBootRunner [Student Id= " + studId + ",Student Name= " + studName + ",Class = " + classs + "]";
	}
	
	//override the run method
	public void run(String...args) throws Exception {
		System.out.println(this);
	}
}
