package com.practice.hibernate.service;

import com.practice.hibernate.entity.Employee;
import com.practice.hibernate.entity.Position;
import com.practice.hibernate.entity.Skill;
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
        session.delete(employee);
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

    public List<Employee> getAllEmployees(Session session) {
        session.getTransaction().begin();
        var employees = session.createQuery("FROM Employee")
                .getResultList();
        session.getTransaction().commit();
        return employees;
    }

    public void updateSalaryEmployeesRange(long startId, long endId, double newSalary, Session session) {
        session.getTransaction().begin();
        Query query = session.createQuery("UPDATE Employee SET salary = :newSalary WHERE id >= :startId AND id <= :endId");
        query.setParameter("newSalary", newSalary).setParameter("startId", startId).setParameter("endId", endId);
        query.executeUpdate();
        session.getTransaction().commit();
    }

    public void addSkill(Session session, Skill skill) {
        session.getTransaction().begin();
        session.save(skill);
        session.getTransaction().commit();
    }

    public void addListSkills(Session session, List<Skill> skills) {
        session.getTransaction().begin();
        skills.forEach(session::save);
        session.getTransaction().commit();
    }

    public void addPosition(Session session, Position position) {
        session.getTransaction().begin();
        session.save(position);
        session.getTransaction().commit();
    }

    public void addListPositions(Session session, List<Position> positions) {
        session.getTransaction().begin();
        positions.forEach(session::save);
        session.getTransaction().commit();
    }

    public void addEmployeesList(List<Employee> employees, Session session) {
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
    }
}
