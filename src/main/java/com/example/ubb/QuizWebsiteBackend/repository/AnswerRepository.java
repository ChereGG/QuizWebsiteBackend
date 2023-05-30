package com.example.ubb.QuizWebsiteBackend.repository;

import com.example.ubb.QuizWebsiteBackend.domain.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer, Long> {

    List<Answer> findAnswerByQuestionId(Long questionId);
}
