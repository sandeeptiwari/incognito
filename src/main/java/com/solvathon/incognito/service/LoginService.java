package com.solvathon.incognito.service;

import com.solvathon.incognito.exception.UserNotFoundException;
import com.solvathon.incognito.model.Login;
import com.solvathon.incognito.model.entity.User;
import com.solvathon.incognito.model.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class LoginService {
    private final UserRepository userRepository;

    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User login(Login user) {
        return userRepository.findByUsername(user.getUsername())
                .orElseThrow(() -> new UserNotFoundException("User Not Found"));
    }

    public void init() {
        User doeJhon = userRepository.findByUsername("doeJhon").orElse(null);
        if (doeJhon == null) {
            User user1 = new User("Jhon", "doe", "doeJhon", "jhon@123");
            userRepository.save(user1);

            User user2 = new User("Jhon", "Milton", "jhonmilton", "jhonmilton@123");
            userRepository.save(user2);
        }
    }
}
