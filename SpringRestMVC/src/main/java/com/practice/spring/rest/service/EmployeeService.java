package com.practice.spring.rest.service;

import com.practice.spring.rest.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getEmployees();

    Employee getEmployees(long id);

    void saveEmployee(Employee employee);

    void deleteEmployee(long id);
}