package com.paytool.application.core.service;

import com.paytool.application.core.domain.models.User;
import com.paytool.application.ports.inbound.UserPort;

import java.util.UUID;

public class UserService {

    private final UserPort userPort;

    public UserService(UserPort userPort) {
        this.userPort = userPort;
    }

    public User saveUser(User user) {
        return userPort.saveUser(user);
    }

    public User getUserById(UUID id) {
        return userPort.getUserById(id);
    }

    public User getUserByDocument(String document) {
        return userPort.getUserByDocument(document);
    }

    public User getUserByEmail(String email) {
        return userPort.getUserByEmail(email);
    }

    public String deleteUser(UUID id) {
        userPort.deleteUser(id);
        return "Successfully deleted user";
    }
}
