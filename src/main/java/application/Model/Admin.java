package application.Model;

import javax.persistence.*;

@Entity
@Table(name = "Admins")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int AdminId;
    @Column(name="Name", nullable = false, length = 50)
    private String Name;
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

    @OneToOne
    @JoinColumn(name="SupermarketId")
    private Supermarket supermarket;

    public Admin(int AdminId, String Name, String surname, String phone, String cnp, String salary) {
        this.AdminId = AdminId;
        this.Name = Name;
        this.surname = surname;
        this.phone = phone;
        this.cnp = cnp;
        this.salary = salary;
    }

    public Admin() {

    }

    public int getAdmindId() {
        return AdminId;
    }

    public void setAdmindId(int admindId) {
        AdminId = admindId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
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
