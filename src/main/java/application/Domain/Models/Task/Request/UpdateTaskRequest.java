package application.Domain.Models.Task.Request;

import java.util.Date;

public class UpdateTaskRequest {
    private String description;

    private Date updateDate;
    private boolean status;

    private Date dateToComplete;

    public UpdateTaskRequest(String description, boolean status, Date updateDate, Date dateToComplete) {
        this.description = description;
        this.status = status;
        this.updateDate = updateDate;
        this.dateToComplete = dateToComplete;
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

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Date getDateToComplete() {
        return dateToComplete;
    }

    public void setDateToComplete(Date dateToComplete) {
        this.dateToComplete = dateToComplete;
    }
}
