package com.solvathon.incognito.service;

import com.solvathon.incognito.model.Policy;
import com.solvathon.incognito.model.User;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class QuoteService {
    private final PolicyService policyService;
    private final LoginService loginService;
    private Map<Integer, Policy> quoteMap = new HashMap<>();

    public QuoteService(PolicyService policyService, LoginService loginService) {
        this.policyService = policyService;
        this.loginService = loginService;
    }

    public Map<Integer, Policy> getQuoteMap() {
        return quoteMap;
    }

    public List<Map.Entry<Integer, Policy>> getQuotes(int userid) {

        List<Map.Entry<Integer, Policy>> quotes = new ArrayList<>();

        for (Map.Entry<Integer, Policy> map : quoteMap.entrySet()) {
            if (map.getValue().getUserId() == null) {
                quotes.add(map);
            }
        }
        return quotes;
    }

    public boolean isValidateUser(int userId) {
        Map<String, User> userMap = loginService.getUsers();
        for (Map.Entry<String, User> map : userMap.entrySet()) {
            if (map.getValue().getId() == userId)
                return true;
        }
        return false;
    }

    public void init() {
        LocalDate date = LocalDate.now();

        Policy quote1 = new Policy(180501, BigDecimal.valueOf(12000), BigDecimal.valueOf(700),
                date, date.plusDays(365), 2021, "car", "active", null, 5001);
        Policy quote2 = new Policy(180502, BigDecimal.valueOf(26000.50), BigDecimal.valueOf(1203.2),
                date, date.plusDays(375), 2021, "home", "active", null, 5002);
        Policy quote3 = new Policy(180503, BigDecimal.valueOf(12500), BigDecimal.valueOf(950),
                date, date.plusDays(300), 2022, "health", "active", null, 5003);

        Policy quote4 = new Policy(180504, BigDecimal.valueOf(35083), BigDecimal.valueOf(1306.4),
                date, date.plusDays(365), 2022, "car", "active", null, 5004);

        quoteMap.put(quote1.getPolicyId(), quote1);
        quoteMap.put(quote2.getPolicyId(), quote2);
        quoteMap.put(quote3.getPolicyId(), quote3);
        quoteMap.put(quote4.getPolicyId(), quote4);
    }
}
