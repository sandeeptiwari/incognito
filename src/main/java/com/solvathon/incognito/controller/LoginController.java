package com.solvathon.incognito.controller;

import com.solvathon.incognito.model.Login;
import com.solvathon.incognito.model.Packet;
import com.solvathon.incognito.model.entity.User;
import com.solvathon.incognito.service.LoginService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/")
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping(value = "login",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> login(@RequestBody Login user) {
        User userRes = loginService.login(user);
        Packet<User> packet = new Packet<>(1, "User Found", userRes);
        return new ResponseEntity<>(packet, HttpStatus.OK);
    }

}
