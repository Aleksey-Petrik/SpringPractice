package com.practice.hibernate;

import com.practice.hibernate.entity.User;
import com.practice.hibernate.util.HibernateUtil;
import lombok.extern.log4j.Log4j2;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.util.List;

@Log4j2
public class PracticeHQL_JPQL {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        log.info("Hibernate tutorial started");

        //session.getTransaction().begin();//Открытие транзакции

        List<User> users = session.createQuery("FROM User").getResultList();
        users.stream().limit(10).forEach(System.out::println);

        Query<User> query = session.createQuery("FROM User WHERE email LIKE :text");
        query.setParameter("text", "%69%");

        //Вывод по указанному количеству, можно применять для постраничного вывода
        query.setFirstResult(1).setMaxResults(10);

        List<User> usersMails = query.getResultList();
        usersMails.stream()
                //.limit(10)
                .forEach(System.out::println);

        Query<Long> queryCount = session.createQuery("SELECT COUNT(id) FROM User WHERE email LIKE :text");
        queryCount.setParameter("text", "%69%");
        long count = queryCount.uniqueResult();
        log.info("Count rec - " + count);

        Query<String> queryEmail = session.createQuery("SELECT email FROM User WHERE id = :id");
        queryEmail.setParameter("id", 20034);
        String email = queryEmail.getSingleResult();
        log.info("User email - " + email);

        //Если необходимо взять несколько полей для объекта, то можно в самом запросе создать новый экземпляр с этими полями, главно наличие конструктора
        Query<User> queryEmailName = session.createQuery("SELECT new User(userName, email) FROM User WHERE id = :id");
        queryEmailName.setParameter("id", 20034);
        User userEmailName = queryEmailName.getSingleResult();
        log.info("User email and name - " + userEmailName);

        log.info("Native SQL");
        String queryNativeSQL = "SELECT * FROM todolist.user_data";
        NativeQuery<User> sqlQuery = session.createSQLQuery(queryNativeSQL);
        List<User> usersNativeSQL = sqlQuery.addEntity(User.class).setMaxResults(10).getResultList();
        usersNativeSQL.forEach(System.out::println);

        String queryNativeSQLObjects = "SELECT SUBSTRING(email FROM POSITION(:symbol IN email) + 1) AS domain, COUNT(*) AS count " +
                "FROM todolist.user_data " +
                "WHERE email LIKE :pattern " +
                "GROUP BY domain";
        NativeQuery<Object[]> sqlQueryObjects = session.createSQLQuery(queryNativeSQLObjects);
        sqlQueryObjects.setParameter("symbol", "@");
        sqlQueryObjects.setParameter("pattern", "%@%");

        for (Object[] obj : sqlQueryObjects.getResultList()) {
            System.out.println(obj[0] + " " + obj[1]);
        }

        //session.getTransaction().commit();//Закрытие транзакции
        session.close();
        HibernateUtil.close();
    }
}
