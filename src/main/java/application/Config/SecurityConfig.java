package application.Config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity(debug = true)
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private static final String ADMIN_ROLE = "ADMIN";
    private static final String BASIC_USER_ROLE = "USER";
    private static final String CLIENT_ROLE = "CLIENT";

    private static final String EMPLOYEE_ROLE = "EMPLOYEE";
    private final UserDetailsService userDetailsService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public SecurityConfig(@Qualifier("customUserDetailsService") final UserDetailsService userDetailsService,
                          final BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userDetailsService = userDetailsService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http
                .authorizeRequests()
                //                          -user-
                .antMatchers(HttpMethod.POST, "/register").anonymous()
                .antMatchers(HttpMethod.POST, "/login").anonymous()
                .antMatchers(HttpMethod.GET, "/getAllUsers").hasAnyRole(ADMIN_ROLE)
                .antMatchers(HttpMethod.GET, "/getUserById/{id}").hasAnyRole(ADMIN_ROLE, BASIC_USER_ROLE)
                .antMatchers(HttpMethod.DELETE, "/deleteUserById/{id}").hasAnyRole(ADMIN_ROLE)
                //                         -supermarket-
                .antMatchers(HttpMethod.POST, "/createSupermarket").hasAnyRole(ADMIN_ROLE)
                .antMatchers(HttpMethod.GET, "/getAllSupermarkets").hasAnyRole(ADMIN_ROLE, CLIENT_ROLE)
                .antMatchers(HttpMethod.GET, "/getSupermarketById/{id}").hasAnyRole(ADMIN_ROLE)
                .antMatchers(HttpMethod.DELETE, "/deleteSupermarketById/{id}").hasAnyRole(ADMIN_ROLE)
                .antMatchers(HttpMethod.PUT, "/updateSupermarket/{id}").hasAnyRole(ADMIN_ROLE)
                //                          -product-
                .antMatchers(HttpMethod.POST, "/addProductToSupermarket/{id}").hasAnyRole(ADMIN_ROLE)
                .antMatchers(HttpMethod.DELETE, "/deleteProductFromSupermarket/{id}").hasAnyRole(ADMIN_ROLE)
                .antMatchers(HttpMethod.POST, "/getAllProductsFromSupermarket/{id}").hasAnyRole(ADMIN_ROLE, BASIC_USER_ROLE)
                .antMatchers(HttpMethod.PUT, "/updateProductPrice/{id}").hasAnyRole(ADMIN_ROLE)
                .antMatchers(HttpMethod.GET, "/getProductById/{id}").hasAnyRole(ADMIN_ROLE)
                //                          -shoppinglist-
                .antMatchers(HttpMethod.POST, "/addProductToShoppingList/{id}/{id1}").hasAnyRole(ADMIN_ROLE, CLIENT_ROLE)
                .antMatchers(HttpMethod.POST, "/createShoppingList/{id}").hasAnyRole(ADMIN_ROLE, CLIENT_ROLE)
                .antMatchers(HttpMethod.GET, "/getShoppingListById/{id}").hasAnyRole(ADMIN_ROLE, CLIENT_ROLE)
                .antMatchers(HttpMethod.DELETE, "/deleteShoppingList/{id}").hasAnyRole(ADMIN_ROLE, CLIENT_ROLE)
                .antMatchers(HttpMethod.DELETE, "/deleteProductFromShoppingList/{id}/{id1}").hasAnyRole(ADMIN_ROLE, CLIENT_ROLE)
                //                          -task-
                .antMatchers(HttpMethod.GET, "/getAllTasks").hasAnyRole(ADMIN_ROLE, EMPLOYEE_ROLE)
                .antMatchers(HttpMethod.GET, "/getAllTasksByEmployeeId/{id}").hasAnyRole(ADMIN_ROLE, EMPLOYEE_ROLE)
                .antMatchers(HttpMethod.DELETE, "/deleteTaskById/{id}").hasAnyRole(ADMIN_ROLE, EMPLOYEE_ROLE)
                .antMatchers(HttpMethod.PUT, "/updateTask/{id}").hasAnyRole(ADMIN_ROLE, EMPLOYEE_ROLE)
                .antMatchers(HttpMethod.POST, "/addTaskToEmployee/{id}").hasAnyRole(ADMIN_ROLE, EMPLOYEE_ROLE)
                .antMatchers(HttpMethod.PUT, "/updateTaskStatus/{id}").hasAnyRole(ADMIN_ROLE, EMPLOYEE_ROLE)
                .antMatchers(HttpMethod.DELETE, "/removeTaskFromEmployee/{id}").hasAnyRole(ADMIN_ROLE, EMPLOYEE_ROLE)
                .anyRequest()
                .authenticated()
                .and()
                .cors()
                .and()
                .formLogin().disable()
                .httpBasic();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
    }
}






