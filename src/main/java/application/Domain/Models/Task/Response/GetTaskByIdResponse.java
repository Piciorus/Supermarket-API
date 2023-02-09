package application.Domain.Models.Task.Response;

public class GetTaskByIdResponse {
    private String description;
    private boolean status;

    private String dateToComplete;

    public GetTaskByIdResponse(String description, boolean status, String dateToComplete) {
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

    public String getDateToComplete() {
        return dateToComplete;
    }

    public void setDateToComplete(String dateToComplete) {
        this.dateToComplete = dateToComplete;
    }
}
