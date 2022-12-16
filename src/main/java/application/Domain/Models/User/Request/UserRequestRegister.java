package application.Domain.Models.User.Request;

public class UserRequestRegister {
    private String username;
    private String password;

    private String name;

    private String surname;

    private String cnp;

    private String phone;

    public UserRequestRegister(String username, String password, String name, String surname, String cnp, String phone) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.cnp = cnp;
        this.phone = phone;
    }

    public UserRequestRegister() {
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
}
