package com.practice.hibernate.service;

import com.practice.hibernate.entity.Employee;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

@Service
public class ServiceHibernate {

    public void addEmployee(Employee employee, Session session) {
        session.beginTransaction();
        session.save(employee);
        session.getTransaction().commit();
    }
}
