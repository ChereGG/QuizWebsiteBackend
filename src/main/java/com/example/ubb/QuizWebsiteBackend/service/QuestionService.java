package com.example.ubb.QuizWebsiteBackend.service;

import com.example.ubb.QuizWebsiteBackend.dto.QuestionDto;

import java.util.List;

public interface QuestionService {

    List<QuestionDto> getAllQuestionsForQuiz(Long quizId);
}
