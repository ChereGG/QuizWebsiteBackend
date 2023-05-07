package com.example.ubb.QuizWebsiteBackend.web.controller;

import com.example.ubb.QuizWebsiteBackend.dto.UserDto;
import com.example.ubb.QuizWebsiteBackend.exception.DuplicateUsernameException;
import com.example.ubb.QuizWebsiteBackend.exception.NoSuchIdException;
import com.example.ubb.QuizWebsiteBackend.exception.NoSuchUsernameException;
import com.example.ubb.QuizWebsiteBackend.exception.WrongCredentialsException;
import com.example.ubb.QuizWebsiteBackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.example.ubb.QuizWebsiteBackend.web.mapping.ControllerMappings.USER;

@RequestMapping(USER)
@RestController
@CrossOrigin(origins = "*")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public void signUpUser(@RequestBody UserDto userDto) throws DuplicateUsernameException {

        userService.signUp(userDto);
    }

    @GetMapping(value = "/login")
    public ResponseEntity<UserDto> logIn(@RequestBody UserDto userDto) throws NoSuchUsernameException, WrongCredentialsException {

        return new ResponseEntity<>(userService.logIn(userDto), HttpStatus.OK);
    }

    @PutMapping(value = "grant-admin/{id}")
    public void grantAdmin(@PathVariable Long id) throws NoSuchIdException {

        userService.grantAdmin(id);
    }
}
