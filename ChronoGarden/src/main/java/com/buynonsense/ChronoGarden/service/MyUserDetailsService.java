package com.buynonsense.ChronoGarden.service;

import com.buynonsense.ChronoGarden.model.User;
import com.buynonsense.ChronoGarden.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("找不到用户");
        }
        return org.springframework.security.core.userdetails.User.builder()             // 创建一个 UserDetails 实例
                .username(user.getUsername())               //设置用户名
                .password(user.getPassword())               //设置密码（加密的）
                .roles("USER") // 根据需要设置角色，应该从数据库中动态加载
                .build();
    }
}
