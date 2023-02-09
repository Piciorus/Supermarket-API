package application.Domain.Entities;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Users")
public class User extends BaseEntity {
    @Column(name = "Username", nullable = false, length = 50)
    private String username;
    @Column(name = "Password", nullable = false, length = 200)
    private String password;

    @Column(name = "Name", nullable = false, length = 50)
    private String name;

    @Column(name = "Surname", nullable = false, length = 50)
    private String surname;

    @Column(name = "Phone", nullable = false, length = 50)
    private String phone;

    @Column(name = "CNP", nullable = false, length = 50)
    private String cnp;

    @OneToOne(mappedBy = "user")
    @JsonIgnore
    private ShoppingList shoppingList;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Task> tasks;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles = new ArrayList<>(0);

    public User(String username, String password, String name, String surname, String phone, String cnp) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.cnp = cnp;
    }

    public User() {

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

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public ShoppingList getShoppingList() {
        return shoppingList;
    }

    public void setShoppingList(ShoppingList shoppingList) {
        this.shoppingList = shoppingList;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

}

