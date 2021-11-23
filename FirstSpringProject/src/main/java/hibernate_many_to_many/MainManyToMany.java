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
            /*
            save - не умеет каскадно сохранять данные, если в entity не будет CascadeType.ALL, то произойдет ошибка
            для таких случаев используем persist - умеет каскадно сохранять данные
             */

            /*
            Children children = new Children("Dim", 12);
            Children children2 = new Children("Lena", 13);
            Children children3 = new Children("Vala", 13);
            Hobby hobby = new Hobby("boxing");
            session.beginTransaction();
            session.save(hobby);
            hobby.addChildren(children);
            hobby.addChildren(children2);
            hobby.addChildren(children3);
            session.save(children);
            session.save(children2);
            session.save(children3);
             */
            session.beginTransaction();
            Hobby hobby = session.get(Hobby.class, 3);
            System.out.println(hobby.getName());
            hobby.getChildes().forEach(System.out::println);

            Children children = session.get(Children.class, 4);
            System.out.println(children.getName());
            children.getHobbies().forEach(System.out::println);

            /*
            Hobby hobby = new Hobby("dance");
            Children children = new Children("Toma", 12);
            Children children2 = new Children("Tim", 13);
            Children children3 = new Children("John", 13);
            hobby.addChildren(children);
            hobby.addChildren(children2);
            hobby.addChildren(children3);
            session.beginTransaction();
            session.persist(hobby);
            */
            /*
            Hobby hobby = session.get(Hobby.class, 1);
            hobby.addChildren(children);
            hobby.addChildren(children2);
            hobby.addChildren(children3);
            session.update(hobby);
            */
            session.getTransaction().commit();
        }
    }
}
