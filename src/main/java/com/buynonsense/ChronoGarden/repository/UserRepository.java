package com.buynonsense.ChronoGarden.repository;

import com.buynonsense.ChronoGarden.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
