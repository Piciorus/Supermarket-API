package application.Repository.Implementation;

import application.Model.Task;
import application.Repository.Interface.ITaskRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TaskRepository implements ITaskRepository {
    private List<Task> taskList;

    public TaskRepository(List<Task> taskList) {
        this.taskList = taskList;
    }

    @Override
    public void add(Task task) {
        taskList.add(task);
    }

    @Override
    public void deleteById(int id) {
        taskList.remove(id);
    }

    @Override
    public void getById(int id) {
        taskList.get(id);
    }

    @Override
    public List<Task> getAll() {
        return taskList;
    }

}
