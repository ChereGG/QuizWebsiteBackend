package com.example.ubb.QuizWebsiteBackend.repository;

import com.example.ubb.QuizWebsiteBackend.domain.UserQuizSolution;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserQuizSolutionRepository extends JpaRepository<UserQuizSolution, Long> {
}
