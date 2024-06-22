package hibernate;

import hibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Test3 {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {

            session.beginTransaction();
            List<Employee> list = session.createQuery("from Employee where surname  LIKE '%Fox%'").getResultList();

            session.getTransaction().commit();
            for(Employee employee:list)
                System.out.println(employee);

            System.out.println("Конец");
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
