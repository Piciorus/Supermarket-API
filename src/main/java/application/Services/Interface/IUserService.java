package application.Services.Interface;

import application.Domain.Entities.User;
import application.Domain.Models.User.Request.LoginUserRequest;
import application.Domain.Models.User.Request.RegisterUserRequest;
import application.Domain.Models.User.Response.GetAllUsersResponse;
import application.Domain.Models.User.Response.GetByIdUserResponse;
import org.springframework.scheduling.annotation.Async;

import java.util.UUID;

public interface IUserService {
    @Async
    User register(RegisterUserRequest userRequest);

    @Async
    void deleteUserById(UUID id);

    @Async
    Iterable<GetAllUsersResponse> getAllUsers();

    @Async
    GetByIdUserResponse getUserById(UUID id);

    @Async
    User login(LoginUserRequest userRequestLogin) throws Exception;

}
