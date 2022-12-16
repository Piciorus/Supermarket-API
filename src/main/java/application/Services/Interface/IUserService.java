package application.Services.Interface;

import application.Domain.Entities.User;
import application.Domain.Models.User.Request.UserRequestLogin;
import application.Domain.Models.User.Request.UserRequestRegister;
import application.Domain.Models.User.Response.UserResponseGetAllUsers;
import application.Exception.CustomException;

public interface IUserService {
    User createAccount(UserRequestRegister userRequest);
    void deleteAccountById(Long id);
    Iterable<UserResponseGetAllUsers> getAllAccounts();
    User getAccountById(Long id);
    User login(UserRequestLogin userRequestLogin) throws CustomException;
}
