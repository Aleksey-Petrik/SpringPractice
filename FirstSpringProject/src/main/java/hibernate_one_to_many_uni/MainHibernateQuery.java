package hibernate_one_to_many_uni;

import hibernate_one_to_many_uni.entity.Department;
import hibernate_one_to_many_uni.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainHibernateQuery {
    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")//начитывает конфигурацию для работы с БД
                .addAnnotatedClass(Employee.class)//читает аннотации
                .addAnnotatedClass(Department.class)//читает аннотации
                .buildSessionFactory();
             Session session = factory.getCurrentSession()) {//создание сессии для работы с БД, только для одного действия
            //язык запросов HQL
            //factory можем переиспользовать
            session.beginTransaction();//открытие транзакции, которую необходимо закрыть, принять либо откатить изменения
            /*
            Department department = new Department("HR", 500.00, 1500.00);
            Employee employee = new Employee("Anton", "Ivanov", 1500.00);
            Employee employee2 = new Employee("Vladimir", "Suvorov", 2500.00);
            department.addEmployeeTODepartment(employee);
            department.addEmployeeTODepartment(employee2);
            session.save(department);
             */
            Department department = session.get(Department.class, 2);
            department.getEmployees().forEach(System.out::println);
            session.getTransaction().commit();
        }
        //session.close();
        //закрытие фабрики сессий, при любом исходе так как finally
    }
}
