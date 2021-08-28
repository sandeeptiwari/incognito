package com.solvathon.incognito.service;

import com.solvathon.incognito.model.Policy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PolicyService {

    private final LoginService loginService;


    private Map<Integer, Policy> policyMap = new HashMap<>();

    public PolicyService(LoginService loginService) {
        this.loginService = loginService;
    }

    public Map<Integer, Policy> getPolicyMap() {
        return policyMap;
    }

    public ResponseEntity<?> getPolicyById(int id) {
//        Policy p = policyMap.getOrDefault(id, null);
        return "" == null ? new ResponseEntity<>("couldn't find any policy", HttpStatus.OK) : new ResponseEntity<>("p", HttpStatus.OK);
    }

    public List<Policy> getUserPolicy(int userId) {

        List<Policy> listOfPolicies = new ArrayList<>();

        for (Map.Entry<Integer, Policy> map : policyMap.entrySet()) {
            if (map.getValue().getUserId() == userId)
                listOfPolicies.add(map.getValue());
        }

        return listOfPolicies;
    }
}

