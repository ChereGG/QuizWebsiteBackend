package com.example.ubb.QuizWebsiteBackend.web.controller;

import com.example.ubb.QuizWebsiteBackend.dto.QuestionDto;
import com.example.ubb.QuizWebsiteBackend.exception.NoSuchIdException;
import com.example.ubb.QuizWebsiteBackend.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.example.ubb.QuizWebsiteBackend.web.mapping.ControllerMappings.QUESTION;

@RequestMapping(QUESTION)
@RestController
@CrossOrigin(origins = "*")
public class QuestionController {

    private final QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @DeleteMapping(value = "/{questionId}")
    void deleteQuestion(@PathVariable Long questionId) throws NoSuchIdException {

        questionService.deleteQuestionById(questionId);
    }

    @PostMapping
    public ResponseEntity<QuestionDto> addQuestion(@RequestBody QuestionDto questionDto){

        return new ResponseEntity<>(questionService.addQuestion(questionDto), HttpStatus.OK);
    }
}
