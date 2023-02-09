package application.Domain.Models.Task.Response;

public class GetAllTasksResponse {
    private String description;
    private boolean status;

    private String dateToComplete;

    public GetAllTasksResponse(String description, boolean status, String dateToComplete) {
        this.description = description;
        this.dateToComplete = dateToComplete;
        this.status = status;
    }

    public GetAllTasksResponse() {
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

    public String getDateToComplete() {
        return dateToComplete;
    }

    public void setDateToComplete(String dateToComplete) {
        this.dateToComplete = dateToComplete;
    }
}
