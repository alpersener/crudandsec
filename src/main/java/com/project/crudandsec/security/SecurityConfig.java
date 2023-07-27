package com.project.crudandsec.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        JdbcUserDetailsManager jdbcUserDetailsManager=new JdbcUserDetailsManager(dataSource);
        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "select username,password,'true' as enabled from user where username=?"
        );
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "select username,role_name from roles where username=?"
        );
        return jdbcUserDetailsManager;

    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.authorizeHttpRequests(configurer->
                configurer
                        .requestMatchers(HttpMethod.GET,"/api/persons").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET,"/api/persons/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST,"/api/persons").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT,"/api/persons").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE,"/api/persons/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET,"/api/persondetails").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET,"/api/persondetails/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST,"/api/persondetails").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT,"/api/persondetails").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE,"/api/persondetails/**").hasRole("ADMIN")



        );
        //Basic auth
        httpSecurity.httpBasic(Customizer.withDefaults());

        //disable Cross Site Request Forgery(CSRF)
        //Genel olarak (POST, PUT, DELETE ve/veya PATCH) kullanan stateless Rest Api'larda CSRF koruması gerekli değildir
        httpSecurity.csrf(csrf->csrf.disable());
        return httpSecurity.build();
    }

}
