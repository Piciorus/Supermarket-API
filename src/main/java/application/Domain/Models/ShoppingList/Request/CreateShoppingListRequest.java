package application.Domain.Models.ShoppingList.Request;

import application.Domain.Entities.User;

import java.util.Date;

public class CreateShoppingListRequest {
    private String name;
    private Date creationDate;

    private User user;

    public CreateShoppingListRequest(String name, User user) {
        this.name = name;
        this.creationDate = new Date();
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
