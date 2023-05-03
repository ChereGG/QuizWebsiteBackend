package com.example.ubb.QuizWebsiteBackend.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.example.ubb.QuizWebsiteBackend.web.mapping.ControllerMappings.TEST;

@RequestMapping(TEST)
@RestController
@CrossOrigin(origins = "*")
public class TestController {

    @GetMapping
    public ResponseEntity<?> helloWorld(){
        return new ResponseEntity<>("Hello world!", HttpStatus.OK);
    }
}
