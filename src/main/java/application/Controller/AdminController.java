package application.Controller;

import application.Model.Account;
import application.Model.Admin;
import application.Model.Employee;
import application.Model.Supermarket;
import application.Services.Implementation.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "https://localhost:4200", maxAge = 3600)
@RestController()
@Component
public class AdminController {
    @Autowired
    private AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    public AdminController() {

    }

    @PostMapping(path = "/createEmployee")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        return ResponseEntity.ok(adminService.createEmployee(employee));
    }

    @GetMapping(path = "/getEmployeeById/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") final int id) {
        return ResponseEntity.ok(adminService.getEmployeeById(id));
    }

    @PostMapping(path = "/createsupermarket")
    public ResponseEntity<Supermarket> createSupermarket(@RequestBody Supermarket supermarket) {
        return ResponseEntity.ok(adminService.createSupermarket(supermarket));
    }

    @GetMapping(path = "/getSupermarketById/{id}")
    public ResponseEntity<Supermarket> getSupermarketById(@PathVariable("id") final int id) {
        return ResponseEntity.ok(adminService.getSupermarketById(id));
    }

    @GetMapping(path = "/getAllEmployees")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.ok(adminService.getAllEmployees());
    }

    @GetMapping(path = "/getAllSupermarkets")
    public ResponseEntity<List<Supermarket>> getAllSupermarkets() {
        return ResponseEntity.ok(adminService.getAllSupermarkets());
    }

    @DeleteMapping(path = "/deleteEmployee/{id}")
    public void deleteEmployee(@PathVariable("id") final int id) {
        adminService.deleteEmployee(id);
    }

    @DeleteMapping(path = "/deleteSupermarket/{id}")
    public void deleteSupermarket(@PathVariable("id") final int id) {
        adminService.removeSupermarket(id);
    }

}
