package com.EmployeeManagement.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.EmployeeManagement.entities.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}
