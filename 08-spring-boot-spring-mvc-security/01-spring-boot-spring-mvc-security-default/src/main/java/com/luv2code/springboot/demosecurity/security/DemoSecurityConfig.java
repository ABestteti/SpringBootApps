package com.luv2code.springboot.demosecurity.security;

import com.luv2code.springboot.demosecurity.service.UserService;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {

  // Add support for JDBC
  @Bean
  public UserDetailsManager userDetailsManager(DataSource dataSource) {
    JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

    // define query to retrieve a user by username
    // The username is passed by the login form automatically thanks for Spring Security.
    jdbcUserDetailsManager.setUsersByUsernameQuery(
        "select user_id, pw, active from members where user_id=?");

    // define query to retrieve the authorities/roles by username
    // The username is passed by the login form automatically thanks for Spring Security.
    jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
        "select user_id, role from roles where user_id=?");

    return jdbcUserDetailsManager;
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

    http.authorizeHttpRequests(
            configurer ->
                configurer
                    .requestMatchers("/")
                    .hasRole("EMPLOYEE")
                    .requestMatchers("/leaders/**")
                    .hasRole("MANAGER")
                    .requestMatchers("/systems/**")
                    .hasRole("ADMIN")
                    .requestMatchers("/register/**")
                    .permitAll()
                    .anyRequest()
                    .authenticated())
        .formLogin(
            form ->
                form.loginPage("/showMyLoginPage")
                    .loginProcessingUrl("/authenticateTheUser")
                    .permitAll())
        .logout(logout -> logout.permitAll())
        .exceptionHandling(configure -> configure.accessDeniedPage("/access-denied"));

    return http.build();
  }

  // BCrypt bean definition
  @Bean
  protected BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  // AuthenticationProvider bean definition
  @Bean
  public DaoAuthenticationProvider daoAuthenticationProvider(UserService userService) {
    DaoAuthenticationProvider auth = new DaoAuthenticationProvider();

    // Set the custom user details service
    auth.setUserDetailsService(userService);

    // Set the password encoder, in this case BCRYPT
    auth.setPasswordEncoder(passwordEncoder());

    return auth;
  }

  //    @Bean
  //    public InMemoryUserDetailsManager userDetailsManager() {
  //        UserDetails john = User.builder()
  //                .username("john")
  //                .password("{noop}test123")
  //                .roles("EMPLOYEE")
  //                .build();
  //
  //        UserDetails mary = User.builder()
  //                .username("mary")
  //                .password("{noop}test123")
  //                .roles("EMPLOYEE", "MANAGER")
  //                .build();
  //
  //        UserDetails susan = User.builder()
  //                .username("susan")
  //                .password("{noop}test123")
  //                .roles("EMPLOYEE", "MANAGER", "ADMIN")
  //                .build();
  //
  //        return new InMemoryUserDetailsManager(john, mary, susan);
  //    }

}
