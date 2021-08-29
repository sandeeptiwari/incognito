package com.solvathon.incognito.service;

import com.solvathon.incognito.model.entity.Policy;
import com.solvathon.incognito.model.repository.PolicyRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

@Service
public class PolicyService {

    private final PolicyRepository policyRepository;

    public PolicyService(PolicyRepository policyRepository) {
        this.policyRepository = policyRepository;
    }

    public List<Policy> getUserPolicies(int userId) {
        return policyRepository.findAll();
    }
}

