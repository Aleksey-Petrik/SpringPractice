package hibernate_test;

import hibernate_test.entity.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class MainHibernateQuerySelect {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")//начитывает конфигурацию для работы с БД
                .addAnnotatedClass(Car.class)//читает аннотации
                .buildSessionFactory();//создает объект
        try {
            //язык запросов HQL
            //factory можем переиспользовать
            Session session = factory.getCurrentSession();//создание сессии для работы с БД, только для одного действия
            session.beginTransaction();//открытие транзакции, которую необходимо закрыть, принять либо откатить изменения
            List<Car> cars = session.createQuery("FROM Car")//указываем имя класс
                    .getResultList();
            List<Car> bmwCars = session.createQuery("FROM Car WHERE model = 'VOLVO Q7' OR model = 'LADA'")//указываем имя класс
                    .getResultList();
            //cars.stream().map(Car::getModel).distinct().forEach(System.out::println);
            cars.forEach(System.out::println);
            System.out.println();
            bmwCars.forEach(System.out::println);
            session.getTransaction().commit();
        } finally {
            factory.close();//закрытие фабрики сессий, при любом исходе так как finally
        }
    }
}
