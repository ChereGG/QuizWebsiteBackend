package com.example.ubb.QuizWebsiteBackend.service.impl;

import com.example.ubb.QuizWebsiteBackend.domain.User;
import com.example.ubb.QuizWebsiteBackend.dto.UserDto;
import com.example.ubb.QuizWebsiteBackend.exception.DuplicateUsernameException;
import com.example.ubb.QuizWebsiteBackend.exception.NoSuchIdException;
import com.example.ubb.QuizWebsiteBackend.exception.NoSuchUsernameException;
import com.example.ubb.QuizWebsiteBackend.exception.WrongCredentialsException;
import com.example.ubb.QuizWebsiteBackend.repository.UserRepository;
import com.example.ubb.QuizWebsiteBackend.service.QuizService;
import com.example.ubb.QuizWebsiteBackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final QuizService quizService;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, QuizService quizService) {
        this.userRepository = userRepository;
        this.quizService = quizService;
    }

    @Override
    public void signUp(UserDto userDto) throws DuplicateUsernameException {
        if(userRepository.existsByUsername(userDto.getUsername())){
            throw new DuplicateUsernameException("The username already exists.");
        }
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPasswordHash(bCryptPasswordEncoder.encode(userDto.getPassword()));
        user.setAdmin(false);

        userRepository.save(user);
    }

    @Override
    public UserDto logIn(UserDto userDto) throws NoSuchUsernameException, WrongCredentialsException {
        User dbUser = userRepository.findByUsername(userDto.getUsername())
                .orElseThrow(() -> new NoSuchUsernameException("There is no such username."));

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        if(!bCryptPasswordEncoder.matches(userDto.getPassword(), dbUser.getPasswordHash())){
            throw new WrongCredentialsException("Wrong credentials!");
        }

        if(userDto.getMaxNumberOfChapters() != null) {
            quizService.populateByNumber(userDto.getMaxNumberOfChapters());
        }

        UserDto result = new UserDto();
        result.setId(dbUser.getId());
        result.setIsAdmin(dbUser.getAdmin());
        return result;

    }

    @Override
    public void grantAdmin(Long userId) throws NoSuchIdException {

        User dbUser = userRepository.findById(userId)
                .orElseThrow(() -> new NoSuchIdException("There is no such id."));

        dbUser.setAdmin(true);
        userRepository.save(dbUser);
    }
}
