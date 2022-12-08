package application.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int EmployeeId;
    @Column(name="Name", nullable = false, length = 50)
    private String name;
    @Column(name="Surname", nullable = false, length = 50)
    private String surname;
    @Column(name="Phone", nullable = false, length = 50)
    private String phone;
    @Column(name="CNP", nullable = false, length = 50)
    private String cnp;
    @Column(name="Salary", nullable = false, length = 50)
    private double salary;

    @OneToOne
    @JoinColumn(name="UserId")
    private Account account;

    @OneToOne
    @JoinColumn(name="SupermarketId")
    private Supermarket supermarket;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "EmployeeTasks", joinColumns = @JoinColumn(name = "employee_id"), inverseJoinColumns = @JoinColumn(name = "task_id"))
    private List<Task> tasks=new ArrayList<>(0);

    public Employee(int employeeId, String name, String surname, String phone, String cnp, double salary, List<Task> tasks) {
        this.EmployeeId = employeeId;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.cnp = cnp;
        this.salary = salary;
        this.tasks = tasks;
    }

    public Employee() {

    }

    public int getEmployeeId() {
        return EmployeeId;
    }

    public void setEmployeeId(int employeeId) {
        EmployeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
