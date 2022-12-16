package application.Services.Implementation;

import application.Domain.Entities.User;
import application.Domain.Models.User.Request.UserRequestLogin;
import application.Domain.Models.User.Request.UserRequestRegister;
import application.Domain.Models.User.Response.UserResponseGetAllUsers;
import application.Exception.CustomException;
import application.Repository.UserRepository;
import application.Services.Interface.IUserService;
import org.springframework.stereotype.Service;
import application.Domain.Mapper.Mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class UserService implements IUserService {
    private UserRepository userRepository;
    private Mapper mapper;

    public UserService(UserRepository userRepository, Mapper mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }
    @Override
    public User createAccount(UserRequestRegister userRequestRegister) {
        User user = mapper.UserRequestToUser(userRequestRegister);
        return userRepository.save(user);
    }

    @Override
    public void deleteAccountById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Iterable<UserResponseGetAllUsers> getAllAccounts() {
        List<UserResponseGetAllUsers> list = new ArrayList<>();
        userRepository.findAll().forEach(user -> {
            list.add(mapper.UserToUserResponse(user));
        });
        return list;
    }

    @Override
    public User getAccountById(Long id) {
        return userRepository.getById(id);
    }

    @Override
    public User login(UserRequestLogin userRequestLogin) throws CustomException {
        if (Objects.isNull(userRequestLogin)) {
            throw new CustomException("Body null !");
        }

        if (Objects.isNull(userRequestLogin.getUsername())) {
            throw new CustomException("Username cannot be null ! ");
        }

        if (Objects.isNull(userRequestLogin.getPassword())) {
            throw new CustomException("Password cannot be null !");
        }

        User user1 = userRepository.customQuery(userRequestLogin.getUsername());

        if (Objects.isNull(user1)) {
            throw new CustomException("Bad credentials !");
        }

        if (!user1.getPassword().equals(userRequestLogin.getPassword())) {
            throw new CustomException("Bad credentials !");
        }

        return user1;
    }

}
