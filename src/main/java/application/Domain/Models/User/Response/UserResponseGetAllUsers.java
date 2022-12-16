package application.Domain.Models.User.Response;

public class UserResponseGetAllUsers {
    private String name;
    private String surname;


    public UserResponseGetAllUsers(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public UserResponseGetAllUsers() {
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

}
