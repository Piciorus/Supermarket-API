package application.Controller;

import application.Model.Account;
import application.Model.Employee;
import application.Services.Implementation.AccountService;
import application.Services.Implementation.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "https://localhost:4200", maxAge = 3600)
@RestController()
@Component
public class AccountController {

    private AdminService adminService;
    @Autowired
    private AccountService accountService;
    public AccountController(AdminService adminService) {
        this.adminService = adminService;
    }
    public AccountController() {

    }
    @GetMapping(path = "/accounts")
    public ResponseEntity<List<Account>> getUsers() {
        return ResponseEntity.ok(accountService.getAll());
    }

    @PostMapping(path = "/create")
    public ResponseEntity<Account> create(@RequestBody final Account account) {
        return ResponseEntity.ok(accountService.create(account));
    }
    @GetMapping(path = "/getAccountById/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable("id") final int id) {
        return ResponseEntity.ok(accountService.getUserById(id));
    }
}
