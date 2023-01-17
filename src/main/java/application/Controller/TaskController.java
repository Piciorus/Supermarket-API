package application.Controller;

import application.Domain.Models.Supermarket.Request.AddSupermarketRequest;
import application.Domain.Models.Task.Request.AddTaskRequest;
import application.Domain.Models.Task.Request.UpdateTaskRequest;
import application.Domain.Models.Task.Response.GetAllTasksResponse;
import application.Services.Interface.ITaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController()
@Component
public class TaskController {
    private ITaskService taskService;

    public TaskController(ITaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping(path = "/createTask")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> addSupermarket(@RequestBody final AddTaskRequest addTaskRequest) {
        taskService.saveTask(addTaskRequest);
        return ResponseEntity.ok("Task created");
    }

    @GetMapping(path = "/getAllTasks")
    public Iterable<GetAllTasksResponse> getAllTasks() {
        return taskService.getAllTasks();
    }

    @DeleteMapping(path = "/deleteTaskById/{id}")
    public ResponseEntity<String> deleteTaskById(@PathVariable("id") Long taskId) {
        taskService.deleteTask(taskId);
        return ResponseEntity.ok("Task deleted");
    }

    @PutMapping(path = "/updateTask/{id}")
    public ResponseEntity<String> updateTask(@RequestBody final UpdateTaskRequest updateTaskRequest, @PathVariable("id") Long taskId) {
        taskService.updateTask(updateTaskRequest, taskId);
        return ResponseEntity.ok("Task updated");
    }

    @PutMapping(path = "/updateTaskStatus/{id}")
    public ResponseEntity<String> updateTaskStatus(@PathVariable("id") Long taskId, @RequestParam("status") boolean status) {
        taskService.updateTaskStatus(taskId, status);
        return ResponseEntity.ok("Task status updated");
    }

}
