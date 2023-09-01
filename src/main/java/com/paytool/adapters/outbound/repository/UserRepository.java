package com.paytool.adapters.outbound.repository;

import com.paytool.adapters.outbound.entity.UserEntity;
import com.paytool.adapters.outbound.mapper.UserMapper;
import com.paytool.application.core.domain.models.User;
import com.paytool.application.ports.inbound.UserPort;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.exception.PanacheQueryException;
import jakarta.enterprise.context.ApplicationScoped;
import net.bytebuddy.implementation.bytecode.Throw;

import java.util.UUID;

@ApplicationScoped
public class UserRepository implements PanacheRepository<UserEntity> {

    public UserEntity getUserByDocument(String document) {
        return find("document", document).firstResult();
    }

    public UserEntity getUserByEmail(String email) {
        return find("email", email).firstResult();
    }

    public UserEntity getUserById(UUID id) {
        return find("userId", id).firstResult();
    }

    public void deleteUser(UUID id) {
        delete(getUserById(id));
    }

    public void isDocumentEmailUnique(String document, String email) {
        if (!(find("document = ?1 or email = ?2", document, email).count() == 0)) {
            throw new RuntimeException("Document or email is in use");
        }
    }
}
