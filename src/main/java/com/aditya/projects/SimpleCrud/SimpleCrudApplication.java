package com.aditya.projects.SimpleCrud;

import com.aditya.projects.SimpleCrud.model.Employee;
import com.aditya.projects.SimpleCrud.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SimpleCrudApplication {

//public class SimpleCrudApplication implements CommandLineRunner {


	public static void main(String[] args) {
		SpringApplication.run(SimpleCrudApplication.class, args);
	}


	@Autowired
	EmployeeRepo employeeRepo;


/*	@Override
	public void run(String... args) throws Exception {
		*//*employeeRepo.save(new Employee(2,"John", "Cena", "John@gmail.com"));
		employeeRepo.save(new Employee(3,"Great", "Khali", "Great@gmail.com"));
		employeeRepo.save(new Employee(1,"Aditya", "Gupta", "aditya@gmail.com"));*//*

//		OR

		Employee e1 = new Employee();
		e1.setFirstName("Ankit");
		e1.setLastName("Gohil");
		e1.setEmailId("Ankit@yahoo.com");
		employeeRepo.save(e1);

	}*/
}
