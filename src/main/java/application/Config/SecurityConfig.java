package application.Config;

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
    private static final String ADMIN_ROLE = "ADMIN";
    private static final String BASIC_USER_ROLE = "User";
    private final UserDetailsService userDetailsService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public SecurityConfig(@Qualifier("customUserDetailsService")
                          final UserDetailsService userDetailsService,
                          final BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userDetailsService = userDetailsService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        String password = bCryptPasswordEncoder.encode("password");
//
//        auth.inMemoryAuthentication()
//                .withUser("user").password(password).roles("USER")
//                .and()
//                .withUser("admin").password(password).roles("ADMIN");
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http
        .authorizeRequests()
//              -user-
        .antMatchers(HttpMethod.POST, "/register").anonymous()
        .antMatchers(HttpMethod.POST, "/login").anonymous()
//              -admin-
        .antMatchers(HttpMethod.GET, "/getAllUsers").hasAnyRole(ADMIN_ROLE, BASIC_USER_ROLE)
        .antMatchers(HttpMethod.GET, "/getUserById/{id}").hasRole(ADMIN_ROLE)
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
        .antMatchers(HttpMethod.GET,"/createEmployee").anonymous()
        .anyRequest()
        .authenticated()
        .and()
        .cors()
        .and()
        .formLogin().disable()
        .httpBasic();
    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService);
//    }
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
    }
}

//http.csrf().disable();
//        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//        http
//        .authorizeRequests()
////              -user-
//        .antMatchers(HttpMethod.POST, "/register").hasRole("USER")
//        .antMatchers(HttpMethod.POST, "/login").hasRole("USER")
////              -admin-
//        .antMatchers(HttpMethod.GET, "/getAllUsers").hasAnyRole("ADMIN", BASIC_USER_ROLE)
//        .antMatchers(HttpMethod.GET, "/getUserById/{id}").hasRole("USER")
//        .antMatchers(HttpMethod.DELETE, "/deleteUserById/{id}").hasRole("USER")
//        .antMatchers(HttpMethod.POST, "/createSupermarket").hasRole("USER")
//        .antMatchers(HttpMethod.GET, "/getAllSupermarkets").hasRole("USER")
//        .antMatchers(HttpMethod.GET, "/getSupermarketById/{id}").hasRole("USER")
//        .antMatchers(HttpMethod.DELETE, "/deleteSupermarketById/{id}").hasRole("USER")
//        .antMatchers(HttpMethod.PUT, "/updateSupermarket/{id}").hasRole("USER")
//        .antMatchers(HttpMethod.POST, "/addProductToSupermarket/{id}").hasRole("USER")
//        .antMatchers(HttpMethod.DELETE,"/deleteProductFromSupermarket/{id}").hasRole("USER")
//        .antMatchers(HttpMethod.POST,"/getAllProductsFromSupermarket/{id}").hasRole("USER")
//        .antMatchers(HttpMethod.PUT,"/updateProductPrice/{id}").hasRole("USER")
//        .antMatchers(HttpMethod.GET,"/getProductById/{id}").hasRole("USER")
//        .antMatchers(HttpMethod.GET,"/createEmployee").hasRole("USER")
//        .anyRequest()
//        .authenticated()
//        .and()
//        .cors()
//        .and()
//        .formLogin().disable()
//        .httpBasic();





