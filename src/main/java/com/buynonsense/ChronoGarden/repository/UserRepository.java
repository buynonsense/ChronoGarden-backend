<<<<<<< HEAD
package com.buynonsense.ChronoGarden.repository;

import com.buynonsense.ChronoGarden.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
=======
package com.buynonsense.ChronoGarden.repository;

import com.buynonsense.ChronoGarden.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
>>>>>>> d6310dba1852a4c6218eb5bb8b4334ffdb244361
