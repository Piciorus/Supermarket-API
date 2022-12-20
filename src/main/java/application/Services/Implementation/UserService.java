package application.Services.Implementation;

import application.Domain.Entities.User;
import application.Domain.Models.User.Request.LoginUserRequest;
import application.Domain.Models.User.Request.RegisterUserRequest;
import application.Domain.Models.User.Response.GetAllUsersResponse;
import application.Domain.Models.User.Response.GetByIdUserResponse;
import application.Repository.UserRepository;
import application.Services.Interface.IUserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import application.Domain.Mapper.Mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class UserService implements IUserService {
    private UserRepository userRepository;
    private Mapper mapper;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(UserRepository userRepository, Mapper mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
        bCryptPasswordEncoder = new BCryptPasswordEncoder();
    }
    @Override
    public User register(RegisterUserRequest userRequestRegister) {
        User user = mapper.RegisterUserRequestToUser(userRequestRegister);
        return userRepository.save(user);
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Iterable<GetAllUsersResponse> getAllUsers() {
        List<GetAllUsersResponse> list = new ArrayList<>();
        userRepository.findAll().forEach(user -> {
            list.add(mapper.UserToGetAllUsersResponse(user));
        });
        return list;
    }

    @Override
    public GetByIdUserResponse getUserById(Long id) {
        User user = userRepository.getById(id);
        return mapper.UserToGetByIdUserResponse(user);
    }

    @Override
    public User login(LoginUserRequest userRequestLogin) throws Exception {
        if (Objects.isNull(userRequestLogin)) {
            throw new Exception("Body null !");
        }

        if (Objects.isNull(userRequestLogin.getUsername())) {
            throw new Exception("Username cannot be null ! ");
        }

        if (Objects.isNull(userRequestLogin.getPassword())) {
            throw new Exception("Password cannot be null !");
        }

        User user1 = userRepository.customQuery(userRequestLogin.getUsername());

        if (Objects.isNull(user1)) {
            throw new Exception("Bad credentials !");
        }

        if (!bCryptPasswordEncoder.matches(userRequestLogin.getPassword(), user1.getPassword())) {
            throw new Exception("Bad credentials !");
        }

        return user1;
    }

}
