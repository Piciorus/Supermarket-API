package application.Domain.Entities;

import javax.persistence.*;

@Entity
@Table(name = "Tasks")
public class Task extends BaseEntity {
    @Column(name = "Description", nullable = false, length = 50)
    private String description;
    @Column(name = "Status", nullable = false, length = 50)
    private String status;
    @Column(name = "DateToComplete", nullable = true, length = 50)
    private String dateToComplete;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = true)
    private User user;

    public Task(String description, String status, String dateToComplete) {
        this.description = description;
        this.status = status;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDateToComplete() {
        return dateToComplete;
    }

    public void setDateToComplete(String dateToComplete) {
        this.dateToComplete = dateToComplete;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
