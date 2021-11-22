package hibernate_many_to_many;

import hibernate_many_to_many.entity.Children;
import hibernate_many_to_many.entity.Hobby;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainManyToMany {
    public static void main(String[] args) {

        try (SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Children.class)
                .addAnnotatedClass(Hobby.class)
                .buildSessionFactory(); Session session = factory.getCurrentSession()) {

            Children children = new Children("Alex", 12);
            Children children2 = new Children("Bob", 13);
            Children children3 = new Children("Vlad", 13);
            //Hobby hobby = new Hobby("football");
            //hobby.addChildren(children);
            session.beginTransaction();
            Hobby hobby = session.get(Hobby.class, 1);
            hobby.addChildren(children);
            hobby.addChildren(children2);
            hobby.addChildren(children3);
            session.update(hobby);
            session.getTransaction().commit();
        }
    }
}
