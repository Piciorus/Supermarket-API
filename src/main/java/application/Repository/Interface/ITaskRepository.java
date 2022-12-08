package application.Repository.Interface;

import application.Model.Task;

import java.util.List;

public interface ITaskRepository {
    void add(Task task);
    void deleteById(int id);
    void getById(int id);
    List<Task> getAll();
}
