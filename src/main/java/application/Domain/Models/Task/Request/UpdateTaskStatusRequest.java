package application.Domain.Models.Task.Request;

import java.util.Date;

public class UpdateTaskStatusRequest {
    private boolean status;
    private Date updateDate;

    public UpdateTaskStatusRequest(boolean status, Date updateDate) {
        this.status = status;
        this.updateDate = new Date();
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
}
