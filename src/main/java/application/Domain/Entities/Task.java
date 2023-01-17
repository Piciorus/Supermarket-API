package application.Domain.Entities;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "Tasks")
public class Task {
    @Id
    @Column(columnDefinition = "uniqueidentifier", name = "id")
    private UUID id;
    @Column(name="Description", nullable = false, length = 50)
    private String description;
    @Column(name="Status", nullable = false, length = 50)
    private boolean status;

    @Column(name="CreationDate", nullable = false, length = 50)
    private Date creationDate;

    @Column(name="UpdateDate", nullable = true, length = 50)
    private Date updateDate;

    @Column(name="DateToComplete", nullable = true, length = 50)
    private Date dateToComplete;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = true)
    private User user;

    public Task(String description,boolean status,Date creationDate,Date updateDate,Date dateToComplete) {
        this.description = description;
        this.status = status;
        this.creationDate = creationDate;
        this.updateDate = updateDate;
        this.dateToComplete = dateToComplete;
    }

    public Task() {

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

    public UUID getTaskId() {
        return id;
    }

    public void setTaskId(UUID taskId) {
        this.id = taskId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
