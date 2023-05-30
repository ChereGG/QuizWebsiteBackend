package com.example.ubb.QuizWebsiteBackend.service;

import com.example.ubb.QuizWebsiteBackend.dto.QuestionDto;
import com.example.ubb.QuizWebsiteBackend.exception.NoSuchIdException;

import java.util.List;

public interface QuestionService {

    List<QuestionDto> getAllQuestionsForQuiz(Long quizId);

    void deleteQuestionById(Long questionId) throws NoSuchIdException;
}
