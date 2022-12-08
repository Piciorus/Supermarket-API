package application.Model;

import javax.persistence.*;

@Entity
@Table(name = "Managers")
public class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ManagerId;
    @Column(name="Name", nullable = false, length = 50)
    private String name;
    @Column(name="Surname", nullable = false, length = 50)
    private String surname;
    @Column(name="Phone", nullable = false, length = 50)
    private String phone;
    @Column(name="CNP", nullable = false, length = 50)
    private String cnp;
    @Column(name="Salary", nullable = false, length = 50)
    private String salary;

    @OneToOne
    @JoinColumn(name="UserId")
    private Account account;

    public Manager(int ManagerId, String name, String surname, String phone, String cnp, String salary){
        this.ManagerId = ManagerId;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.cnp = cnp;
        this.salary = salary;
    }

    public int getManagerId() {
        return ManagerId;
    }

    public void setManagerId(int managerId) {
        ManagerId = managerId;
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

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
}
