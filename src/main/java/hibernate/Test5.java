package hibernate;

import hibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test5 {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {

            session.beginTransaction();

//            Employee employee = session.get(Employee.class, 7);
//            session.remove(employee);
            session.createQuery("delete Employee where name = 'Sergey'").executeUpdate();

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
