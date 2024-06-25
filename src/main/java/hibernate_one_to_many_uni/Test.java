package hibernate_one_to_many_uni;


import hibernate_one_to_many_uni.entity.Department;
import hibernate_one_to_many_uni.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try{
//            Department department = new Department("HR", 500, 200);
//            Employee emp1 = new Employee("Rima", "Crack", 333);
//            Employee emp2 = new Employee("Cristen","Stuart",222);
//            department.addEmployeeToDepartment(emp1);
//            department.addEmployeeToDepartment(emp2);
//
//            session.beginTransaction();
//
//            session.persist(department);
//
//            session.getTransaction().commit();
//            System.out.println("Выполнено");



//            session.beginTransaction();
//
//            Department department = session.get(Department.class,1);
//            System.out.println(department.toString());
//            List<Employee> employeeList = department.getEmployeeList();
//            for (Employee employee:employeeList)
//                System.out.println(employee.toString());


//            Employee employee = session.get(Employee.class,3);
//            System.out.println(employee);


//            session.getTransaction().commit();
//            System.out.println("Выполнено");


            session.beginTransaction();

//            Employee employee = session.get(Employee.class,5);
//            session.remove(employee);

            Department department = session.get(Department.class,3);
            session.remove(department);

            session.getTransaction().commit();
            System.out.println("Выполнено");
        }
        finally {
            session.close();
            sessionFactory.close();
        }
    }
}
