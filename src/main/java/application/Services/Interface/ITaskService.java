package application.Services.Interface;

import application.Domain.Entities.Task;
import application.Domain.Models.Task.Request.AddTaskRequest;
import application.Domain.Models.Task.Request.AddTaskToEmployeeRequest;
import application.Domain.Models.Task.Request.UpdateTaskRequest;
import application.Domain.Models.Task.Response.GetAllTasksResponse;
import application.Domain.Models.Task.Response.GetTaskByIdResponse;

import java.util.UUID;

public interface ITaskService {
    void deleteTask(UUID id);
    Task updateTask(UpdateTaskRequest updateTaskRequest,UUID id);
    Task updateTaskStatus(UUID id, String status);
    Iterable<GetAllTasksResponse> getAllTasks();
    GetTaskByIdResponse getTaskById(UUID id);
    Task addTaskToEmployee(AddTaskToEmployeeRequest addTaskToEmployeeRequest, UUID id);
    void removeTaskFromEmployee(UUID id);
    Iterable<GetAllTasksResponse> getAllTasksByEmployeeId(UUID id);

}
