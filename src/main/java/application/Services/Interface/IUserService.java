package application.Services.Interface;

import application.Domain.Entities.User;
import application.Domain.Models.User.Request.UserRequestLogin;
import application.Domain.Models.User.Request.UserRequestRegister;
import application.Domain.Models.User.Response.UserResponseGetAllUsers;
import application.Domain.Models.User.Response.UserResponseGetById;
import application.Exception.CustomException;

public interface IUserService {
    User register(UserRequestRegister userRequest);
    void deleteUserById(Long id);
    Iterable<UserResponseGetAllUsers> getAllUsers();
    UserResponseGetById getUserById(Long id);
    User login(UserRequestLogin userRequestLogin) throws CustomException;
}
