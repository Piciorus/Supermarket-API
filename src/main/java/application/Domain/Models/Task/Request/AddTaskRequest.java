package application.Domain.Models.Task.Request;

import application.Domain.Entities.User;

import java.util.Date;

public class AddTaskRequest {
    private String description;

    private Date creationDate;
    private boolean status;
    private Date dateToComplete;

    public AddTaskRequest(String description,Date dateToComplete) {
        this.description = description;
        this.status = false;
        this.dateToComplete = dateToComplete;
        this.creationDate = new Date();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getDateToComplete() {
        return dateToComplete;
    }

    public void setDateToComplete(Date dateToComplete) {
        this.dateToComplete = dateToComplete;
    }
}
