package com.solvathon.incognito.bootstrap;

import com.solvathon.incognito.service.LoginService;
import com.solvathon.incognito.service.QuoteService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitializeApp implements CommandLineRunner {

    private final LoginService loginService;
    private final QuoteService quoteService;

    public InitializeApp(LoginService loginService,
                         QuoteService quoteService) {
        this.loginService = loginService;
        this.quoteService = quoteService;
    }

    @Override
    public void run(String... args) throws Exception {
        loginService.init();
        quoteService.init();
    }
}
