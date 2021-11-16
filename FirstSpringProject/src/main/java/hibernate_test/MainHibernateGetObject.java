package hibernate_test;

import hibernate_test.entity.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainHibernateGetObject {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")//начитывает конфигурацию для работы с БД
                .addAnnotatedClass(Car.class)//читает аннотации
                .buildSessionFactory();//создает объект
        try {
            //factory можем переиспользовать
            Session session = factory.getCurrentSession();//создание сессии для работы с БД, только для одного действия
            //Car car = new Car(8, "VOLVO Q7", "cool car");
            Car car = new Car("VOLVO Q7", "cool car");
            session.beginTransaction();//открытие транзакции, которую необходимо закрыть, принять либо откатить изменения
            session.save(car);//добавление данных insert into cars (car_description, car_model, car_id) values (?, ?, ?)
            session.getTransaction().commit();//сохранить результат действия запроса в транзакции
            //session.getTransaction().rollback();//отменить изменения
            System.out.println(car);

            //Взять запись из БД и поместить в объект
            int carId = 4;
            session = factory.getCurrentSession();
            session.beginTransaction();
            Car carDB = session.get(Car.class, carId);
            session.getTransaction().commit();
            System.out.println(carDB);
        } finally {
            factory.close();//закрытие фабрики сессий, при любом исходе так как finally
        }
    }
}
