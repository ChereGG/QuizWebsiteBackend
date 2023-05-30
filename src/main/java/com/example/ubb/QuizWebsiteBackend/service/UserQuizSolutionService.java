package com.example.ubb.QuizWebsiteBackend.service;

import com.example.ubb.QuizWebsiteBackend.dto.UserQuizSolutionDto;

import java.util.List;

public interface UserQuizSolutionService {

    void addUserQuizSolution(UserQuizSolutionDto userQuizSolutionDto);

    List<UserQuizSolutionDto> getAllUserSolutions(Long userId);
}
