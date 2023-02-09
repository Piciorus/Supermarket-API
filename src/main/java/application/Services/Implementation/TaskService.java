package application.Services.Implementation;

import application.Domain.Entities.Task;
import application.Domain.Entities.User;
import application.Domain.Mapper.Mapper;
import application.Domain.Models.Task.Request.AddTaskToEmployeeRequest;
import application.Domain.Models.Task.Request.UpdateTaskRequest;
import application.Domain.Models.Task.Response.GetAllTasksResponse;
import application.Domain.Models.Task.Response.GetTaskByIdResponse;
import application.Repository.TaskRepository;
import application.Repository.UserRepository;
import application.Services.Interface.ITaskService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class TaskService implements ITaskService {
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    private final Mapper mapper;

    public TaskService(TaskRepository taskRepository, Mapper mapper, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.mapper = mapper;
        this.userRepository = userRepository;
    }

    @Override
    public Task updateTask(UpdateTaskRequest updateTaskRequest, UUID id) {
        Task taskUpdated = taskRepository.getById(id);
        taskUpdated.setStatus(updateTaskRequest.getStatus());
        taskUpdated.setDescription(updateTaskRequest.getDescription());
        taskUpdated.setDateToComplete(updateTaskRequest.getDateToComplete());
        return taskRepository.save(taskUpdated);
    }

    @Override
    public Task updateTaskStatus(UUID id, String status) {
        Task taskUpdated = taskRepository.getById(id);
        taskUpdated.setStatus(status);
        return taskRepository.save(taskUpdated);
    }

    @Override
    public Iterable<GetAllTasksResponse> getAllTasks() {
        List<GetAllTasksResponse> list = new ArrayList<>();
        taskRepository.findAll().forEach(task -> list.add(mapper.TaskToGetAllTasksResponse(task)));
        return list;
    }

    @Override
    public GetTaskByIdResponse getTaskById(UUID id) {
        Task task = taskRepository.getById(id);
        return mapper.TaskToGetTaskByIdResponse(task);
    }

    @Override
    public Task addTaskToEmployee(AddTaskToEmployeeRequest addTaskToEmployeeRequest, UUID id) {
        addTaskToEmployeeRequest.setUser(userRepository.getById(id));
        Task task = mapper.AddTaskToEmployeeRequestToTask(addTaskToEmployeeRequest);
        return taskRepository.save(task);
    }

    @Override
    public void removeTaskFromEmployee(UUID id) {
        taskRepository.deleteById(id);
    }

    @Override
    public Iterable<GetAllTasksResponse> getAllTasksByEmployeeId(UUID id) {
        User user = userRepository.getById(id);
        List<GetAllTasksResponse> list = new ArrayList<>();
        user.getTasks().forEach(task -> list.add(mapper.TaskToGetAllTasksResponse(task)));
        return list;
    }

}


