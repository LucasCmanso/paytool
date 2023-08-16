package com.paytool.domain.service;

import com.paytool.domain.models.User;
import com.paytool.domain.ports.inbound.UserPort;

public class UserService {

    private final UserPort userPort;

    public UserService(UserPort userPort) {
        this.userPort = userPort;
    }

    public User saveUser(User user) {
        return userPort.saveUser(user);
    }

    public User getUserById(Long id) {
        return userPort.getUserById(id);
    }

    public User getUserByDocument(String document) {
        return userPort.getUserByDocument(document);
    }

    public User getUserByEmail(String email) {
        return userPort.getUserByEmail(email);
    }

    public String deleteUser(Long id) {
        userPort.deleteUser(id);
        return "Successfully deleted user";
    }

    public User updateUser(User user) {
        return userPort.updateUser(user);
    }
}
