package com.example.ubb.QuizWebsiteBackend.service;

import com.example.ubb.QuizWebsiteBackend.dto.QuizDto;
import com.example.ubb.QuizWebsiteBackend.dto.QuizWithQuestionsAndAnswersDto;
import com.example.ubb.QuizWebsiteBackend.exception.NoSuchQuizException;

import java.util.List;

public interface QuizService {

    void populateByNumber(Integer howMany);

    List<QuizWithQuestionsAndAnswersDto> getAllQuizzes();

    void modifyExistentQuiz(QuizDto quizDto) throws NoSuchQuizException;
}
