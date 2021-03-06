package hibernate_one_to_many_bi;

import hibernate_one_to_many_bi.entity.Department;
import hibernate_one_to_many_bi.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainHibernateQuery {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")//начитывает конфигурацию для работы с БД
                .addAnnotatedClass(Employee.class)//читает аннотации
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();//создает объект
        Session session = null;
        try {
            //язык запросов HQL
            //factory можем переиспользовать
            session = factory.getCurrentSession();//создание сессии для работы с БД, только для одного действия
            session.beginTransaction();//открытие транзакции, которую необходимо закрыть, принять либо откатить изменения
            /*
            Department department = new Department("SALES", 1000.00, 3000.00);
            Employee employee = new Employee("Alena", "Ivanov", 1500.00);
            Employee employee2 = new Employee("Vlada", "Petrov", 2500.00);
            Employee employee3 = new Employee("Vitamin", "Petrov", 2500.00);
            department.addEmployeeTODepartment(employee);
            department.addEmployeeTODepartment(employee2);
            department.addEmployeeTODepartment(employee3);
            session.save(department);
             */

            Department department = session.get(Department.class, 5);
            System.out.println("Department - " + department);
            System.out.println("Employees : ");
            department.getEmployees().forEach(System.out::println);

            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();//закрытие фабрики сессий, при любом исходе так как finally
        }
    }
}
