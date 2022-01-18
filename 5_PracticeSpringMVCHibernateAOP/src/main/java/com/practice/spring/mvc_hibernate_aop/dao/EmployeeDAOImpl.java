package com.practice.spring.mvc_hibernate_aop.dao;

import com.practice.spring.mvc_hibernate_aop.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Employee> getAllEmployees() {
        Session session = sessionFactory.getCurrentSession();
        List<Employee> employees = session.createQuery("FROM Employee", Employee.class).getResultList();
        return employees;
    }

    @Override
    public void saveEmployee(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(employee);
    }

    @Override
    public Employee getEmployee(long empId) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Employee.class, empId);
    }

    @Override
    public void deleteEmployee(long empId) {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("DELETE FROM Employee WHERE id = :id")
                .setParameter("id", empId)
                .executeUpdate();
    }

}
