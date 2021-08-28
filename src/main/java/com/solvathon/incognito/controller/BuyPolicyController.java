package com.solvathon.incognito.controller;

import com.solvathon.incognito.service.BuyPolicyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class BuyPolicyController {

    private final BuyPolicyService buyPolicyService;

    public BuyPolicyController(BuyPolicyService buyPolicyService) {
        this.buyPolicyService = buyPolicyService;
    }

    @GetMapping("buypolicy/{policyId}")
    public ResponseEntity<?> buyPolicy(@RequestHeader("userId") int userId, @PathVariable("policyId") int policyId) {
        return new ResponseEntity<>(buyPolicyService.buyPolicy(userId, policyId), HttpStatus.OK);
    }

}
