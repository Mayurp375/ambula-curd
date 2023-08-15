package com.example.demo.ambula.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.http.HttpServletResponse;

@Configuration
@EnableWebSecurity
@SuppressWarnings("deprecation")
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().and().authorizeRequests()
                .antMatchers(HttpMethod.POST, "/create_data").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/get_users/**").hasRole("READER")
                .anyRequest().authenticated()
                .and()
                .logout()   // This is the line that enables the logout functionality
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))  // Specifies the logout URL
                .logoutSuccessHandler((request, response, authentication) -> {  // Logout handler
                    response.setStatus(HttpServletResponse.SC_OK);
                })
                .and()
                .csrf().disable()
                .formLogin().disable();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin").password("admin").roles("ADMIN").build();
        UserDetails reader = User.withDefaultPasswordEncoder()
                .username("reader").password("reader").roles("READER").build();

        return new InMemoryUserDetailsManager(admin, reader);
    }
}
