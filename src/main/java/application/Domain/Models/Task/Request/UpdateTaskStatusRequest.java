package application.Domain.Models.Task.Request;

import java.util.Date;

public class UpdateTaskStatusRequest {
    private String status;
    private Date updateDate;

    public UpdateTaskStatusRequest(String status, Date updateDate) {
        this.status = status;
        this.updateDate = new Date();
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
}
