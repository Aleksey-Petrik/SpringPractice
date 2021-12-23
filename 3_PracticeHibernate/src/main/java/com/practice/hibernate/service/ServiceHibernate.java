package com.practice.hibernate.service;

import com.practice.hibernate.entity.Employee;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import javax.persistence.Query;

@Service
public class ServiceHibernate {

    public void addEmployee(Employee employee, Session session) {
        session.beginTransaction();
        session.save(employee);
        session.getTransaction().commit();
    }

    public void deleteEmployee(Employee employee, Session session) {
        session.beginTransaction();
        session.delete(employee);
        session.getTransaction().commit();
    }

    public Employee deleteEmployeeForId(long idEmployee, Session session) {
        session.beginTransaction();
        Employee employee = session.get(Employee.class, idEmployee);
        session.delete(employee);
        session.getTransaction().commit();
        return employee;
    }

    public void deleteAllEmployees(Session session) {
        session.beginTransaction();
        Query query = session.createQuery("DELETE FROM Employee");
        query.executeUpdate();
        session.getTransaction().commit();
    }

}
