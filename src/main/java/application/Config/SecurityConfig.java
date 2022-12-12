package application.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

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
                .withUser("admin").password(password).roles("ADMIN")
                .and()
                .withUser("manager").password(password).roles("MANAGER");

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
                .antMatchers(HttpMethod.POST, "/addAccount").hasRole("USER")

//              -admin-
                .antMatchers(HttpMethod.GET, "/getAllAccounts").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/getAccountById/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/deleteAccountById/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/updateAccount/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/getAllSupermarkets").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/addEmployee").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/addSupermarket").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/getEmployeeById").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/getSupermarketById").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/getAllEmployees").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/deleteEmployeeById").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/removeSupermarketById/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/updateEmployee/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/updateSupermarket/{id}").hasRole("ADMIN")
//               -manager-

                .antMatchers(HttpMethod.GET, "/getAllProducts").hasRole("MANAGER")
                .antMatchers(HttpMethod.GET, "/getProduct/{id}").hasRole("MANAGER")
                .antMatchers(HttpMethod.DELETE,"/deleteProduct/{id}").hasRole("MANAGER")
                .antMatchers(HttpMethod.POST,"/addProduct/{id}").hasRole("MANAGER")

                .and()
                .csrf().disable()
                .formLogin().disable();
    }
}







