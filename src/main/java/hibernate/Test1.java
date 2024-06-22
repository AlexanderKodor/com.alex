package hibernate;

import hibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            Employee emp = new Employee("Sergey", "Krab", "IT", 900);
            session.beginTransaction();
            session.persist(emp);
            session.getTransaction().commit();
            System.out.println("Запись произведена: " + emp);
        } finally {
            sessionFactory.close();
        }

    }
}
