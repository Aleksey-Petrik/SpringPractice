package com.practice.spring.mvc_hibernate_aop.service;

import com.practice.spring.mvc_hibernate_aop.dao.EmployeeDAO;
import com.practice.spring.mvc_hibernate_aop.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/*
Service - является промежуточным звеном между Controller and DAO
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    @Transactional//аннотация при которой спринг берет на себя открытие и закрытие транзакций
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

    @Override
    @Transactional//аннотация при которой спринг берет на себя открытие и закрытие транзакций
    public void saveEmployee(Employee employee) {
        employeeDAO.saveEmployee(employee);
    }

    @Override
    @Transactional//аннотация при которой спринг берет на себя открытие и закрытие транзакций
    public Employee getEmployee(int employeeId) {
        return employeeDAO.getEmployee(employeeId);
    }

    @Override
    @Transactional
    public void deleteEmployee(int employeeId) {
        employeeDAO.deleteEmployee(employeeId);
    }

}