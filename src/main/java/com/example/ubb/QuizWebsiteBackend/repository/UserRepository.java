package com.example.ubb.QuizWebsiteBackend.repository;

import com.example.ubb.QuizWebsiteBackend.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
