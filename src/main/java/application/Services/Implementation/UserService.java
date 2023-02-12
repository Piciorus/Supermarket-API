package application.Services.Implementation;

import application.Domain.Entities.User;
import application.Domain.Mapper.Mapper;
import application.Domain.Models.User.Request.LoginUserRequest;
import application.Domain.Models.User.Request.RegisterUserRequest;
import application.Domain.Models.User.Response.GetAllUsersResponse;
import application.Domain.Models.User.Response.GetByIdUserResponse;
import application.Exception.CustomException;
import application.Repository.RoleRepository;
import application.Repository.UserRepository;
import application.Services.Interface.IUserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class UserService implements IUserService {
    private final UserRepository userRepository;
    private final Mapper mapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final RoleRepository roleRepository;

    public UserService(UserRepository userRepository, Mapper mapper, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.mapper = mapper;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.roleRepository = roleRepository;
    }

    @Override
    public User register(RegisterUserRequest userRequestRegister) {
        return userRepository.save(mapper.RegisterUserRequestToUser(userRequestRegister));
    }


    @Override
    public void deleteUserById(UUID id) {
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
    public GetByIdUserResponse getUserById(UUID id) {
        User user = userRepository.getById(id);
        return mapper.UserToGetByIdUserResponse(user);
    }

    @Override
    public User login(LoginUserRequest userRequestLogin) throws CustomException {
        if (Objects.isNull(userRequestLogin)) {
            throw new CustomException(401,"Body null !");
        }

        if (Objects.isNull(userRequestLogin.getUsername())) {
            throw new CustomException(400,"Username cannot be null ! ");
        }

        if (Objects.isNull(userRequestLogin.getPassword())) {
            throw new CustomException(400,"Password cannot be null !");
        }

        User user1 = userRepository.findByUsername(userRequestLogin.getUsername());

        if (Objects.isNull(user1)) {
            throw new CustomException(402,"Bad credentials !");
        }

        if (!bCryptPasswordEncoder.matches(userRequestLogin.getPassword(), user1.getPassword())) {
            throw new CustomException(402,"Bad credentials !");
        }

        return user1;
    }

}
