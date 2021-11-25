package com.practice.spring.mvc_hibernate_aop.dao;

import com.practice.spring.mvc_hibernate_aop.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

//Вспомогательный слой для работы с БД, DAO
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired//так как бин прописан в конфиг файле, спринг аннотация добавит объект в переменную
    private SessionFactory sessionFactory;

    @Override
    @Transactional//аннотация при которой спринг берет на себя открытие и закрытие транзакций
    public List<Employee> getAllEmployees() {
        Session session = sessionFactory.getCurrentSession();
        Query<Employee> queryEmployees = session.createQuery("FROM Employee", Employee.class);
        List<Employee> employees = queryEmployees.getResultList();
        return employees;
    }
}
