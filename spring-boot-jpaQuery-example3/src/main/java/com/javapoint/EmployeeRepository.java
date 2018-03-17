package com.javapoint;

import java.util.stream.Stream;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("empRepository")
public interface EmployeeRepository extends CrudRepository<Employee ,Integer> {
	Employee findByFirstName(String firstName);

	Page<Employee> findByLastName(String lastName, Pageable pageable);
	
	@Query("select u from Employee u")
 	public Stream<Employee> findAllByCustomQuery(Pageable pageable);

}

