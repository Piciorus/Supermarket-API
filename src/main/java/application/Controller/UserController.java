package application.Controller;

import application.Domain.Entities.User;
import application.Domain.Models.User.Request.UserRequestLogin;
import application.Domain.Models.User.Request.UserRequestRegister;
import application.Domain.Models.User.Response.UserResponseGetAllUsers;
import application.Exception.CustomException;
import application.Services.Interface.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "https://localhost:4200", maxAge = 3600)
@RestController()
@Component
public class UserController {

    private IUserService accountService;
    @Autowired
    public UserController(IUserService accountService) {
        this.accountService = accountService;
    }

    @PostMapping(path = "/register")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> addAccount(@RequestBody final UserRequestRegister userRequestRegister ) {
        accountService.createAccount(userRequestRegister);
        return new ResponseEntity<>("User created ",HttpStatus.OK);
    }

    @GetMapping(path = "/getAllAccounts")
    public Iterable<UserResponseGetAllUsers> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @PostMapping(path = "/login")
    public ResponseEntity<String> loginUser(@RequestBody final UserRequestLogin userRequestLogin) throws CustomException {
        accountService.login(userRequestLogin);
        return new ResponseEntity<>("You are logged in ",HttpStatus.OK);
    }

    @GetMapping(path = "/getAccountById/{id}")
    public ResponseEntity<User> getAccountById(@PathVariable("id") Long accountId) {
        return ResponseEntity.ok(accountService.getAccountById(accountId));
    }
    @DeleteMapping(path = "/deleteAccountById/{id}")
    public void deleteAccountById(@PathVariable("id") Long accountId) {
        accountService.deleteAccountById(accountId);
    }


}
