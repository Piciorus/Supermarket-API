package application.Controller;

import application.Domain.Entities.User;
import application.Domain.Models.User.Request.LoginUserRequest;
import application.Domain.Models.User.Request.RegisterUserRequest;
import application.Domain.Models.User.Response.GetAllUsersResponse;
import application.Domain.Models.User.Response.GetByIdUserResponse;
import application.Services.Interface.IUserService;
import org.springframework.http.HttpStatus;
import application.Config.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin("*")
@RestController()
@Component
public class UserController {

    private final IUserService accountService;

    public UserController(IUserService accountService) {
        this.accountService = accountService;
    }

    @PostMapping(path = "/register")
    @ResponseStatus(HttpStatus.CREATED)
    @Async
    public ResponseEntity<String> addAccount(@RequestBody final RegisterUserRequest registerUserRequest) {
        accountService.register(registerUserRequest);
        return new ResponseEntity<>("", 200, "User createdd!");
    }

    @GetMapping(path = "/getAllUsers")
    @Async
    public Iterable<GetAllUsersResponse> getAllAccounts() {
        return accountService.getAllUsers();
    }

    @PostMapping(path = "/login")
    @Async
    public ResponseEntity<User> loginUser(@RequestBody final LoginUserRequest loginUserRequest) throws Exception {
        return new ResponseEntity<>(accountService.login(loginUserRequest), 200, "You are logged in!");
    }

    @GetMapping(path = "/getUserById/{id}")
    @Async
    public ResponseEntity<GetByIdUserResponse> getAccountById(@PathVariable("id") UUID accountId) {
        return new ResponseEntity<>(accountService.getUserById(accountId), 200, "User by id!");
    }

    @DeleteMapping(path = "/deleteUserById/{id}")
    @Async
    public void deleteAccountById(@PathVariable("id") UUID accountId) {
        accountService.deleteUserById(accountId);
    }
}
