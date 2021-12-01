package com.practice.spring.rest.dao;

import com.practice.spring.rest.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> getEmployees();

    Employee getEmployees(long id);

    void saveEmployee(Employee employee);

    void deleteEmployee(long id);
}