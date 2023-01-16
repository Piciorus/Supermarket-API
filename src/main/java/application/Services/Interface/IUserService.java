package application.Services.Interface;

import application.Domain.Entities.User;
import application.Domain.Models.User.Request.LoginUserRequest;
import application.Domain.Models.User.Request.RegisterUserRequest;
import application.Domain.Models.User.Response.GetAllUsersResponse;
import application.Domain.Models.User.Response.GetByIdUserResponse;

public interface IUserService {
    User register(RegisterUserRequest userRequest);
    void deleteUserById(Long id);
    Iterable<GetAllUsersResponse> getAllUsers();
    GetByIdUserResponse getUserById(Long id);
    User login(LoginUserRequest userRequestLogin) throws  Exception;

}
