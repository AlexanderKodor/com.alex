package hibernate_one_to_many_bi;

import hibernate_one_to_many_bi.entity.Department;
import hibernate_one_to_many_bi.entity.Employee;
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
//            Department department = new Department("Sales", 500, 200);
//            Employee emp1 = new Employee("Roma", "Crack", 200);
//            Employee emp2 = new Employee("Sara","Mell",250);
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
            System.out.println("Запрос");
            Department department = session.get(Department.class,1);
            System.out.println("Вывод департамента");
            System.out.println(department.toString());
            System.out.println("Вывод работников ");
            List<Employee> employeeList = department.getEmployeeList();
            System.out.println(employeeList);


//            Employee employee = session.get(Employee.class,3);
//            System.out.println(employee);
//            System.out.println(employee.getDepartment());;

            session.getTransaction().commit();
            System.out.println("Выполнено");
        }
        finally {
            session.close();
            sessionFactory.close();
        }
    }
}
