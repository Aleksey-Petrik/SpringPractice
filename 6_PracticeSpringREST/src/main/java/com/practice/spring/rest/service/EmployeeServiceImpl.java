package com.practice.spring.rest.service;

import com.practice.spring.rest.dao.EmployeeDAO;
import com.practice.spring.rest.entity.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDAO repository;

    public EmployeeServiceImpl(EmployeeDAO repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public List<Employee> getEmployees() {
        return repository.getEmployees();
    }

}