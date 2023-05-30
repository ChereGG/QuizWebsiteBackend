package com.example.ubb.QuizWebsiteBackend.web.controller;

import com.example.ubb.QuizWebsiteBackend.dto.UserQuizSolutionDto;
import com.example.ubb.QuizWebsiteBackend.service.UserQuizSolutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.example.ubb.QuizWebsiteBackend.web.mapping.ControllerMappings.SOLUTION;

@RequestMapping(SOLUTION)
@RestController
@CrossOrigin(origins = "*")
public class UserQuizSolutionController {

    private final UserQuizSolutionService userQuizSolutionService;

    @Autowired
    public UserQuizSolutionController(UserQuizSolutionService userQuizSolutionService) {
        this.userQuizSolutionService = userQuizSolutionService;
    }

    @PostMapping
    void addSolution(@RequestBody UserQuizSolutionDto userQuizSolutionDto){

        userQuizSolutionService.addUserQuizSolution(userQuizSolutionDto);
    }

    @GetMapping(value = "/{userId}")
    ResponseEntity<?> getAllUserSolutions(@PathVariable Long userId){
        return new ResponseEntity<>(userQuizSolutionService.getAllUserSolutions(userId), HttpStatus.OK);
    }
}
