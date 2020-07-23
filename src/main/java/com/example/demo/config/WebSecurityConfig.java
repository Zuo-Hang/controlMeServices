//package com.example.demo.config;
//
//import com.example.demo.security.AuthFilter;
//import com.example.demo.security.LoginAuthFailHandler;
//import com.example.demo.security.LoginUrlEntryPoint;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
///**
// * 安全配置
// * @Author:zuohang
// * @date:2020/5/13 0013 19:18
// */
//
//@EnableWebSecurity
//@EnableGlobalMethodSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
//        http.addFilterBefore(authFilter(), UsernamePasswordAuthenticationFilter.class);
//        // 资源访问权限
//        http.authorizeRequests()
//                .antMatchers("/admin/login").permitAll() // 管理员登录入口
//                .antMatchers("/static/**").permitAll() // 静态资源
//                .antMatchers("/user/login").permitAll() // 用户登录入口
//                .antMatchers("/admin/**").hasRole("ADMIN")
//                .antMatchers("/user/**").hasAnyRole("ADMIN", "USER")
//                .antMatchers("/api/user/**").hasAnyRole("ADMIN",
//                "USER")
//                .and()
//                .formLogin()
//                .loginProcessingUrl("/login") // 配置角色登录处理入口
//                .failureHandler(authFailHandler())
//                .and()
//                .logout()
//                .logoutUrl("/logout")
//                .logoutSuccessUrl("/logout/page")
//                .deleteCookies("JSESSIONID")
//                .invalidateHttpSession(true)
//                .and()
//                .exceptionHandling()
//                .authenticationEntryPoint(urlEntryPoint())
//                .accessDeniedPage("/403");
//
//        http.csrf().disable();
//        http.headers().frameOptions().sameOrigin();
//    }
//
//    @Bean
//    public AuthFilter authFilter() {
//        AuthFilter authFilter = new AuthFilter();
//        authFilter.setAuthenticationManager(authenticationManager());
//        authFilter.setAuthenticationFailureHandler(authFailHandler());
//        return authFilter;
//    }
//    @Bean
//    public AuthenticationManager authenticationManager() {
//        AuthenticationManager authenticationManager = null;
//        try {
//            authenticationManager =  super.authenticationManager();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return authenticationManager;
//    }
//
//    @Bean
//    public LoginAuthFailHandler authFailHandler() {
//        return new LoginAuthFailHandler(urlEntryPoint());
//    }
//
//    @Bean
//    public LoginUrlEntryPoint urlEntryPoint() {
//        return new LoginUrlEntryPoint("/user/login");
//    }
//}
