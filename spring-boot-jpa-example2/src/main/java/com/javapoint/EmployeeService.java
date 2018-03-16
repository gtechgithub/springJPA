package com.javapoint;

import java.util.List;

import org.apache.commons.collections4.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; 

@Service
public class EmployeeService {

	@Autowired
	EmployeeDaoImpl empDao;
	
			public void addEmployee(String firstName, String lastName, int salary) {
				empDao.addEmployee(firstName, lastName, salary);
			}

			public void updateEmployee(int empId, int salary) {
				empDao.updateEmployee(empId, salary);
			}
			
			public Employee findByFirstName(String firstName) {
					return empDao.findByFirstName(firstName);
			}
			
			public List<Employee> listAllEmployees(){
				return empDao.listAllEmployees();
			}
			
			public void deleteEmployee(int empId) {
				empDao.deleteEmployee(empId);
			}
			
			List<Employee> listAllEmployees(String lastName,Pageable pageable){
				return IteratorUtils.toList(empDao.listAllEmployees(lastName,pageable).iterator());
			}
	}

