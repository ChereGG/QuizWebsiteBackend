package com.example.ubb.QuizWebsiteBackend.service.impl;

import com.example.ubb.QuizWebsiteBackend.domain.Quiz;
import com.example.ubb.QuizWebsiteBackend.repository.QuizRepository;
import com.example.ubb.QuizWebsiteBackend.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class QuizServiceImpl implements QuizService {

    private final QuizRepository quizRepository;

    @Autowired
    public QuizServiceImpl(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
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
}
