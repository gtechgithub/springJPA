package com.javapoint;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeDao {

	public void addEmployee(String firstName, String lastName, int salary);

	public void updateEmployee(int empId, int salary);
	
	public Employee findByFirstName(String firstName);
	
	public List<Employee> listAllEmployees();
	
	public void deleteEmployee(int empId);
	
 	public List<Employee> findAllByCustomQuery(int salary, Pageable pageable);
	
	public Iterable<Employee> listAllEmployees(String lastName,Pageable pageable);
}
