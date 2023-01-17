package application.Services.Implementation.Security;

import application.Domain.Entities.Security.CustomUserDetails;
import application.Domain.Entities.User;
import application.Repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Objects;

public class customUserDetailsService implements UserDetailsService {
    private UserRepository userRepository;

    public customUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        final User user = userRepository.findByUsername(s);
        if(Objects.isNull(user)){
            throw new UsernameNotFoundException("User not found");
        }
        return new CustomUserDetails(user);

    }
}
