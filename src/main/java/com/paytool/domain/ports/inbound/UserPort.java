package com.paytool.domain.ports.inbound;

import com.paytool.domain.models.User;

public interface UserPort {

    User saveUser(User user);
    User getUserById(Long id);
    User getUserByDocument(String document);
    User getUserByEmail(String email);
    String deleteUser(Long id);
    User updateUser(User user);
}
