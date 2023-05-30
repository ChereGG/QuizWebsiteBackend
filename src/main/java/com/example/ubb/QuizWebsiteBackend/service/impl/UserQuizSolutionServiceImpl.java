package com.example.ubb.QuizWebsiteBackend.service.impl;

import com.example.ubb.QuizWebsiteBackend.domain.UserQuizSolution;
import com.example.ubb.QuizWebsiteBackend.dto.UserQuizSolutionDto;
import com.example.ubb.QuizWebsiteBackend.repository.UserQuizSolutionRepository;
import com.example.ubb.QuizWebsiteBackend.service.UserQuizSolutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserQuizSolutionServiceImpl implements UserQuizSolutionService {

    private final UserQuizSolutionRepository userQuizSolutionRepository;

    @Autowired
    public UserQuizSolutionServiceImpl(UserQuizSolutionRepository userQuizSolutionRepository) {
        this.userQuizSolutionRepository = userQuizSolutionRepository;
    }

    @Override
    public void addUserQuizSolution(UserQuizSolutionDto userQuizSolutionDto) {
        UserQuizSolution userQuizSolution = new UserQuizSolution();

        userQuizSolution.setQuizId(userQuizSolutionDto.getQuizId());
        userQuizSolution.setUserId(userQuizSolutionDto.getUserId());
        userQuizSolution.setScore(userQuizSolutionDto.getScore());
        userQuizSolution.setTotal(userQuizSolutionDto.getTotal());

        userQuizSolutionRepository.save(userQuizSolution);
    }

    @Override
    public List<UserQuizSolutionDto> getAllUserSolutions(Long userId) {

        List<UserQuizSolution> userQuizSolutions = userQuizSolutionRepository.findUserQuizSolutionByUserId(userId);

        return userQuizSolutions.stream()
                .map(this::buildUserQuizSolutionDto)
                .toList();

    }

    private UserQuizSolutionDto buildUserQuizSolutionDto(UserQuizSolution userQuizSolution){
        UserQuizSolutionDto userQuizSolutionDto = new UserQuizSolutionDto();

        userQuizSolutionDto.setId(userQuizSolution.getId());
        userQuizSolutionDto.setScore(userQuizSolution.getScore());
        userQuizSolutionDto.setTotal(userQuizSolution.getTotal());
        userQuizSolutionDto.setQuizId(userQuizSolution.getQuizId());
        userQuizSolutionDto.setUserId(userQuizSolution.getUserId());

        return userQuizSolutionDto;
    }
}
