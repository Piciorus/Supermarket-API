package application.Controller;

import application.Domain.Models.Supermarket.Request.AddSupermarketRequest;
import application.Domain.Models.Task.Request.AddTaskRequest;
import application.Domain.Models.Task.Request.AddTaskToEmployeeRequest;
import application.Domain.Models.Task.Request.UpdateTaskRequest;
import application.Domain.Models.Task.Response.GetAllTasksResponse;
import application.Services.Interface.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin("*")
@RestController()
@Component
public class TaskController {
    private final ITaskService taskService;
    @Autowired
    public TaskController(ITaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping(path = "/getAllTasks")
    public Iterable<GetAllTasksResponse> getAllTasks() {
        return taskService.getAllTasks();
    }

    @DeleteMapping(path = "/deleteTaskById/{id}")
    public ResponseEntity<String> deleteTaskById(@PathVariable("id") UUID taskId) {
        taskService.deleteTask(taskId);
        return ResponseEntity.ok("Task deleted");
    }

    @PutMapping(path = "/updateTask/{id}")
    public ResponseEntity<String> updateTask(@RequestBody final UpdateTaskRequest updateTaskRequest, @PathVariable("id") UUID taskId) {
        taskService.updateTask(updateTaskRequest, taskId);
        return ResponseEntity.ok("Task updated");
    }

    @PutMapping(path = "/updateTaskStatus/{id}")
    public ResponseEntity<String> updateTaskStatus(@PathVariable("id") UUID taskId, @RequestBody String status) {
        taskService.updateTaskStatus(taskId, status);
        return ResponseEntity.ok("Task status updated");
    }

    @PostMapping(path = "/addTaskToEmployee/{id}")
    public ResponseEntity<String> addTaskToEmployee(@RequestBody final AddTaskToEmployeeRequest addTaskToEmployeeRequest, @PathVariable("id") UUID taskId) {
        taskService.addTaskToEmployee(addTaskToEmployeeRequest, taskId);
        return ResponseEntity.ok("Task added to employee");
    }

    @DeleteMapping(path = "/removeTaskFromEmployee/{id}")
    public ResponseEntity<String> removeTaskFromEmployee(@PathVariable("id") UUID taskId) {
        taskService.removeTaskFromEmployee(taskId);
        return ResponseEntity.ok("Task removed from employee");
    }

    @GetMapping(path = "/getAllTasksByEmployeeId/{id}")
    public Iterable<GetAllTasksResponse> getAllTasksByEmployeeId(@PathVariable("id") UUID employeeId) {
        return taskService.getAllTasksByEmployeeId(employeeId);
    }
}
