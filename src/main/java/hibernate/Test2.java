package hibernate;

import hibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            Employee emp = new Employee("Oleg", "Sidorov", "HR", 750);
            session.beginTransaction();
            session.persist(emp);
//            session.getTransaction().commit();
            int myId = emp.getId();
//            session = sessionFactory.getCurrentSession();
//            session.beginTransaction();
            Employee employee = session.get(Employee.class, myId);
            session.getTransaction().commit();
            System.out.println("Запись произведена: " + emp);
            System.out.println("Пришло с БД по Ид " + employee);
//            System.out.println("Конец");
        }
        catch (Exception e)
        {
            System.out.println("Поймали ошибку " + e);
        }
        finally {
            sessionFactory.close();
        }

    }
}
