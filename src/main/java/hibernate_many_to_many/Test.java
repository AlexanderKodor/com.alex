package hibernate_many_to_many;

import hibernate_many_to_many.entity.Child;
import hibernate_many_to_many.entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {

//            Section section1 = new Section("football");
//            Child child1 = new Child("Masha", 10);
//            Child child2 = new Child("Vanya", 7);
//            Child child3 = new Child("Darina", 9);
//            section1.addChildToSection(child1);
//            section1.addChildToSection(child2);
//            section1.addChildToSection(child3);
//
//            session.beginTransaction();
//
//            session.persist(section1);
//
//            session.getTransaction().commit();
//        *********************************************************
//            Section section1 = new Section("voleyball");
//            Section section2 = new Section("tennis");
//            Section section3 = new Section("chess");
//            Child child1 = new Child("Grosh", 10);
//
//            child1.addSectionToChild(section1);
//            child1.addSectionToChild(section2);
//            child1.addSectionToChild(section3);
//
//            session.beginTransaction();
//
//            session.persist(child1);
//
//            session.getTransaction().commit();
////            *********************************************************
//
//
//            session.beginTransaction();
//
////            Section section = session.get(Section.class,3);
////            System.out.println(section);
////            System.out.println(section.getChildList());
//
//            Child child = session.get(Child.class,4);
//            System.out.println(child);
//            System.out.println(child.getSectionList());
//
//            session.getTransaction().commit();
//            //            *********************************************************
//
//
//            session.beginTransaction();
//
//            Section section = session.get(Section.class,3);
//            session.remove(section);
//
//            session.getTransaction().commit();
//            ********************************************************
            Section section1 = new Section("football");
            Child child1 = new Child("Misha", 10);
            Child child2 = new Child("Valya", 7);
            Child child3 = new Child("Danya", 9);
            section1.addChildToSection(child1);
            section1.addChildToSection(child2);
            section1.addChildToSection(child3);

            session.beginTransaction();

            session.persist(section1);

            session.getTransaction().commit();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
