package hibernate_one_to_one;

import hibernate_one_to_one.entity.Detail;
import hibernate_one_to_one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainHibernateQueryAdd {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")//начитывает конфигурацию для работы с БД
                .addAnnotatedClass(Employee.class)//читает аннотации
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();//создает объект
        Session session = null;
        try {
            //язык запросов HQL
            //factory можем переиспользовать
            session = factory.getCurrentSession();//создание сессии для работы с БД, только для одного действия

            //создаем объект рабочий
            //Employee employee = new Employee("Misha", "Petrov", "HR", 1000.00);
            //Создаем объект доп. информации
            //Detail detail = new Detail("London", "+7788709034", "misha@gmail.com");
            //Рабочему присваиваем доп. информацию
            //employee.setEmployeeDetails(detail);
            //detail.setEmployee(employee);

            session.beginTransaction();//открытие транзакции, которую необходимо закрыть, принять либо откатить изменения
            //session.save(detail);

            //Взятие записи из БД, берем в начале подчиненную таблицу, а через нее уже главную
            Detail detail = session.get(Detail.class, 3);
            Employee employee = detail.getEmployee();
            System.out.println(employee);

            employee.setEmployeeDetails(null);//Разрываем связь с подчиненной таблицей
            session.delete(detail);//После чего можем удалить запись

            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();//закрытие фабрики сессий, при любом исходе так как finally
        }
    }
}
