package application.Domain.Models.Task.Request;

import java.util.Date;

public class AddTaskRequest {
    private String description;

    private Date creationDate;
    private String status;
    private String dateToComplete;

    public AddTaskRequest(String description, String dateToComplete) {
        this.description = description;
        this.status = "false";
        this.dateToComplete = dateToComplete;
        this.creationDate = new Date();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getDateToComplete() {
        return dateToComplete;
    }

    public void setDateToComplete(String dateToComplete) {
        this.dateToComplete = dateToComplete;
    }
}
