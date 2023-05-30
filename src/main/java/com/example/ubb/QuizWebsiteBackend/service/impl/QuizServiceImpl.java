package com.example.ubb.QuizWebsiteBackend.service.impl;

import com.example.ubb.QuizWebsiteBackend.domain.Quiz;
import com.example.ubb.QuizWebsiteBackend.dto.QuestionDto;
import com.example.ubb.QuizWebsiteBackend.dto.QuizDto;
import com.example.ubb.QuizWebsiteBackend.dto.QuizWithQuestionsAndAnswersDto;
import com.example.ubb.QuizWebsiteBackend.exception.NoSuchQuizException;
import com.example.ubb.QuizWebsiteBackend.repository.QuizRepository;
import com.example.ubb.QuizWebsiteBackend.service.QuestionService;
import com.example.ubb.QuizWebsiteBackend.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class QuizServiceImpl implements QuizService {

    private final QuizRepository quizRepository;
    private final QuestionService questionService;

    @Autowired
    public QuizServiceImpl(QuizRepository quizRepository, QuestionService questionService) {
        this.quizRepository = quizRepository;
        this.questionService = questionService;
    }

    @Override
    public void populateByNumber(Integer howMany) {
      Integer noOfExtentQuizzes = quizRepository.countAll();

      if(noOfExtentQuizzes >= howMany){
          return;
      }

        for (int i = noOfExtentQuizzes; i < howMany; i++) {
            Quiz quiz = new Quiz();
            quiz.setTheory("PlaceHolder");
            quiz.setTitle("Placeholder");

            quizRepository.save(quiz);
        }
    }

    @Override
    public List<QuizWithQuestionsAndAnswersDto> getAllQuizzes() {
        return quizRepository.findAll()
                .stream()
                .map(this::buildQuizWithQuestionAndAnswersDto)
                .toList();
    }

    @Override
    public void modifyExistentQuiz(QuizDto quizDto) throws NoSuchQuizException {

        Quiz dbQuiz = quizRepository.findById(quizDto.getId())
                .orElseThrow(() -> new NoSuchQuizException("There is no quiz with the given id"));

        dbQuiz.setTitle(quizDto.getTitle());
        dbQuiz.setTheory(quizDto.getTheory());

        quizRepository.save(dbQuiz);

    }

    private QuizWithQuestionsAndAnswersDto buildQuizWithQuestionAndAnswersDto(Quiz quiz){

        QuizWithQuestionsAndAnswersDto quizDto = new QuizWithQuestionsAndAnswersDto();

        quizDto.setId(quiz.getId());
        quizDto.setTitle(quiz.getTitle());
        quizDto.setTheory(quiz.getTheory());

        List<QuestionDto> questions = questionService.getAllQuestionsForQuiz(quiz.getId());

        quizDto.setQuestions(questions);

        return quizDto;
    }
}
