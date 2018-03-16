package com.javapoint;

import java.util.Iterator;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@PropertySource("application.properties")
//@ImportResource("applicationcontext.xml")
public class SpringBootJpaEx1Application{

	public static void main(String[] args) {
		
		SpringApplication.run(SpringBootJpaEx1Application.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(EmployeeService service) {
		return(args) ->{
			
			//add employee;
			service.addEmployee("firstname1", "lastname1", 1000);
			service.addEmployee("firstname2", "lastname2", 2000);
			service.addEmployee("firstname3", "lastname3", 3000);
			
			//update employee;
			service.updateEmployee(2, 4000);
			
			//delete employee;
			System.out.println("first name of employee3:" + service.findByFirstName("firstname3"));
			service.deleteEmployee(3);
			
			//get all employees;
			for(Iterator<Employee> iter=service.listAllEmployees().iterator();iter.hasNext();) {
				
				System.out.println("Employees:" + ((Employee) iter.next()));
				
			}
		};
	}
}
