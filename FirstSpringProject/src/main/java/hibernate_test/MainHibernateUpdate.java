package hibernate_test;

import hibernate_test.entity.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainHibernateUpdate {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")//начитывает конфигурацию для работы с БД
                .addAnnotatedClass(Car.class)//читает аннотации
                .buildSessionFactory();//создает объект
        try {
            //язык запросов HQL
            //factory можем переиспользовать
            Session session = factory.getCurrentSession();//создание сессии для работы с БД, только для одного действия
            session.beginTransaction();//открытие транзакции, которую необходимо закрыть, принять либо откатить изменения
            Car car = session.get(Car.class, 2);
            car.setModel("LADA NIVA");//Обновление с помощью сеттеров

            session.createQuery("UPDATE Car SET description = 'normalec car' WHERE model = 'opel g5'").executeUpdate();//Запуск запроса на обновление
            session.getTransaction().commit();
        } finally {
            factory.close();//закрытие фабрики сессий, при любом исходе так как finally
        }
    }
}
