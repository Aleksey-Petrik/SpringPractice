package com.practice.spring.rest.dao;

import com.practice.spring.rest.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private final SessionFactory sessionFactory;

    public EmployeeDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Employee> getEmployees() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM Employee ORDER BY id", Employee.class).getResultList();
    }

    @Override
    public Employee getEmployee(long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Employee.class, id);
    }

    @Override
    public void addNewEmployee(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        session.save(employee);
    }

    @Override
    public void updateEmployee(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(employee);
    }

    @Override
    public int deleteEmployee(long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("DELETE FROM Employee WHERE id = :id")
                .setParameter("id", id)
                .executeUpdate();
    }

}
