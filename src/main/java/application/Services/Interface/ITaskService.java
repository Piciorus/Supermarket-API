package application.Services.Interface;

import application.Domain.Entities.Task;
import application.Domain.Models.Task.Request.AddTaskToEmployeeRequest;
import application.Domain.Models.Task.Request.UpdateTaskRequest;
import application.Domain.Models.Task.Response.GetAllTasksResponse;
import application.Domain.Models.Task.Response.GetTaskByIdResponse;
import org.springframework.scheduling.annotation.Async;

import java.util.UUID;

public interface ITaskService {
    @Async
    Task updateTask(UpdateTaskRequest updateTaskRequest, UUID id);

    @Async
    Task updateTaskStatus(UUID id, String status);

    @Async
    Iterable<GetAllTasksResponse> getAllTasks();

    @Async
    GetTaskByIdResponse getTaskById(UUID id);

    @Async
    Task addTaskToEmployee(AddTaskToEmployeeRequest addTaskToEmployeeRequest, UUID id);

    @Async
    void removeTaskFromEmployee(UUID id);

    @Async
    Iterable<GetAllTasksResponse> getAllTasksByEmployeeId(UUID id);

}
