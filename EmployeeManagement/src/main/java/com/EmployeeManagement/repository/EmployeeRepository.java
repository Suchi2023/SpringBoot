package com.EmployeeManagement.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.EmployeeManagement.entities.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
	
	  List<Employee> findByLastName(String lastName);
	  List<Employee> findByFirstNameAndLastName(String firstName, String lastName);
	  List<Employee> findByLastNameStartingWith(String prefix);
	  List<Employee> findByLastNameEndingWith(String suffix);
	  List<Employee> findByFirstNameContaining(String words);
	  List<Employee> findByLastNameLike(String pattern);
	  List<Employee> findByEmpIdGreaterThanEqual(int id);
	  
}
