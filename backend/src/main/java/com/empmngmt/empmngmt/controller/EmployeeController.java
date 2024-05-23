package com.empmngmt.empmngmt.controller;

import com.empmngmt.empmngmt.model.Employee;
import com.empmngmt.empmngmt.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.empmngmt.empmngmt.exception.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;
    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }
    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long id){
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exists with id: " + id));
        return ResponseEntity.ok(employee);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id,@RequestBody Employee employeeDetails){
        Employee updateEmployee=employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exists with id: " + id));
        updateEmployee.setFirstName((employeeDetails.getFirstName()));
        updateEmployee.setLastName((employeeDetails.getLastName()));
        updateEmployee.setEmailId((employeeDetails.getEmailId()));

        employeeRepository.save(updateEmployee);
        return ResponseEntity.ok(updateEmployee);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id){
        Employee employee=employeeRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Employee not exists with id: " + id));
        employeeRepository.delete(employee);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
