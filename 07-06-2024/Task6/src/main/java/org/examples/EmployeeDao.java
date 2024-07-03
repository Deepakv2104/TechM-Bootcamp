package org.examples;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
//DAO class means that it contains all the Curd operations
//These Curd operations can be done using JDBCTemplate

public class EmployeeDao {
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public List<Employee> selectAllEmployees(Employee e){
		String query="select * from employee";
		List<Employee> employees = jdbcTemplate.query(query, (rs, rowNum) -> {
            Employee employee = new Employee();
            employee.setId(rs.getInt("id"));
            employee.setName(rs.getString("name"));
            employee.setSalary(rs.getFloat("salary"));
            return employee;
        });
        return employees;
	}
   //insert the row/s into the table.
	public int insertEmployee(Employee e){
		String query="insert into employee values('"+e.getId()+"','"+e.getName()+"','"+e.getSalary()+"')";
		return jdbcTemplate.update(query);
	}
	//update a row/s into the table.
	public int updateEmployee(Employee e){
		String query="update employee set salary='"+e.getSalary()+"' where id='"+e.getId()+"' ";
		return jdbcTemplate.update(query);
	}
	//deletion of row/s into the table
	public int deleteEmployee(Employee e){
		String query="delete from employee where id='"+e.getId()+"' ";
		return jdbcTemplate.update(query);
	}
}