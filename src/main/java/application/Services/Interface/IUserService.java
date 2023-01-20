package application.Services.Interface;

import application.Domain.Entities.User;
import application.Domain.Models.User.Request.LoginUserRequest;
import application.Domain.Models.User.Request.RegisterUserRequest;
import application.Domain.Models.User.Response.GetAllUsersResponse;
import application.Domain.Models.User.Response.GetByIdUserResponse;

import java.util.UUID;

public interface IUserService {
    User register(RegisterUserRequest userRequest);
    void deleteUserById(UUID id);
    Iterable<GetAllUsersResponse> getAllUsers();
    GetByIdUserResponse getUserById(UUID id);
    User login(LoginUserRequest userRequestLogin) throws  Exception;

}
