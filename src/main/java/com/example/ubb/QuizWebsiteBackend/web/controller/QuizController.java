package com.example.ubb.QuizWebsiteBackend.web.controller;

import com.example.ubb.QuizWebsiteBackend.dto.QuizDto;
import com.example.ubb.QuizWebsiteBackend.dto.QuizWithQuestionsAndAnswersDto;
import com.example.ubb.QuizWebsiteBackend.exception.NoSuchQuizException;
import com.example.ubb.QuizWebsiteBackend.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.ubb.QuizWebsiteBackend.web.mapping.ControllerMappings.QUIZ;

@RequestMapping(QUIZ)
@RestController
@CrossOrigin(origins = "*")
public class QuizController {

    private final QuizService quizService;

    @Autowired
    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping
    public ResponseEntity<List<QuizWithQuestionsAndAnswersDto>> getAllQuizzes(){

        return new ResponseEntity<>(quizService.getAllQuizzes(), HttpStatus.OK);
    }

    @PutMapping
    public void updateQuiz(@RequestBody QuizDto quizDto) throws NoSuchQuizException {

        quizService.modifyExistentQuiz(quizDto);
    }
}
