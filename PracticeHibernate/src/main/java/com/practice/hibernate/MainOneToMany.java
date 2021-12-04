package com.practice.hibernate;

import com.practice.hibernate.entity.User;
import com.practice.hibernate.util.HibernateUtil;
import lombok.extern.log4j.Log4j2;
import org.hibernate.Session;

@Log4j2
public class MainOneToMany {
    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();//Открытие транзакции

        User user = session.get(User.class, 10025);

        log.info(user);

        user.getCategories().forEach(log::info);
        user.getPriorities().forEach(log::info);

        log.info(user.getActivity());

        session.getTransaction().commit();
        session.close();
        HibernateUtil.close();
    }

}