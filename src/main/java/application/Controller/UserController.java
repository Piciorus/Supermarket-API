package application.Controller;

import application.Domain.Entities.User;
import application.Domain.Models.User.Request.UserRequestLogin;
import application.Domain.Models.User.Request.UserRequestRegister;
import application.Domain.Models.User.Response.UserResponseGetAllUsers;
import application.Domain.Models.User.Response.UserResponseGetById;
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
        accountService.register(userRequestRegister);
        return new ResponseEntity<>("User created ",HttpStatus.OK);
    }

    @GetMapping(path = "/getAllUsers")
    public Iterable<UserResponseGetAllUsers> getAllAccounts() {
        return accountService.getAllUsers();
    }

    @PostMapping(path = "/login")
    public ResponseEntity<String> loginUser(@RequestBody final UserRequestLogin userRequestLogin) throws CustomException {
        accountService.login(userRequestLogin);
        return new ResponseEntity<>("You are logged in ",HttpStatus.OK);
    }

    @GetMapping(path = "/getUserById/{id}")
    public ResponseEntity<UserResponseGetById> getAccountById(@PathVariable("id") Long accountId) {
        return ResponseEntity.ok(accountService.getUserById(accountId));
    }
    @DeleteMapping(path = "/deleteUserById/{id}")
    public void deleteAccountById(@PathVariable("id") Long accountId) {
        accountService.deleteUserById(accountId);
    }


}
