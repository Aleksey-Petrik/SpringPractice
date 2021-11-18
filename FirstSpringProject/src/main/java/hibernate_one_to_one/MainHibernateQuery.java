package hibernate_one_to_one;

import hibernate_one_to_one.entity.Detail;
import hibernate_one_to_one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainHibernateQuery {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")//начитывает конфигурацию для работы с БД
                .addAnnotatedClass(Employee.class)//читает аннотации
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();//создает объект
        Session session = null;
        try {
            //язык запросов HQL
            //factory можем переиспользовать
            session = factory.getCurrentSession();//создание сессии для работы с БД, только для одного действия

            //создаем объект рабочий
            Employee employee = new Employee("Alex", "Petrov", "IT", 3000.00);
            //Создаем объект доп. информации
            Detail detail = new Detail("KnA", "+79998886677", "alex@gmail.com");
            //Рабочему присваиваем доп. информацию
            employee.setEmployeeDetails(detail);

            //создаем объект рабочий
            Employee employee2 = new Employee("Oleg", "Smirnov", "Sale", 2000.00);
            //Создаем объект доп. информации
            Detail detail2 = new Detail("KnA", "+76668885571", "oleg@gmail.com");
            //Рабочему присваиваем доп. информацию
            employee2.setEmployeeDetails(detail2);

            session.beginTransaction();//открытие транзакции, которую необходимо закрыть, принять либо откатить изменения
            /* Удаление
            Employee employeeDelete = session.get(Employee.class, 1);
            session.delete(employeeDelete);
             */
            session.save(employee);
            session.save(employee2);
            Employee employeeShow = session.get(Employee.class, 2);
            System.out.println(employeeShow);
            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();//закрытие фабрики сессий, при любом исходе так как finally
        }
    }
}
