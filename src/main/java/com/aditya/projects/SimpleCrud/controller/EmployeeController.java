package com.aditya.projects.SimpleCrud.controller;

import com.aditya.projects.SimpleCrud.exceptions.ResourceNotFindException;
import com.aditya.projects.SimpleCrud.model.Employee;
import com.aditya.projects.SimpleCrud.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("aditya/api/employees")
public class EmployeeController {

    @Autowired
    EmployeeRepo employeeRepo;

    //get all employees
    @GetMapping("/getAllEmployees")
    public List<Employee> getAlEmployees() {
        List<Employee> allEmployeesList = employeeRepo.findAll();
        return allEmployeesList;
    }


    //build: create Single Employee Rest api
    @PostMapping("/createEmployee")
    public Employee createEmployee(@RequestBody Employee employee) {    //@RequestBody ==>(input: front end, postman)Json to Java Object(output: repo.save(Frontend-entity)
        return employeeRepo.save(employee);
    }

    //build: create Multiple Employee Rest api
    @PostMapping("/createMultipleEmployee")
    public List<Employee> createEmployee(@RequestBody List<Employee> employeesList) {
        return employeeRepo.saveAll(employeesList);
    }



    //get employee by Id
    @GetMapping("/getEmployeeById/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable Long id) {
        Optional<Employee> employee = employeeRepo.findById(id);
        return employee;
    }

    //OR
    @GetMapping("/getEmployeeByIds/{ids}")
    public ResponseEntity<Employee> getEmployeeByIds(@PathVariable Long ids) {
        Employee employee = employeeRepo.findById(ids).get();
        return ResponseEntity.ok(employee);
    }

    //OR
    @GetMapping("/gettEmployeeById/{id}")
    public ResponseEntity<Employee> gettEmployeeById(@PathVariable Long id) {
        Employee employee = employeeRepo.findById(id).orElseThrow(() -> new ResourceNotFindException("Employee not exists with ID"));
        return ResponseEntity.ok(employee);
    }




    //update employee rest api
    @PutMapping("/updateEmployee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee updateEmployee) {
        Employee employee = employeeRepo.findById(id).orElseThrow(() -> new ResourceNotFindException("Employee not exists with ID"));
        employee.setFirstName(updateEmployee.getFirstName());
        employee.setLastName(updateEmployee.getLastName());
        employee.setEmailId(updateEmployee.getEmailId());
        employeeRepo.save(employee);
        return ResponseEntity.ok(employee);
    }

    //    OK
    @PutMapping("/updateEmployees/{id}")
    public ResponseEntity<Employee> updateEmployees(@PathVariable Long id, Employee employee) {
        employee.setFirstName("Parth");
        employee.setLastName("Surelia");
        employee.setEmailId("parth@outlook.com");
        employeeRepo.save(employee);
        return ResponseEntity.ok(employee);
    }


    @DeleteMapping("/deleteEmployeeById/{id}")
    public ResponseEntity<HttpStatus> deleteEmployeeById(@PathVariable Long id){
        employeeRepo.deleteById(id);
       return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

//    OR

    @DeleteMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable Long id ){
        Employee employee = employeeRepo.findById(id).orElseThrow(()-> new ResourceNotFindException("Employee nOt Exists with ID"));
        employeeRepo.delete(employee);
        return "Deleted Success!";
    }
}




