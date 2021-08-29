package com.solvathon.incognito.controller;

import com.solvathon.incognito.service.PolicyService;
import com.solvathon.incognito.service.QuoteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PolicyController {

    private final PolicyService policyService;
    private final QuoteService quoteService;


    public PolicyController(PolicyService policyService, QuoteService quoteService) {
        this.policyService = policyService;
        this.quoteService = quoteService;
    }

    @GetMapping("/policy/{id}")
    public ResponseEntity<?> getPolicyById(@PathVariable("id") int policyId) {
        //return new ResponseEntity<>(policyService.getPolicyById(policyId), HttpStatus.OK);
        return null;
    }

    @GetMapping("/policy")
    public ResponseEntity<?> getUserPolicy(@RequestHeader("userId") int userId) {
        return new ResponseEntity<>(policyService.getUserPolicies(userId), HttpStatus.OK);
    }

}
