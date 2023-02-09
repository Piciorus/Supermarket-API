package application.Config;

import application.Domain.Mapper.Mapper;
import application.Repository.RoleRepository;
import application.Repository.UserRepository;
import application.Services.Implementation.Security.customUserDetailsService;
import application.Services.Implementation.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class AppConfig {
    @Bean
    public UserService userService(final UserRepository userRepository,
                                   final Mapper mapper,
                                   final RoleRepository roleRepository,
                                   final BCryptPasswordEncoder passwordEncoder) {
        return new UserService(userRepository, mapper, roleRepository, passwordEncoder);
    }

    @Bean("customUserDetailsService")
    public UserDetailsService createUserDetailsService(final UserRepository userRepository) {
        return new customUserDetailsService(userRepository);
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
