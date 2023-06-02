package com.example.ubb.QuizWebsiteBackend.service;

import com.example.ubb.QuizWebsiteBackend.domain.Answer;
import com.example.ubb.QuizWebsiteBackend.dto.AnswerDto;

import java.util.List;

public interface AnswerService {

    List<AnswerDto> getAllAnswersForQuestion(Long questionId);

    void saveAnswer(Answer answer);
}
