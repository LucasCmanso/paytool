package com.paytool.application.ports.inbound;

import com.paytool.adapters.outbound.entity.UserEntity;
import com.paytool.application.core.domain.models.User;

import java.util.List;
import java.util.UUID;

public interface UserPort {

    User saveUser(User user);

    List<User> getUsers();
    User getUserById(UUID id);
    User getUserByDocument(String document);
    User getUserByEmail(String email);
    void deleteUser(UUID id);
}
