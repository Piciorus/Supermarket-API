package application.Model;

import javax.persistence.*;

@Entity
@Table(name = "Tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int TaskId;
    @Column(name="Description", nullable = false, length = 50)
    private String description;
    @Column(name="CompleteByDate", nullable = false, length = 50)
    private String completeByDate;
    @Column(name="CompleteAtDate", nullable = false, length = 50)
    private String completeAtDate;
    @Column(name="Status", nullable = false, length = 50)
    private String status;

    public Task(int taskId,String description, String completeByDate, String completeAtDate, String status) {
        this.TaskId = taskId;
        this.description = description;
        this.completeByDate = completeByDate;
        this.completeAtDate = completeAtDate;
        this.status = status;
    }

    public Task() {

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCompleteByDate() {
        return completeByDate;
    }

    public void setCompleteByDate(String completeByDate) {
        this.completeByDate = completeByDate;
    }

    public String getCompleteAtDate() {
        return completeAtDate;
    }

    public void setCompleteAtDate(String completeAtDate) {
        this.completeAtDate = completeAtDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTaskId() {
        return TaskId;
    }

    public void setTaskId(int taskId) {
        this.TaskId = taskId;
    }

}
