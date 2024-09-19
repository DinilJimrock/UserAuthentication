package com.UserAuth.SignupLoginApp.repository;

import com.UserAuth.SignupLoginApp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
