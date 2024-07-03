package com.Task4.repo.impl;


import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.Task4.model.Student;
import com.Task4.repo.StudentRepository;

@Component
public class StudentRunner implements CommandLineRunner {
	@Autowired
	private StudentRepository repo;
	
	public void run(String...args) throws Exception {
		while(true) {
			System.out.println("1. FetchAll");
			System.out.println("2. FetchById");
			System.out.println("3. Insert");
			System.out.println("4. Delete");
			System.out.println("5. Update");
			System.out.println("6. Stop");
			
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the option you want to perform: ");
			int ch=sc.nextInt();
			
			if(ch==1) {
				repo.findAll().forEach((System.out::println));
				System.out.println("Fetched all the Rows:");
			}else if(ch==2) {
				System.out.println("Enter the Student roll to fetch the details:");
				int roll=sc.nextInt();
				
				Optional <Student> student=repo.findById(roll);
				if(student.isPresent()) {
					System.out.println(student.get());
				}else {
					System.out.println("No Student with Roll " + roll);
				}
			}else if(ch==3) {
				System.out.println("Enter the Student Roll:");
				int roll=sc.nextInt();
				System.out.println("Enter the Student Name:");
				String name=sc.next();
				System.out.println("Enter the Student Marks:");
				int marks=sc.nextInt();
				Optional <Student> student=repo.findById(roll);
				if(student.isPresent()) {
					System.out.println("Student with roll " + roll + "already exist");
				}else {
					repo.save(new Student(roll,name,marks));
					System.out.println("Student Details Saved Successfully!");
				}
			}else if(ch==4) {
				System.out.println("Enter the Student roll to delete:");
				int roll=sc.nextInt();
				
				Optional <Student> student=repo.findById(roll);
				if(student.isPresent()) {
					repo.delete(student.get());
					System.out.println("Student Deleted Successfully");
				}else {
					System.out.println("No Student with Roll " + roll);
				}
			}else if(ch==5) {
				System.out.println("Enter the Student roll to update:");
				int roll=sc.nextInt();
				
				Optional<Student> student = repo.findById(roll);
				if(student.isPresent()) {
                    Student stud=student.get();
                    System.out.println("Enter the new Student Name:");
                    String name=sc.next();
                    System.out.println("Enter the new Student Marks:");
                    int marks=sc.nextInt();

                    stud.setName(name);
                    stud.setMarks(marks);

                    repo.save(stud);
                    System.out.println("Student Details Updated Successfully!");
                }else {
                    System.out.println("No Student with Roll " + roll);
                }
			}else if(ch==6) {
	                System.out.println("Stopping the application.");
	                break;
	        }else {
	        	System.out.println("Invalid option. Please try again");
			}
			System.out.println();
		}
	}
}
