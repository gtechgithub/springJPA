package com.javapoint;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; 

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository empRepository;
	
	@Autowired
	EmployeeDao employeeDao;
	
			public void addEmployee(String firstName, String lastName, int salary) {
				employeeDao.addEmployee(firstName, lastName, salary);
			}

		 	public int findbyIdGreaterThan10(){
		 		List<Employee> listEmp= employeeDao.findbyIdGreaterThan10();
		 		return listEmp.size();
		 	}	
		 	
		 	public List<Employee> findByLastName(String lastName,Pageable pageable){
		 		List<Employee> empList =  null;
		 		Page<Employee> empPages = empRepository.findByLastName (lastName, pageable);

		 		//convert page to list
		 	    empList =  IteratorUtils.toList(empPages.iterator());
		 		return empList;
		 	}
			
	}

