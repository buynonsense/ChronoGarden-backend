<<<<<<< HEAD
package com.buynonsense.ChronoGarden.controller;

import com.buynonsense.ChronoGarden.JwtUtil;
import com.buynonsense.ChronoGarden.model.User;
import com.buynonsense.ChronoGarden.repository.UserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        // 密码加密
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return ResponseEntity.ok(userRepository.save(user));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        // 验证用户是否存在
        User existingUser = userRepository.findByUsername(user.getUsername());

        // 验证用户存在和密码匹配
        if (existingUser != null && passwordMatches(user.getPassword(), existingUser.getPassword())) {
            // 用户验证通过，生成 JWT Token
            String token = jwtUtil.generateToken(user.getUsername());
            return ResponseEntity.ok(token);
        }
        //用户名或密码错误
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("凭证无效");
    }

    // 用于测试利用JWT访问受保护资源
    @GetMapping("/protected")
    public ResponseEntity<String> getProtectedResource() {
        return ResponseEntity.ok("您已访问受保护的资源!");
    }



//已经在JwtUtil.java中实现
    /*private String generateJwtToken(User user) {
        return Jwts.builder()
                .setSubject(user.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + 86400000)) // 1天后过期
                .signWith(SignatureAlgorithm.HS512, "buynonsense's_secret") // 密钥
                .compact();
    }*/

    // 密码验证方法
    public boolean passwordMatches(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }
=======
package com.buynonsense.ChronoGarden.controller;

import com.buynonsense.ChronoGarden.JwtUtil;
import com.buynonsense.ChronoGarden.model.User;
import com.buynonsense.ChronoGarden.repository.UserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        // 密码加密
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return ResponseEntity.ok(userRepository.save(user));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        // 验证用户是否存在
        User existingUser = userRepository.findByUsername(user.getUsername());

        // 验证用户存在和密码匹配
        if (existingUser != null && passwordMatches(user.getPassword(), existingUser.getPassword())) {
            // 用户验证通过，生成 JWT Token
            String token = jwtUtil.generateToken(user.getUsername());
            return ResponseEntity.ok(token);
        }
        //用户名或密码错误
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("凭证无效");
    }

    // 用于测试利用JWT访问受保护资源
    @GetMapping("/protected")
    public ResponseEntity<String> getProtectedResource() {
        return ResponseEntity.ok("您已访问受保护的资源!");
    }



//已经在JwtUtil.java中实现
    /*private String generateJwtToken(User user) {
        return Jwts.builder()
                .setSubject(user.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + 86400000)) // 1天后过期
                .signWith(SignatureAlgorithm.HS512, "buynonsense's_secret") // 密钥
                .compact();
    }*/

    // 密码验证方法
    public boolean passwordMatches(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }
>>>>>>> d6310dba1852a4c6218eb5bb8b4334ffdb244361
}