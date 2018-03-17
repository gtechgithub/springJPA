package com.javapoint;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.collections4.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional(noRollbackFor = Exception.class)

public class EmployeeDaoImpl implements EmployeeDao {

	   @PersistenceContext
	   protected EntityManager em;
	   
	   public EntityManager getEm() {
	        return em;
	   }
	 
	   @PersistenceContext
	   public void setEm(EntityManager entityManager) {
	        this.em = entityManager;
	   }
	 
	public void addEmployee(String firstName, String lastName, int salary) {
		Employee emp = new Employee(firstName, lastName, salary);
		em.persist(emp);
	}

	public List<Employee> findbyIdGreaterThan10() {
		List<Employee> empList =  null;
		Query query = em.createNamedQuery("findbyIdGreaterThan10");
		empList = query.getResultList();
		return empList;
	}

}
