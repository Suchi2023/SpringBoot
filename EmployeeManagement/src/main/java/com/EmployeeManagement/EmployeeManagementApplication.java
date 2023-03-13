package com.EmployeeManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.EmployeeManagement.entities.Employee;
import com.EmployeeManagement.repository.EmployeeRepository;

@SpringBootApplication
public class EmployeeManagementApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(EmployeeManagementApplication.class, args);
		EmployeeRepository empRepo = ctx.getBean(EmployeeRepository.class);
		
//		Employee e1 = new Employee();
//		e1.setEmpId(123);
//		e1.setFirstName("Suchitra");
//		e1.setLastName("Maurya");
//		e1.setEmail("suchitramaurya@gmail.com");
//		e1.setDesignation("Software Engineer");
//		
//		Employee result = empRepo.save(e1);
//		System.out.println("Result : \n" + result.toString() );
		Employee empdefault = new Employee();
		Employee eb = empRepo.findById(123).orElse(empdefault);
		System.out.println("findById : " + eb);
		
		
	}

}
