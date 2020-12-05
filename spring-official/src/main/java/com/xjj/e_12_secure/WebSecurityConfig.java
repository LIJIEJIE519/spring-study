package com.xjj.e_12_secure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * @Author LJ
 * @Date 2020/11/27
 * msg Spring secure 安全配置类
 */

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/*", "/index", "/validate", "/greeting", "/public/*").permitAll()     // 设置不用登录页
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login").permitAll()    // 其余页需要登录访问
                .and()
                .logout().permitAll();
    }

    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        // 设置权限允许信息
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("111111")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user);
    }
}
