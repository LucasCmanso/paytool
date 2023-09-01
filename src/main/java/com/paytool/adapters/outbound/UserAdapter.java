package com.paytool.adapters.outbound;

import com.paytool.adapters.outbound.entity.UserEntity;
import com.paytool.adapters.outbound.mapper.UserMapper;
import com.paytool.adapters.outbound.repository.UserRepository;
import com.paytool.application.core.domain.enums.DocumentType;
import com.paytool.application.core.domain.enums.UserType;
import com.paytool.application.core.domain.models.User;
import com.paytool.application.ports.inbound.UserPort;
import com.paytool.config.util.DocumentValidator;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class UserAdapter implements UserPort {

    @Inject
    UserRepository repository;

    @Override
    @Transactional
    public User saveUser(User user) {

        String document = user.getDocument();

        if (document.length() > 11) {
            DocumentValidator.isValidCNPJ(document);
            user.setDocumentType(DocumentType.J);
            user.setUserType(UserType.TRADESMAN);
        } else {
            DocumentValidator.isValidCPF(document);
            user.setDocumentType(DocumentType.F);
            user.setUserType(UserType.COMMON);
        }

        UserEntity userEntity = UserMapper.INSTANCE.userToUserEntity(user);

        try {
            repository.isDocumentEmailUnique(user.getDocument(), user.getEmail());
            repository.persist(userEntity);
            return UserMapper.INSTANCE.userEntityToUser(userEntity);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<User> getUsers() {
        try {
            return UserMapper.INSTANCE.mapUserEntityListToUserList(repository.findAll().list());
        } catch (Exception e) {
            throw new RuntimeException("Users not found");
        }
    }

    @Override
    public User getUserById(UUID id) {
        try {
            UserEntity userEntity = repository.getUserById(id);
            return UserMapper.INSTANCE.userEntityToUser(userEntity);
        } catch (Exception e) {
            throw new RuntimeException("User not found");
        }
    }

    @Override
    public User getUserByDocument(String document) {
        try {
            UserEntity userEntity = repository.getUserByDocument(document);
            return UserMapper.INSTANCE.userEntityToUser(userEntity);
        } catch (Exception e) {
            throw new RuntimeException("User not found");
        }
    }

    @Override
    public User getUserByEmail(String email) {
        try {
            UserEntity userEntity = repository.getUserByEmail(email);
            return UserMapper.INSTANCE.userEntityToUser(userEntity);
        } catch (Exception e) {
            throw new RuntimeException("User not found");
        }
    }

    @Override
    @Transactional
    public void deleteUser(UUID id) {
        try {
            repository.deleteUser(id);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
