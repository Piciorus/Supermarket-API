package application.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity(debug = true)
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String ADMIN_ROLE = "ADMIN";

    private static final String BASIC_USER_ROLE = "BASIC_USER";

    public static final String[] PROTECTED_RESOURCES = new String[] {  "/account/users" };

    @Override
    public void configure(HttpSecurity  http) throws Exception {
        http.csrf().disable();
//        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//        http.authorizeRequests()
//                .antMatchers( "/create").hasRole(BASIC_USER_ROLE)
//                .antMatchers("/createEmployee").hasRole(ADMIN_ROLE)
//                .antMatchers("/deleteEmployee/{id}").hasRole(ADMIN_ROLE)
//                .antMatchers("/createsupermarket").hasRole(ADMIN_ROLE)
//                .antMatchers("/deleteSupermarket/{id}").hasRole(ADMIN_ROLE)
//                .anyRequest()
//                .authenticated()
//                .and()
//                .formLogin().disable()
//                .httpBasic();


    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
    }
}
