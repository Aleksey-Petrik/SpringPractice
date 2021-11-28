package com.practice.hibernate;

import com.practice.hibernate.entity.User;
import org.hibernate.Session;
import com.practice.hibernate.util.HibernateUtil;

public class MainHibernate {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.getTransaction().begin();
        /*
        User user = new User();//New объект (transient)
        user.setUserName("Aleksey3");
        user.setUserPassword("123465798");
        user.setEmail("aleksey@gmail3.com");
        session.save(user);//переходит в состояние managed (persistent) - управляемый объект, помещенный hibernate контейнер
         */

        User user = session.get(User.class, 20028);//переходит в состояние managed (persistent) - управляемый объект, помещенный hibernate контейнер
        user.setUserName("Aleksey69");

        session.save(user);
        session.getTransaction().commit();

        session.close();

        //После закрытия сессии, все объекты managed (persistent) переходят в состояние detached

        HibernateUtil.close();
    }

}
