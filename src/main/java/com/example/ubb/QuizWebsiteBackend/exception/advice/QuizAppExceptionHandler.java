package com.example.ubb.QuizWebsiteBackend.exception.advice;

import com.example.ubb.QuizWebsiteBackend.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class QuizAppExceptionHandler {

    @ExceptionHandler(DuplicateUsernameException.class)
    public ResponseEntity<?> handleException(DuplicateUsernameException exception) {

        return new ResponseEntity<>(exception.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(NoSuchUsernameException.class)
    public ResponseEntity<?> handleException(NoSuchUsernameException exception) {

        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(WrongCredentialsException.class)
    public ResponseEntity<?> handleException(WrongCredentialsException exception) {

        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoSuchIdException.class)
    public ResponseEntity<?> handleException(NoSuchIdException exception) {

        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoSuchQuizException.class)
    public ResponseEntity<?> handleException(NoSuchQuizException exception) {

        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }
}
