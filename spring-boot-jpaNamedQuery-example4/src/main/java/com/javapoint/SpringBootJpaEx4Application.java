package com.javapoint;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.PageRequest;

public class SpringBootJpaEx4Application{
	    public static void main(String[] args) {

	      ApplicationContext context  = new ClassPathXmlApplicationContext("applicationcontext.xml");
	      EmployeeService service  =  (EmployeeService) context.getBean("employeeservice");
	      
	      //add employee
	      service.addEmployee("first name100", "last name100", 100000);

	      //printing findByLastName using repository
	      List<Employee> empList = service.findByLastName("last name100", new PageRequest(0,10));
	      System.out.println("\n \n -------------------printing findByLastName using repository-------------");
	      for (Employee emp : empList) {
	    	  System.out.println(emp);
	      }
	      
	      //printing method using entitymanager
	      System.out.println("\n \n -------------------printing findbyIdGreaterThan10 using entitymanager-------------");
	      System.out.println("employee size:" + service.findbyIdGreaterThan10());
	}
}	



/******************************************* OUTPUT




 -------------------printing findByLastName using repository-------------
id:3 firstname:first name100 lastname:last name100 salary:100000
id:4 firstname:first name100 lastname:last name100 salary:100000
id:5 firstname:first name100 lastname:last name100 salary:100000
id:6 firstname:first name100 lastname:last name100 salary:100000
id:7 firstname:first name100 lastname:last name100 salary:100000
id:8 firstname:first name100 lastname:last name100 salary:100000
id:9 firstname:first name100 lastname:last name100 salary:100000
id:10 firstname:first name100 lastname:last name100 salary:100000
id:11 firstname:first name100 lastname:last name100 salary:100000
id:12 firstname:first name100 lastname:last name100 salary:100000

 
 -------------------printing findbyIdGreaterThan10 using entitymanager-------------
employee size:4




*****************************************************/