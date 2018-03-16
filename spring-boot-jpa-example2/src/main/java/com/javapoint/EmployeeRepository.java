package com.javapoint;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("empRepository")
public interface EmployeeRepository extends CrudRepository<Employee ,Integer> {
	Employee findByFirstName(String firstName);

	Page<Employee> findByLastName(String lastName, Pageable pageable);
}

