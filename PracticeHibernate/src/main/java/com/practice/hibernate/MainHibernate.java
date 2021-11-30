package com.practice.hibernate;

import com.practice.hibernate.entity.User;
import lombok.extern.log4j.Log4j2;
import org.hibernate.Criteria;
import org.hibernate.Session;
import com.practice.hibernate.util.HibernateUtil;

import javax.persistence.Query;
import javax.persistence.criteria.*;
import java.util.List;

@Log4j2(topic = "logger")//Аннотация от Lombok для логгера Log4j2
public class MainHibernate {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        log.info("Hibernate tutorial started");

        session.getTransaction().begin();
        /*
        User user = new User();//New объект (transient)
        user.setUserName("Aleksey3");
        user.setUserPassword("123465798");
        user.setEmail("aleksey@gmail3.com");
        session.save(user);//переходит в состояние managed (persistent) - управляемый объект, помещенный hibernate контейнер
         */

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
        criteriaDelete.where(criteriaBuilder.equal(rootDelete.get("id"), 20025));
        session.createQuery(criteriaDelete).executeUpdate();
        //Обновление данных
        CriteriaUpdate<User> criteriaUpdate = criteriaBuilder.createCriteriaUpdate(User.class);
        Root<User> rootUpdate = criteriaUpdate.from(User.class);
        criteriaUpdate.where(criteriaBuilder.equal(rootUpdate.get("id"), 20028));
        criteriaUpdate.set("email", "update@email.ru");
        session.createQuery(criteriaUpdate).executeUpdate();
        /*
        List<User> users = session.createQuery("FROM User").getResultList();
        users.forEach(System.out::println);

        User user = session.get(User.class, 20028);//переходит в состояние managed (persistent) - управляемый объект, помещенный hibernate контейнер
        user.setUserName("Aleksey69");

        session.save(user);
         */
        session.getTransaction().commit();
        session.close();

        //После закрытия сессии, все объекты managed (persistent) переходят в состояние detached

        HibernateUtil.close();
    }

}
