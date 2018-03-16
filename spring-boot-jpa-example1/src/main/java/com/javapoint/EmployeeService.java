package com.javapoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service; 

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

	}

