package com.solvathon.incognito.service;

import com.solvathon.incognito.model.entity.Policy;
import com.solvathon.incognito.model.repository.PolicyRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Service
public class QuoteService {
    private final PolicyRepository policyRepository;

    public QuoteService(PolicyRepository policyRepository) {
        this.policyRepository = policyRepository;
    }


    public void init() {
        LocalDate date = LocalDate.now();

        Policy quote1 = new Policy(BigDecimal.valueOf(12000), BigDecimal.valueOf(700),
                date, date.plusDays(365), 2021, "VEHICLE", "active", true);
        Policy quote2 = new Policy(BigDecimal.valueOf(26000.50), BigDecimal.valueOf(1203.2),
                date, date.plusDays(375), 2021, "PROPERTY", "active", true);
        Policy quote3 = new Policy(BigDecimal.valueOf(12500), BigDecimal.valueOf(950),
                date, date.plusDays(300), 2022, "HEALTH", "active", true);
        Policy quote4 = new Policy(BigDecimal.valueOf(35083), BigDecimal.valueOf(1306.4),
                date, date.plusDays(365), 2022, "2 WHEELER", "active", true);
        Policy quote5 = new Policy(BigDecimal.valueOf(35083), BigDecimal.valueOf(1306.4),
                date, date.plusDays(365), 2022, "VEHICLE", "active", true);
        Policy quote6 = new Policy(BigDecimal.valueOf(35083), BigDecimal.valueOf(1306.4),
                date, date.plusDays(365), 2022, "TRAVEL", "active", true);
        Policy quote7 = new Policy(BigDecimal.valueOf(35083), BigDecimal.valueOf(1306.4),
                date, date.plusDays(365), 2022, "TRAVEL", "active", true);
        Policy quote8 = new Policy(BigDecimal.valueOf(35083), BigDecimal.valueOf(1306.4),
                date, date.plusDays(365), 2022, "PROPERTY", "active", true);
        Policy quote9 = new Policy(BigDecimal.valueOf(35083), BigDecimal.valueOf(1306.4),
                date, date.plusDays(365), 2022, "TRAVEL", "active", true);
        Policy quote10 = new Policy(BigDecimal.valueOf(35083), BigDecimal.valueOf(1306.4),
                date, date.plusDays(365), 2022, "HEALTH", "active", true);
        Policy quote11 = new Policy(BigDecimal.valueOf(35083), BigDecimal.valueOf(1306.4),
                date, date.plusDays(365), 2022, "2 WHEELER", "active", true);
        Policy quote12 = new Policy(BigDecimal.valueOf(35083), BigDecimal.valueOf(1306.4),
                date, date.plusDays(365), 2022, "WC", "active", true);
        Policy quote13 = new Policy(BigDecimal.valueOf(35083), BigDecimal.valueOf(1306.4),
                date, date.plusDays(365), 2022, "2 WHEELER", "active", true);
        Policy quote14 = new Policy(BigDecimal.valueOf(35083), BigDecimal.valueOf(1306.4),
                date, date.plusDays(365), 2022, "VEHICLE", "active", true);
        Policy quote15 = new Policy(BigDecimal.valueOf(35083), BigDecimal.valueOf(1306.4),
                date, date.plusDays(365), 2022, "PROPERTY", "active", true);

        List<Policy> policies = Arrays.asList(quote1, quote2, quote3, quote4, quote5, quote6, quote7, quote8, quote9, quote10, quote11,
                quote12, quote13, quote14, quote15);
        policyRepository.saveAll(policies);
    }

    public List<Policy> getQuotes() {
        return policyRepository.findAllQuotes();
    }
}
