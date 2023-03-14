package com.EmployeeManagement;

import java.util.List;
import java.util.Optional;

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
		
//---------- insert operation----------
//		Employee e1 = new Employee();
//		e1.setEmpId(125);
//		e1.setFirstName("Chitra");
//		e1.setLastName("Maurya");
//		e1.setEmail("chitra@gmail.com");
//		e1.setDesignation("SOftware Engineer");
//		Employee result = empRepo.save(e1);
//		System.out.println("Saved Record : \n" + result.toString() );
		
//------------Fetch all records----------------------
		Iterable<Employee> list = empRepo.findAll();
		System.out.println("List of Employee details :");
		list.forEach(e -> {System.out.println(e);});	
		
		System.out.println("---------------------------------------------------------\n");
		
// -----------Fetch single record---------------
		Employee empdefault = new Employee();
		Employee eb = empRepo.findById(123).orElse(empdefault);
		System.out.println("findById : " + eb);
		
		System.out.println("---------------------------------------------------------\n");
		
// ------------Update operation---------------
//		Optional<Employee> res = empRepo.findById(125);
//		Employee emp = res.get();
//		if (emp != null) {
//			emp.setDesignation("Project Manager");
//			Employee result1 = empRepo.save(emp);
//			System.out.println("Updated Record : " + result1);
//		}	
		
// -----------------Custom methods -----------------
		List<Employee> list1 = empRepo.findByLastName("Maurya");
		list1.forEach(e -> System.out.println(e));
		
		System.out.println("------------------------------------------------------------------------\n");
		
		List<Employee> list2 = empRepo.findByFirstNameAndLastName("Pragati", "Verma");
		list2.forEach(e -> System.out.println(e));
		
		System.out.println("------------------------------------------------------------------------\n");
		
		List<Employee> list3 = empRepo.findByFirstNameContaining("chi");
		list3.forEach(e -> System.out.println(e));
		
		System.out.println("------------------------------------------------------------------------\n");
		
		List<Employee> list4 = empRepo.findByLastNameStartingWith("Ve");
		list4.forEach(e -> System.out.println(e));
		
		System.out.println("----------------------------------------------------------------------\n");
		
		List<Employee> list5 = empRepo.findByLastNameEndingWith("ya");
		list5.forEach(e -> System.out.println(e));
		
		System.out.println("----------------------------------------------------------------------");
		
		List<Employee> list6 = empRepo.findByLastNameLike("Ma*");
		list6.forEach(e -> System.out.println(e));
		
		
		
	}

}
