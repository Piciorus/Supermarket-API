package application.Config;

import application.Domain.Entities.Product;
import application.Domain.Entities.Supermarket;
import application.Domain.Entities.User;
import application.Domain.Models.Product.Request.ProductRequestUpdatePrice;
import application.Domain.Models.Product.Response.ProductResponseGetAll;
import application.Domain.Models.Supermarket.Request.SupermarketRequestCreate;
import application.Domain.Models.Supermarket.Response.SupermarketResponseGetAll;
import application.Domain.Models.User.Request.UserRequestLogin;
import application.Domain.Models.User.Request.UserRequestRegister;
import application.Domain.Models.User.Response.UserResponseGetAllUsers;
import application.Exception.CustomException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Configuration
@EnableWebSecurity(debug = true)
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        String password = passwordEncoder().encode("password");

        auth.inMemoryAuthentication()
                .withUser("user").password(password).roles("USER")
                .and()
                .withUser("admin").password(password).roles("ADMIN");
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .httpBasic()
                .and()
                .authorizeRequests()
//              -user-
                .antMatchers(HttpMethod.POST, "/register").hasRole("USER")
                .antMatchers(HttpMethod.POST, "/login").hasRole("USER")
//              -admin-
                .antMatchers(HttpMethod.GET, "/getAllAccounts").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/getAccountById/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/deleteAccountById/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/createSupermarket").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/getAllSupermarkets").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/getSupermarketById/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/deleteSupermarketById/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/updateSupermarket/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/addProductToSupermarket/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE,"/deleteProductFromSupermarket/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST,"/getAllProductsFromSupermarket/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT,"/updateProductPrice/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/getProductById/{id}").hasRole("ADMIN")
                .and()
                .csrf().disable()
                .formLogin().disable();
    }
}







