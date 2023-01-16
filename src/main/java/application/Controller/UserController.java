package application.Controller;

import application.Domain.Models.User.Request.LoginUserRequest;
import application.Domain.Models.User.Request.RegisterUserRequest;
import application.Domain.Models.User.Response.GetAllUsersResponse;
import application.Domain.Models.User.Response.GetByIdUserResponse;
import application.Services.Interface.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController()
@Component
public class UserController {

    private IUserService accountService;
    public UserController(IUserService accountService) {
        this.accountService = accountService;
    }

    @PostMapping(path = "/register")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> addAccount(@RequestBody final RegisterUserRequest registerUserRequest) {
        accountService.register(registerUserRequest);
        return new ResponseEntity<>("User created ",HttpStatus.OK);
    }

    @GetMapping(path = "/getAllUsers")
    public Iterable<GetAllUsersResponse> getAllAccounts() {
        return accountService.getAllUsers();
    }

    @PostMapping(path = "/login")
    public ResponseEntity<String> loginUser(@RequestBody final LoginUserRequest userLogin) throws Exception {
        accountService.login(userLogin);
        return ResponseEntity.ok("You are logged in ");
    }

    @GetMapping(path = "/getUserById/{id}")
    public ResponseEntity<GetByIdUserResponse> getAccountById(@PathVariable("id") Long accountId) {
        return ResponseEntity.ok(accountService.getUserById(accountId));
    }
    @DeleteMapping(path = "/deleteUserById/{id}")
    public void deleteAccountById(@PathVariable("id") Long accountId) {
        accountService.deleteUserById(accountId);
    }


}
