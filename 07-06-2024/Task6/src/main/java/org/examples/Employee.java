package org.examples;
//bean component or model class
public class Employee {
	private int id;
	private String name;
	private float salary;
	//constructor
	public Employee() {}
	public Employee(int id) {
		super();
		this.id = id;
	}
	public Employee(float salary,int id) {
		super();
		this.salary = salary;
		this.id = id;
	}
	public Employee(int id, String name, float salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	@Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
    }
}