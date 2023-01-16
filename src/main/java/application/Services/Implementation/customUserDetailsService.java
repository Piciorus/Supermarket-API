package application.Services.Implementation;

import application.Domain.Entities.CustomUserDetails;
import application.Domain.Entities.User;
import application.Repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static java.util.Collections.emptyList;

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
