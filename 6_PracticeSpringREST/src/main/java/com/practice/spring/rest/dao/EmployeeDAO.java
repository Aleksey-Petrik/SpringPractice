package com.practice.spring.rest.dao;

import com.practice.spring.rest.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> getEmployees();

    Employee getEmployee(long id);

    void addNewEmployee(Employee employee);

    void updateEmployee(Employee employee);

    int deleteEmployee(long id);
}