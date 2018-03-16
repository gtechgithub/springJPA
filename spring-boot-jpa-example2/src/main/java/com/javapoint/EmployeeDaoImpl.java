package com.javapoint;

import java.util.List;

import org.apache.commons.collections4.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class EmployeeDaoImpl implements EmployeeDao{

		@Autowired
		EmployeeRepository empRepository;

		public void addEmployee(String firstName, String lastName, int salary) {
			Employee emp = new Employee(firstName,lastName,salary);
			empRepository.save(emp);
		}

		public void updateEmployee(int empId, int salary) {
			Employee emp = findById(empId);
			emp.setSalary(salary);
			empRepository.save(emp);
		}
		
		public Employee findById(int empId) {
			Employee emp = null;
			emp = empRepository.findOne(empId);
			return emp;
		}
		
		public Employee findByFirstName(String firstName) {
			Employee emp = empRepository.findByFirstName(firstName);
			return emp;
		}
		
		public List<Employee> listAllEmployees(){
			List<Employee> empList  = null;
			
			//convert iterable to list 
			empList = IteratorUtils.toList(empRepository.findAll().iterator()) ;
			return empList;
		}
		
		public void deleteEmployee(int empId) {
			empRepository.delete(empId);
		}

}
