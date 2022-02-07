package com.practice.spring.rest.service;

import com.practice.spring.rest.dao.EmployeeDAO;
import com.practice.spring.rest.entity.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDAO repository;

    public EmployeeServiceImpl(EmployeeDAO repository) {
        this.repository = repository;
    }

    @Override
    public List<Employee> getEmployees() {
        return repository.getEmployees();
    }

    @Override
    public Employee getEmployee(long id) {
        return repository.getEmployee(id);
    }

}