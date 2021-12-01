package com.practice.spring.rest.controller;

import com.practice.spring.rest.entity.Employee;
import com.practice.spring.rest.exception_handling.EmployeeIncorrectData;
import com.practice.spring.rest.exception_handling.NoSuchEmployeeException;
import com.practice.spring.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
        Employee employee = employeeService.getEmployees(id);
        if (employee == null) {
            throw new NoSuchEmployeeException("There is not employee with ID = " + id + " in Database.");
        }
        return employee;
    }

    @PostMapping("/Employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

    @PutMapping("/Employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

    @DeleteMapping("/Employees/{id}")
    public String deleteEmployee(@PathVariable long id) {
        employeeService.deleteEmployee(id);
        return "Employee with ID - " + id + " delete!";
    }

    /*Обработка exceptions перенесены в глобальный модуль EmployeeGlobalExceptionHandler
    @ExceptionHandler//Перехват exception если в базе не нашлось employee, создаем сообщение в json
    public ResponseEntity<EmployeeIncorrectData> handlerException(NoSuchEmployeeException exception) {
        EmployeeIncorrectData data = new EmployeeIncorrectData(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler//Перехват остальных exception, создаем сообщение в json
    public ResponseEntity<EmployeeIncorrectData> handlerException(Exception exception) {
        EmployeeIncorrectData data = new EmployeeIncorrectData(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }
    */
}