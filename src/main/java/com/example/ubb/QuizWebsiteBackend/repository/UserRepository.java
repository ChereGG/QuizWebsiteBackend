package com.example.ubb.QuizWebsiteBackend.repository;

import com.example.ubb.QuizWebsiteBackend.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Boolean existsByUsername(String username);

    Optional<User> findByUsername(String username);

    List<User> findAllByIsAdminFalse();
}
