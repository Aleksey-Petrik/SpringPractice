package com.practice.spring.rest.controller;

import com.practice.spring.rest.entity.Employee;
import com.practice.spring.rest.exception_handling.NoSuchEmployeeException;
import com.practice.spring.rest.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RESTController {

    private final EmployeeService employeeService;

    public RESTController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> showEmployees() {
        return employeeService.getEmployees();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable long id) {
        Employee employee = employeeService.getEmployee(id);
        if (employee == null) {
            throw new NoSuchEmployeeException("There is no employee with ID - " + id + " in Database!");
        }
        return employee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        if (employee != null) {
            employeeService.addNewEmployee(employee);
        }
        return employee;
    }

}