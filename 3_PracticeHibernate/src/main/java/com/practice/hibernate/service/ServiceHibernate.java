package com.practice.hibernate.service;

import com.practice.hibernate.entity.Employee;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import javax.persistence.Query;
import java.util.List;

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

    public void deleteEmployeesRange(long startId, long endId, Session session) {
        session.getTransaction().begin();
        Query query = session.createQuery("DELETE FROM Employee WHERE id >= :startId AND id <= :endId");
        query.setParameter("startId", startId).setParameter("endId", endId).executeUpdate();
        session.getTransaction().commit();
    }

    public Employee getEmployee(Session session, long employeeId) {
        return session.get(Employee.class, employeeId);
    }

    public void addEmployeesList(List<Employee> employees, Session session) {
        session.getTransaction().begin();
        employees.forEach(session::save);
/*        employees.stream().iterator().forEachRemaining(session::save);  */
        //todo do not work method
/*        for (Employee employee : employees) {
            Query query = session.createQuery("INSERT INTO Employee (name, surname, department, salary) SELECT :name, :surname, :department, :salary FROM employee");
            query.setParameter("name", employee.getName())
                    .setParameter("surname", employee.getSurname())
                    .setParameter("department", employee.getDepartment())
                    .setParameter("salary", employee.getSalary());
        }*/
        session.getTransaction().commit();
    }
}