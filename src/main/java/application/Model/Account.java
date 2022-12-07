package application.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="Username", nullable = false, length = 50)
    private String username;
    @Column(name="Password", nullable = false, length = 50)
    private String password;

    public Account(int id, String username, String password) {
        this.id = id;
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
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void showAccount(){
        System.out.println("Username: " + username + " Password: " + password );
    }
}

