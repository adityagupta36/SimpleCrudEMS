package com.aditya.projects.SimpleCrud.repository;

import com.aditya.projects.SimpleCrud.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee,Long> {

}
