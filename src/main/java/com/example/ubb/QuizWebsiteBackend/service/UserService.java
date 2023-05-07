package com.example.ubb.QuizWebsiteBackend.service;

import com.example.ubb.QuizWebsiteBackend.dto.UserDto;
import com.example.ubb.QuizWebsiteBackend.exception.DuplicateUsernameException;
import com.example.ubb.QuizWebsiteBackend.exception.NoSuchIdException;
import com.example.ubb.QuizWebsiteBackend.exception.NoSuchUsernameException;
import com.example.ubb.QuizWebsiteBackend.exception.WrongCredentialsException;


public interface UserService {

     void signUp(UserDto userDto) throws DuplicateUsernameException;

     UserDto logIn(UserDto userDto) throws NoSuchUsernameException, WrongCredentialsException;

     void grantAdmin(Long userId) throws NoSuchIdException;

}
