package application.Config;

import application.Repository.RoleRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity(debug = true)
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http
                .httpBasic()
                .and()
                .authorizeRequests()
//              -user-
                .antMatchers(HttpMethod.POST, "/register").anonymous()
                .antMatchers(HttpMethod.POST, "/login").anonymous()
//              -admin-
                .antMatchers(HttpMethod.GET, "/getAllUsers").anonymous()
                .antMatchers(HttpMethod.GET, "/getUserById/{id}").anonymous()
                .antMatchers(HttpMethod.DELETE, "/deleteUserById/{id}").anonymous()
                .antMatchers(HttpMethod.POST, "/createSupermarket").anonymous()
                .antMatchers(HttpMethod.GET, "/getAllSupermarkets").anonymous()
                .antMatchers(HttpMethod.GET, "/getSupermarketById/{id}").anonymous()
                .antMatchers(HttpMethod.DELETE, "/deleteSupermarketById/{id}").anonymous()
                .antMatchers(HttpMethod.PUT, "/updateSupermarket/{id}").anonymous()
                .antMatchers(HttpMethod.POST, "/addProductToSupermarket/{id}").anonymous()
                .antMatchers(HttpMethod.DELETE,"/deleteProductFromSupermarket/{id}").anonymous()
                .antMatchers(HttpMethod.POST,"/getAllProductsFromSupermarket/{id}").anonymous()
                .antMatchers(HttpMethod.PUT,"/updateProductPrice/{id}").anonymous()
                .antMatchers(HttpMethod.GET,"/getProductById/{id}").anonymous()
                .and()
                .cors().and()
                .csrf().disable()
                .formLogin().disable();
    }
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
    }
}







