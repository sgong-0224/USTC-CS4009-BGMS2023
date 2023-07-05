package com.utbm.Boardmanager.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;


    //授权
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/toRegisterPage").permitAll()
                .antMatchers("/toRegisterException").permitAll()
                .antMatchers("/toRegisterPage2").permitAll()
                .antMatchers("/toRegisterPage2/**").permitAll()
                .antMatchers("/register").permitAll()
                .antMatchers("/register2").permitAll()
                .antMatchers("/register/**").permitAll()
                .antMatchers("/toLoginPage").permitAll()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/user/**").hasRole("USER")
                .antMatchers("/img/**", "/bootstrap/**").permitAll()
                .anyRequest().authenticated();
        http.formLogin().loginPage("/toLoginPage").loginProcessingUrl("/login");
        http.logout().logoutUrl("/logout").logoutSuccessUrl("/toLoginPage");
    }
    //加密
    @Bean
    public PasswordEncoder passwordEncoder() {
        //不使用密码加密
        //return NoOpPasswordEncoder.getInstance();
        //利用工厂类PasswordEncoderFactories实现,工厂类内部采用的是委派密码编码方案.
        //return PasswordEncoderFactories.createDelegatingPasswordEncoder();
        //使用默认的BCryptPasswordEncoder加密方案
        //return new BCryptPasswordEncoder();
        //strength=10，即密钥的迭代次数(strength取值在4~31之间，默认为10)
        return new BCryptPasswordEncoder(8);
    }
    //认证
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(PasswordEncoderFactories.createDelegatingPasswordEncoder());
    }
}
