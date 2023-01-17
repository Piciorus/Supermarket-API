package application.Services.Implementation;

import application.Domain.Entities.Task;
import application.Domain.Mapper.Mapper;
import application.Domain.Models.Supermarket.Response.GetAllSupermarketResponse;
import application.Domain.Models.Task.Request.AddTaskRequest;
import application.Domain.Models.Task.Request.UpdateTaskRequest;
import application.Domain.Models.Task.Response.GetAllTasksResponse;
import application.Domain.Models.Task.Response.GetTaskByIdResponse;
import application.Repository.TaskRepository;
import application.Services.Interface.ITaskService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService implements ITaskService {
    private TaskRepository taskRepository;

    private Mapper mapper;

    public TaskService(TaskRepository taskRepository, Mapper mapper) {
        this.taskRepository = taskRepository;
        this.mapper = mapper;
    }

    @Override
    public Task saveTask(AddTaskRequest addTaskRequest) {
        Task task=mapper.AddTaskRequestToTask(addTaskRequest);
        return taskRepository.save(task);
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public Task updateTask(UpdateTaskRequest updateTaskRequest, Long id) {
        Task taskUpdated=taskRepository.getById(id);
        taskUpdated.setStatus(updateTaskRequest.getStatus());
        taskUpdated.setDescription(updateTaskRequest.getDescription());
        taskUpdated.setDateToComplete(updateTaskRequest.getDateToComplete());
        return taskRepository.save(taskUpdated);
    }

    @Override
    public Task updateTaskStatus(Long id, boolean status) {
        Task taskUpdated=taskRepository.getById(id);
        taskUpdated.setStatus(status);
        return taskRepository.save(taskUpdated);
    }

    @Override
    public Iterable<GetAllTasksResponse>  getAllTasks() {
        List<GetAllTasksResponse> list = new ArrayList<>();
        taskRepository.findAll().forEach(task -> list.add(mapper.TaskToGetAllTasksResponse(task)));
        return list;
    }

    @Override
    public GetTaskByIdResponse getTaskById(Long id) {
        Task task=taskRepository.getById(id);
        return mapper.TaskToGetTaskByIdResponse(task);
    }
}


