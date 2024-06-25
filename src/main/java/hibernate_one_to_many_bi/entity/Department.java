package hibernate_one_to_many_bi.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String departnemtName;
    @Column(name = "max_salary")
    private int maxSalary;
    @Column(name = "min_salary")
    private int minSalary;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "department")
    private List<Employee> employeeList;

    public Department() {
    }

    public Department(String departnemtName, int maxSalary, int minSalary) {
        this.departnemtName = departnemtName;
        this.maxSalary = maxSalary;
        this.minSalary = minSalary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartnemtName() {
        return departnemtName;
    }

    public void setDepartnemtName(String departnemtName) {
        this.departnemtName = departnemtName;
    }

    public int getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(int maxSalary) {
        this.maxSalary = maxSalary;
    }

    public int getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(int minSalary) {
        this.minSalary = minSalary;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", departnemtName='" + departnemtName + '\'' +
                ", maxSalary='" + maxSalary + '\'' +
                ", minSalary='" + minSalary + '\'' +
                '}';
    }
    public void addEmployeeToDepartment(Employee employee){
        if(employeeList == null){
            employeeList = new ArrayList<>();
        }
        employeeList.add(employee);
        employee.setDepartment(this);
    }
}
