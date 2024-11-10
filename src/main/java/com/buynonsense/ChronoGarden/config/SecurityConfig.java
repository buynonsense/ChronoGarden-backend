package com.buynonsense.ChronoGarden.config;

import com.buynonsense.ChronoGarden.JwtUtil;
import com.buynonsense.ChronoGarden.filter.JwtAuthenticationFilter;
import com.buynonsense.ChronoGarden.service.MyUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    // 使用 SecurityFilterChain 替代 configure(HttpSecurity) 方法

    private final JwtUtil jwtUtil;
    private final UserDetailsService userDetailsService;

    // 构造注入 JwtUtil 和 UserDetailsService
    public SecurityConfig(JwtUtil jwtUtil, UserDetailsService userDetailsService) {
        this.jwtUtil = jwtUtil;
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // 禁用 CSRF
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/users/register", "/api/users/login").permitAll() // 允许注册和登录接口
                        .requestMatchers("/api/users/protected").authenticated()  // 保护测试端点
                        .anyRequest().authenticated() // 其他请求需要认证
                )
                //将 JwtAuthenticationFilter 添加到过滤链中,确保在 UsernamePasswordAuthenticationFilter 之前运行
                .addFilterBefore(new JwtAuthenticationFilter(jwtUtil, userDetailsService), UsernamePasswordAuthenticationFilter.class);  // 添加 JWT 过滤器

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        // 返回定义的 UserDetailsService 实例
        return new MyUserDetailsService(); // 自定义的 UserDetailsService
    }
}
