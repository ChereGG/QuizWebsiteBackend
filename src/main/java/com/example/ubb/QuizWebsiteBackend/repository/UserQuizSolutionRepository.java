package com.example.ubb.QuizWebsiteBackend.repository;

import com.example.ubb.QuizWebsiteBackend.domain.UserQuizSolution;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserQuizSolutionRepository extends JpaRepository<UserQuizSolution, Long> {

    List<UserQuizSolution> findAllByUserIdAndQuizId(Long userId, Long quizId);
}
