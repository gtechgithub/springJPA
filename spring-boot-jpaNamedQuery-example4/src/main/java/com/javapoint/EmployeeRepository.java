package com.javapoint;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("empRepository")
public interface EmployeeRepository extends CrudRepository<Employee ,Integer> {

	Page<Employee> findByLastName(String lastName, Pageable pageable);
	
}

