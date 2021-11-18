package hibernate_practice_query;

import hibernate_practice_query.entity.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainHibernateDelete {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")//начитывает конфигурацию для работы с БД
                .addAnnotatedClass(Car.class)//читает аннотации
                .buildSessionFactory();//создает объект
        try {
            //язык запросов HQL
            //factory можем переиспользовать
            Session session = factory.getCurrentSession();//создание сессии для работы с БД, только для одного действия
            session.beginTransaction();//открытие транзакции, которую необходимо закрыть, принять либо откатить изменения
            //Car car = session.get(Car.class, 8);
            //session.delete(car);
            session.createQuery("DELETE Car WHERE model = 'VOLVO Q7'").executeUpdate();
            session.getTransaction().commit();
        } finally {
            factory.close();//закрытие фабрики сессий, при любом исходе так как finally
        }
    }
}
