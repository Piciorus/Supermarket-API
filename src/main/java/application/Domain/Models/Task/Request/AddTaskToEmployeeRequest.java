package application.Domain.Models.Task.Request;

import application.Domain.Entities.User;

import java.util.Date;

public class AddTaskToEmployeeRequest {
    private User user;

    private String description;

    private Date creationDate;

    private String status;

    private String dateToComplete;

    public AddTaskToEmployeeRequest(User user, String description, String dateToComplete) {
        this.user = user;
        this.description = description;
        this.status = "false";
        this.dateToComplete = dateToComplete;
        this.creationDate = new Date();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String isStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDateToComplete() {
        return dateToComplete;
    }

    public void setDateToComplete(String dateToComplete) {
        this.dateToComplete = dateToComplete;
    }
}
