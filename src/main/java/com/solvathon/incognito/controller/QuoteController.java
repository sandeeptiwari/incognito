package com.solvathon.incognito.controller;


import com.solvathon.incognito.service.LoginService;
import com.solvathon.incognito.service.QuoteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class QuoteController {

    private final QuoteService quoteService;
    private final LoginService loginService;


    public QuoteController(QuoteService quoteService, LoginService loginService) {
        this.quoteService = quoteService;
        this.loginService = loginService;
    }

    @GetMapping("/quote")
    public ResponseEntity<?> getUserPolicy(@RequestHeader("userId") Integer userId) {

        if (quoteService.isValidateUser(userId)) {
            return new ResponseEntity<>(quoteService.getQuotes(userId), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Not a valid user", HttpStatus.OK);
        }
    }

}
