package application.Domain.Models.Task.Response;

import java.util.Date;

public class GetTaskByIdResponse {
    private String description;
    private boolean status;

    private Date dateToComplete;

    public GetTaskByIdResponse(String description, boolean status, Date dateToComplete) {
        this.description = description;
        this.status = status;
        this.dateToComplete = dateToComplete;
    }

    public GetTaskByIdResponse() {
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

    public Date getDateToComplete() {
        return dateToComplete;
    }

    public void setDateToComplete(Date dateToComplete) {
        this.dateToComplete = dateToComplete;
    }
}
