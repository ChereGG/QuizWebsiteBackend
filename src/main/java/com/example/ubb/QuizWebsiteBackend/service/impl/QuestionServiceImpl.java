package com.example.ubb.QuizWebsiteBackend.service.impl;

import com.example.ubb.QuizWebsiteBackend.domain.Question;
import com.example.ubb.QuizWebsiteBackend.dto.AnswerDto;
import com.example.ubb.QuizWebsiteBackend.dto.QuestionDto;
import com.example.ubb.QuizWebsiteBackend.exception.NoSuchIdException;
import com.example.ubb.QuizWebsiteBackend.repository.QuestionRepository;
import com.example.ubb.QuizWebsiteBackend.service.AnswerService;
import com.example.ubb.QuizWebsiteBackend.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;
    private final AnswerService answerService;

    @Autowired
    public QuestionServiceImpl(QuestionRepository questionRepository, AnswerService answerService) {
        this.questionRepository = questionRepository;
        this.answerService = answerService;
    }

    @Override
    public List<QuestionDto> getAllQuestionsForQuiz(Long quizId) {
        List<Question> questions = questionRepository.findQuestionByQuizId(quizId);

        return questions.stream()
                .map(this::buildQuestionDto)
                .toList();
    }

    @Override
    public void deleteQuestionById(Long questionId) throws NoSuchIdException {
        if(!questionRepository.existsQuestionById(questionId)){
            throw new NoSuchIdException("There is no question with the given id!");
        }

        questionRepository.deleteById(questionId);
    }

    private QuestionDto buildQuestionDto(Question question)
    {
        QuestionDto questionDto = new QuestionDto();

        questionDto.setStatement(question.getStatement());
        questionDto.setId(question.getId());
        questionDto.setQuizId(question.getQuizId());

        List<AnswerDto> answers = answerService.getAllAnswersForQuestion(question.getId());

        questionDto.setAnswers(answers);

        return questionDto;

    }
}
