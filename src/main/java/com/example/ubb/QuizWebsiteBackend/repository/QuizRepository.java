package com.example.ubb.QuizWebsiteBackend.repository;

import com.example.ubb.QuizWebsiteBackend.domain.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
}
