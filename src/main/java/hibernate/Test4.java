package hibernate;

import hibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Test4 {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {

            session.beginTransaction();
//            Employee employee = session.get(Employee.class, 1);
//            employee.setSalary(777);
            session.createQuery("update Employee set salary = 654 where name = 'Oleg'").executeUpdate();

            session.getTransaction().commit();
//            System.out.println("Запись произведена: " + employee);

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
