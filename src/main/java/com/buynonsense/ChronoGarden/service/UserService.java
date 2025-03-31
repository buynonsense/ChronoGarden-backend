package com.buynonsense.ChronoGarden.service;

import com.buynonsense.ChronoGarden.model.User;
import com.buynonsense.ChronoGarden.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}