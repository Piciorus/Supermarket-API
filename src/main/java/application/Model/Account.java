package application.Model;

import javax.persistence.*;

@Entity
@Table(name = "Accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    @Column(name="Username", nullable = false, length = 50)
    private String username;
    @Column(name="Password", nullable = false, length = 50)
    private String password;

    @OneToOne(mappedBy = "account")
    private Admin admin;

    @OneToOne(mappedBy = "account")
    private Client client;

    @OneToOne(mappedBy = "account")
    private Employee employee;

    @OneToOne(mappedBy = "account")
    private Manager manager;

    public Account(int id, String username, String password) {
        this.ID = id;
        this.username = username;
        this.password = password;
    }

    public Account() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return ID;
    }

    public void setId(int id) {
        this.ID = id;
    }


}

