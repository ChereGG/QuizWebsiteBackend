package com.example.ubb.QuizWebsiteBackend.service.impl;

import com.example.ubb.QuizWebsiteBackend.domain.Answer;
import com.example.ubb.QuizWebsiteBackend.dto.AnswerDto;
import com.example.ubb.QuizWebsiteBackend.repository.AnswerRepository;
import com.example.ubb.QuizWebsiteBackend.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AnswerServiceImpl implements AnswerService {

    private final AnswerRepository answerRepository;
    @Autowired
    public AnswerServiceImpl(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;

    }

    @Override
    public List<AnswerDto> getAllAnswersForQuestion(Long questionId) {
        List<Answer> answers = answerRepository.findAnswerByQuestionId(questionId);

        return answers.stream()
                .map(this::buildAnswerDto)
                .toList();
    }

    private AnswerDto buildAnswerDto(Answer answer){
        AnswerDto answerDto = new AnswerDto();

        answerDto.setIsCorrect(answer.getCorrect());
        answerDto.setDisplayOrder(answer.getDisplayOrder());
        answerDto.setStatement(answer.getStatement());
        answerDto.setQuestionId(answer.getQuestionId());
        answerDto.setId(answer.getId());

        return answerDto;
    }
}
