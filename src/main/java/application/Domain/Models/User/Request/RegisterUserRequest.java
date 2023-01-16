package application.Domain.Models.User.Request;

import application.Domain.Entities.Role;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RegisterUserRequest {
    private String username;
    private String password;

    private String name;

    private String surname;

    private String cnp;

    private String phone;

    private Date creationDate;

    private List<Role> roles;

    public RegisterUserRequest(String username, String password, String name, String surname, String cnp, String phone) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.cnp = cnp;
        this.phone = phone;
        this.creationDate = new Date();
//        this.roles.add(new Role("User"));
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

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
