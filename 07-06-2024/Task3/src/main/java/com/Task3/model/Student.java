package com.Task3.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Student {
	@Id
	@GeneratedValue
	private Integer roll;
	private String name;
	private Integer marks;
	
	public Student() {
		super();
	}
	
	public Student(Integer roll) {
		super();
		this.roll=roll;
	}
	
	public Student(String name,Integer marks) {
		super();
		this.name=name;
		this.marks=marks;
	}
	
	public Student(Integer roll,String name,Integer marks) {
		super();
		this.roll=roll;
		this.name=name;
		this.marks=marks;
	}
	
	public void setRoll(Integer roll) {
		this.roll=roll;
	}
	public Integer getRoll() {
		return roll;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	public String getName() {
		return name;
	}
	
	public void setMarks(Integer marks) {
		this.marks=marks;
	}
	public Integer getMarks() {
		return marks;
	}
	
	@Override
	  public String toString() {
		  return "Student[Roll = " + roll + ",Name = " + name + ",Marks = " + marks + "]";
	  }
}
