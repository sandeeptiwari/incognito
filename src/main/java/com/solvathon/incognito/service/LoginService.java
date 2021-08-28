package com.solvathon.incognito.service;

import com.solvathon.incognito.model.Login;
import com.solvathon.incognito.model.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginService {
    private Map<String, User> users = new HashMap<>();

    public String login(Login user) {
        User u = users.getOrDefault(user.getUsername(), null);
        return u == null ? "Fail" : "Success"; // Success if user available in map
    }

    public Map<String, User> getUsers() {
        return users;
    }

    public void init() {
        User user1 = new User(1001, "Jhon", "jhon123");
        users.put(user1.getUsername(), user1);

        User user2 = new User(1002, "Tom", "tom123");
        users.put(user2.getUsername(), user2);
    }
}
