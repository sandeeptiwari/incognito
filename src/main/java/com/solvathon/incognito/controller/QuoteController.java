package com.solvathon.incognito.controller;


import com.solvathon.incognito.exception.UserNotFoundException;
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

    public QuoteController(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    @GetMapping("/quote")
    public ResponseEntity<?> getUserPolicy(@RequestHeader("userId") Integer userId) {

        if (userId != null) {
            return new ResponseEntity<>(quoteService.getQuotes(), HttpStatus.OK);
        }

        throw new UserNotFoundException("User Id not found in header");
    }

}
