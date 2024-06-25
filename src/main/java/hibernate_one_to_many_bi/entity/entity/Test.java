package hibernate_one_to_many_bi.entity.entity;

import hibernate_one_to_many_bi.entity.entity.entity.Department;
import hibernate_one_to_many_bi.entity.entity.entity.Employee;
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
//            Department department = new Department("IT", 500, 200);
//            Employee emp1 = new Employee("Alex", "Fox", 350);
//            Employee emp2 = new Employee("Elena","Niku",400);
//            department.addEmployeeToDepartment(emp1);
//            department.addEmployeeToDepartment(emp2);
//
//            session.beginTransaction();
//
//            session.persist(department);
//
//            session.getTransaction().commit();
//            System.out.println("Выполнено");



            session.beginTransaction();

            Department department = session.get(Department.class,1);
            System.out.println(department.toString());
            List<Employee> employeeList = department.getEmployeeList();
            for (Employee employee:employeeList)
                System.out.println(employee.toString());

            session.getTransaction().commit();
            System.out.println("Выполнено");
        }
        finally {
            session.close();
            sessionFactory.close();
        }
    }
}
