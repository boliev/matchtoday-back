package ru.matchtoday;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    @Value( "${auth.admin.name}" )
    private String adminName;
    @Value( "${auth.admin.password}" )
    private String adminPassword;
    @Value( "${auth.user.name}" )
    private String userName;
    @Value( "${pauth.user.password}" )
    private String userPassword;

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable().authorizeRequests()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and().httpBasic();

    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authentication)
            throws Exception {
        authentication.inMemoryAuthentication()
                .withUser(userName)
                .password(passwordEncoder().encode(userPassword))
                .authorities("ROLE_USER")
                .and()
                .withUser(adminName)
                .password(passwordEncoder().encode(adminPassword))
                .authorities("ROLE_ADMIN");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
