package com.practice.spring.rest.controller;

import com.practice.spring.rest.entity.Employee;
import com.practice.spring.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RESTController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/Employees")
    public List<Employee> showAllEmployees() {
        return employeeService.getEmployees();
    }

    @GetMapping("/Employees/{id}")
    public Employee showEmployee(@PathVariable long id) {
        return employeeService.getEmployees(id);
    }

    @DeleteMapping("/DeleteEmployee/{id}")
    public void deleteEmployee(@PathVariable long id) {
        //employeeService.deleteEmployees(id);
    }

}