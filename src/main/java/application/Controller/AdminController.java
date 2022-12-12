package application.Controller;

import application.Model.Employee;
import application.Model.Supermarket;
import application.Services.Implementation.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "https://localhost:4200", maxAge = 3600)
@RestController()
@Component
public class AdminController {
    private AdminService adminService;
    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    public AdminController() {

    }

    @PostMapping(path = "/addEmployee")
    public Employee addEmployee(@RequestBody final Employee employee) {
        return adminService.createEmployee(employee);
    }

    @PostMapping(path = "/addSupermarket")
    public Supermarket addSupermarket(@RequestBody final Supermarket supermarket) {
        return adminService.createSupermarket(supermarket);
    }

    @GetMapping(path = "/getAllEmployees")
    public Iterable<Employee> getAllEmployees() {
        return adminService.getAllEmployees();
    }

    @GetMapping(path = "/getAllSupermarkets")
    public Iterable<Supermarket> getAllSupermarkets() {
        return adminService.getAllSupermarkets();
    }

    @GetMapping(path = "/getEmployeeById/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long employeeId) {
        return ResponseEntity.ok(adminService.getEmployeeById(employeeId));
    }

    @GetMapping(path = "/getSupermarketById/{id}")
    public ResponseEntity<Supermarket> getSupermarketById(@PathVariable("id") Long supermarketId) {
        return ResponseEntity.ok(adminService.getSupermarketById(supermarketId));
    }

    @DeleteMapping(path = "/deleteEmployeeById/{id}")
    public void deleteEmployeeById(@PathVariable("id") Long employeeId) {
        adminService.deleteEmployee(employeeId);
    }

    @DeleteMapping(path = "/removeSupermarketById/{id}")
    public void removeSupermarketById(@PathVariable("id") Long supermarketId) {
        adminService.removeSupermarket(supermarketId);
    }

    @PutMapping(path = "/updateEmployee/{id}")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee,@PathVariable("id") Long employeeId) {
        return ResponseEntity.ok(adminService.updateEmployee(employee,employeeId));
    }

    @PutMapping(path = "/updateSupermarket/{id}")
    public ResponseEntity<Supermarket> updateSupermarket(@RequestBody Supermarket supermarket,@PathVariable("id") Long supermarketId) {
        return ResponseEntity.ok(adminService.updateSupermarket(supermarket,supermarketId));
    }

}
