package com.javapoint;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeDao {

	public void addEmployee(String firstName, String lastName, int salary);

	public List<Employee> findbyIdGreaterThan10();

}
