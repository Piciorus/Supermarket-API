package application.Domain.Models.Task.Request;

import java.util.Date;

public class UpdateTaskRequest {
    private String description;

    private Date updateDate;
    private String status;

    private String dateToComplete;

    public UpdateTaskRequest(String description, String status, String dateToComplete) {
        this.description = description;
        this.status = status;
        this.updateDate = new Date();
        this.dateToComplete = dateToComplete;
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

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getDateToComplete() {
        return dateToComplete;
    }

    public void setDateToComplete(String dateToComplete) {
        this.dateToComplete = dateToComplete;
    }
}
