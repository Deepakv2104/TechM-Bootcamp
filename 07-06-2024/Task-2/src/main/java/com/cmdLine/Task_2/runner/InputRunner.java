package com.cmdLine.Task_2.runner;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InputRunner implements CommandLineRunner {
	public void run(String...args)	throws Exception {
		System.out.println("Hello Command Line Runner");
		System.out.println(args[1]);
		System.out.println(Arrays.asList(args));
		System.out.println("End of Command Line Arguments");
	}
}
