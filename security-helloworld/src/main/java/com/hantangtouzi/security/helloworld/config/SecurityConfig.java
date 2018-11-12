package com.hantangtouzi.security.helloworld.config;

import com.hantangtouzi.security.helloworld.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author WilliamChang.
 * Created on 2018/11/6 0:47
 */

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private AccountService accountService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/css/**", "/index").permitAll().antMatchers("/user/**").hasRole("USER").and().formLogin().loginPage("/login").failureUrl("/login-error");
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        // 这是简单的示例.
        // auth.inMemoryAuthentication().withUser("user").password("password").roles("USER").and().withUser("admin").password("password").roles("USER","ADMIN");

        auth.userDetailsService(accountService).passwordEncoder(passwordEncoder());
    }

    public static PasswordEncoder passwordEncoder() {
        DelegatingPasswordEncoder delegatingPasswordEncoder = (DelegatingPasswordEncoder) PasswordEncoderFactories.createDelegatingPasswordEncoder();
        //设置defaultPasswordEncoderForMatches为NoOpPasswordEncoder
        delegatingPasswordEncoder.setDefaultPasswordEncoderForMatches(NoOpPasswordEncoder.getInstance());
        return delegatingPasswordEncoder;
    }
}
