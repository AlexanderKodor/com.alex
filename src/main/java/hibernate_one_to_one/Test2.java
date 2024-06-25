package hibernate_one_to_one;

import hibernate_one_to_one.entity.Detail;
import hibernate_one_to_one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
//            Employee emp = new Employee("Niko", "Ivanov", "IT", 1100);
//            Detail detail = new Detail("Omsk", "353451199", "misha@gmail.com");
//            emp.setEmpDetail(detail);
//            detail.setEmployee(emp);
//            session.beginTransaction();
//            session.persist(detail);
//            session.getTransaction().commit();
//            System.out.println("Запись произведена: " + emp);


//            session.beginTransaction();
//            Detail detail = session.get(Detail.class,4);
//            System.out.println(detail.getEmployee());
//
//            session.getTransaction().commit();
//            System.out.println("Done");


            session.beginTransaction();
            Detail detail = session.get(Detail.class,6);
            System.out.println(detail.getEmployee());
            detail.getEmployee().setEmpDetail(null);
            session.remove(detail);

            session.getTransaction().commit();
            System.out.println("Done");
        } finally {
            session.close();
            sessionFactory.close();
        }

    }
}
