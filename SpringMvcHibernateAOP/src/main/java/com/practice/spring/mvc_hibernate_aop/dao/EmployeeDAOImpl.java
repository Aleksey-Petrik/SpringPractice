package com.practice.spring.mvc_hibernate_aop.dao;

import com.practice.spring.mvc_hibernate_aop.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//Вспомогательный слой для работы с БД, DAO
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired//так как бин прописан в конфиг файле, спринг аннотация добавит объект в поле класса
    private SessionFactory sessionFactory;

    @Override
    public List<Employee> getAllEmployees() {
        Session session = sessionFactory.getCurrentSession();
        Query<Employee> queryEmployees = session.createQuery("FROM Employee", Employee.class);
        return queryEmployees.getResultList();
    }

    @Override
    public void saveEmployee(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(employee);
    }

    @Override
    public Employee getEmployee(int employeeId) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Employee.class, employeeId);
    }

    @Override
    public void deleteEmployee(int employeeId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("DELETE FROM Employee WHERE id = :employeeId");//:employeeId вместо данной приписки будет подставленное значение
        query.setParameter("employeeId", employeeId);
        query.executeUpdate();
    }

}
