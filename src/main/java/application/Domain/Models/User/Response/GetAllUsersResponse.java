package application.Domain.Models.User.Response;

import application.Domain.Entities.Role;

import java.util.List;

public class GetAllUsersResponse {
    private String name;
    private String surname;

    private List<Role> role;

    public GetAllUsersResponse(String name, String surname, List<Role> role) {
        this.name = name;
        this.surname = surname;
        this.role = role;

    }

    public GetAllUsersResponse() {
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

    public List<Role> getRole() {
        return role;
    }

    public void setRole(List<Role> role) {
        this.role = role;
    }

}
