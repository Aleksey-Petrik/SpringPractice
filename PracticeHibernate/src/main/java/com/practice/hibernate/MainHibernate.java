package com.practice.hibernate;

import com.practice.hibernate.entity.User;
import lombok.extern.log4j.Log4j2;
import org.hibernate.Session;
import com.practice.hibernate.util.HibernateUtil;

import java.util.List;

@Log4j2(topic = "logger")//Аннотация от Lombok для логгера Log4j2
public class MainHibernate {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        log.info("Hibernate tutorial started");

        session.getTransaction().begin();

        User user = new User();//New объект (transient)
        user.setUserName("Aleksey3");
        user.setUserPassword("123465798");
        user.setEmail("aleksey@gmail3.com");
        session.save(user);//переходит в состояние managed (persistent) - управляемый объект, помещенный hibernate контейнер

        List<User> users = session.createQuery("FROM User").getResultList();
        users.forEach(System.out::println);

        User userModify = session.get(User.class, 20000);//переходит в состояние managed (persistent) - управляемый объект, помещенный hibernate контейнер
        userModify.setUserName("Aleksey69");

        session.getTransaction().commit();
        session.close();

        //После закрытия сессии, все объекты managed (persistent) переходят в состояние detached

        HibernateUtil.close();
    }

}
