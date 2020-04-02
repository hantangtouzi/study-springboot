package com.hantangtouzi.security.demo.config;

import com.hantangtouzi.security.demo.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author WilliamChang.
 * Created on 2019-07-01 20:05:50
 */

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true)
                .and()
                .authorizeRequests()
                .antMatchers("/css/**", "/index", "/").permitAll()
                .antMatchers("/user/**").hasRole("USER")
                .antMatchers("/admin").hasRole("ADMIN")
                .anyRequest().permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        // auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
        //         .withUser("user").password(new BCryptPasswordEncoder().encode("user")).roles("USER")
        //         .and()
        //         .withUser("admin").password(new BCryptPasswordEncoder().encode("admin")).roles("USER", "ADMIN");

        auth.userDetailsService(myUserDetailsService);
    }

    // @Bean
    // public PasswordEncoder encoder() {
    //     return new BCryptPasswordEncoder(11);
    // }

    @Bean
    public PasswordEncoder encoder() {
        return NoOpPasswordEncoder.getInstance();
    }

}
