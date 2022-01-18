package com.practice.spring.mvc_hibernate_aop.dao;

import com.practice.spring.mvc_hibernate_aop.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> getAllEmployees();

    void saveEmployee(Employee employee);

    Employee getEmployee(long empId);

    void deleteEmployee(long empId);
}