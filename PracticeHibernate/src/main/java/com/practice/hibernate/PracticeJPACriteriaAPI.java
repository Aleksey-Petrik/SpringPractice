package com.practice.hibernate;

import com.practice.hibernate.entity.User;
import com.practice.hibernate.util.HibernateUtil;
import lombok.extern.log4j.Log4j2;
import org.hibernate.Session;

import javax.persistence.Query;
import javax.persistence.criteria.*;
import java.util.List;

@Log4j2(topic = "logger Log4j2")//Аннотация от Lombok для логгера Log4j2
public class PracticeJPACriteriaAPI {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        log.info("Hibernate tutorial started");

        session.getTransaction().begin();

        //Подготовка запроса для JPA Criteria API, получение всех пользователей
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();//фабрика созданий критерий
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);//создание критерия
        Root<User> root = criteriaQuery.from(User.class);
        criteriaQuery.select(root);

        //Условия для отбора по id
        Predicate q1 = criteriaBuilder.gt(root.get("id"), 10000);
        Predicate q2 = criteriaBuilder.lt(root.get("id"), 10030);
        criteriaQuery.select(root).where(criteriaBuilder.and(q1, q2));

        Query query = session.createQuery(criteriaQuery);
        List<User> criteriaUsers = query.getResultList();
        criteriaUsers.stream()
                .limit(10)
                .forEach(System.out::println);

        //Удаление данных из таблицы
        CriteriaDelete<User> criteriaDelete = criteriaBuilder.createCriteriaDelete(User.class);
        Root<User> rootDelete = criteriaDelete.from(User.class);
        criteriaDelete.where(criteriaBuilder.equal(rootDelete.get("id"), 20028));
        session.createQuery(criteriaDelete).executeUpdate();

        //Обновление данных
        CriteriaUpdate<User> criteriaUpdate = criteriaBuilder.createCriteriaUpdate(User.class);
        Root<User> rootUpdate = criteriaUpdate.from(User.class);
        criteriaUpdate.where(criteriaBuilder.equal(rootUpdate.get("id"), 20034));
        criteriaUpdate.set("email", "updateSecond@email.ru");
        session.createQuery(criteriaUpdate).executeUpdate();

        session.getTransaction().commit();
        session.close();

        //После закрытия сессии, все объекты managed (persistent) переходят в состояние detached

        HibernateUtil.close();
    }
}
