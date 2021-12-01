package com.practice.spring.rest.dao;

import com.practice.spring.rest.entity.Employee;
import com.practice.spring.rest.exception_handling.NoSuchEmployeeException;
import lombok.extern.java.Log;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Log
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Employee> getEmployees() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Employee", Employee.class);
        List<Employee> employees = query.getResultList();
        log.info("Get all employees, count - " + employees.size());
        return employees;
    }

    @Override
    public Employee getEmployees(long id) {
        Session session = sessionFactory.getCurrentSession();
        Employee employee = session.get(Employee.class, id);
        log.info("Get employee - " + employee.toString());
        return employee;
    }

    @Override
    public void saveEmployee(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(employee);
        log.info("Save/update employee - " + employee.toString());
    }

    @Override
    public void deleteEmployee(long id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Employee> query = session.createQuery("DELETE FROM Employee WHERE id = :employeeId");
        int resultQuery = query.setParameter("employeeId", id).executeUpdate();
        log.info("Delete employee id - " + id + " status - " + (resultQuery == 0 ? "Not delete" : "OK delete"));
        if (resultQuery == 0) {
            throw new NoSuchEmployeeException("Do not employee with ID - " + id + " for delete!");
        }
    }

}