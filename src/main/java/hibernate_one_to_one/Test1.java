package hibernate_one_to_one;

import hibernate_one_to_one.entity.Detail;
import hibernate_one_to_one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
//            Employee emp = new Employee("Oleg", "Smirnov", "Sales", 1000);
//            Detail detail = new Detail("Mockow", "7734555599", "oleg@gmail.com");
//            emp.setDetail(detail);
//            session.beginTransaction();
//            session.persist(emp);
//            session.getTransaction().commit();
//            System.out.println("Запись произведена: " + emp);


            session.beginTransaction();
            Employee employee = session.get(Employee.class, 2);
            System.out.println(employee.getEmpDetail());
            session.remove(employee);

            session.getTransaction().commit();
            System.out.println("Done");
        } finally {
            session.close();
            sessionFactory.close();
        }

    }
}
