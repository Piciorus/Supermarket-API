package application.Services.Interface;

import application.Domain.Entities.Task;
import application.Domain.Models.Task.Request.AddTaskRequest;
import application.Domain.Models.Task.Request.UpdateTaskRequest;
import application.Domain.Models.Task.Response.GetAllTasksResponse;
import application.Domain.Models.Task.Response.GetTaskByIdResponse;

public interface ITaskService {
    Task saveTask(AddTaskRequest addTaskRequest);
    void deleteTask(Long id);
    Task updateTask(UpdateTaskRequest updateTaskRequest,Long id);
    Task updateTaskStatus(Long id, boolean status);
    Iterable<GetAllTasksResponse> getAllTasks();
    GetTaskByIdResponse getTaskById(Long id);
}
