package com.practice.hibernate;

import com.practice.hibernate.configuration.Config;
import com.practice.hibernate.entity.Employee;
import com.practice.hibernate.service.ServiceHibernate;
import lombok.extern.log4j.Log4j2;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 */
@Log4j2(topic = "Logger")
public class MainPracticeHibernate {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        ServiceHibernate service = context.getBean("serviceHibernate", ServiceHibernate.class);

        SessionFactory sessionFactory = new Configuration()//Создание фабрики сессий
                .configure("hibernate.cfg.xml")//обозначаем конфигурационный файл
                .addAnnotatedClass(Employee.class)//Перечень объектов для зеркаливания с таблицами БД
                .buildSessionFactory();//создание фабрики

        Session session = sessionFactory.getCurrentSession();//определяем текущую сессию

        Employee employee = new Employee(0, "Vlad", "Sidorov", "IT", 1000d);
        log.info("Obj - {}", employee);

        service.addEmployee(employee, session);

        // session.beginTransaction();//открываем транзакцию

        //session.save(employee);

/*        Query query = session.createQuery("DELETE FROM Employee WHERE id >= :id");
        query.setParameter("id", (long) 3).executeUpdate();*/

        //session.getTransaction().commit();//закрываем транзакцию

        session.close();//закрытие сессии
        sessionFactory.close();//закрытие фабрики

        context.close();
    }
}
