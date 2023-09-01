package com.paytool.adapters.outbound.entity;

import com.paytool.application.core.domain.enums.DocumentType;
import com.paytool.application.core.domain.enums.UserType;
import io.quarkus.elytron.security.common.BcryptUtil;
import io.quarkus.security.jpa.Password;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID userId;
    private String fullName;

    @Enumerated(EnumType.STRING)
    private DocumentType documentType;

    @Column(unique = true)
    private String document;

    @Column(unique = true)
    private String email;

    @Password
    private String password;

    @Enumerated(EnumType.STRING)
    private UserType userType;
    private BigDecimal balance;

    public UserEntity(){}

    public UserEntity(String fullName, DocumentType documentType, String document, String email, String password, UserType userType, BigDecimal balance) {
        this.fullName = fullName;
        this.documentType = documentType;
        this.document = document;
        this.email = email;
        this.password = BcryptUtil.bcryptHash(password);
        this.userType = userType;
        this.balance = balance;
    }

    public UUID getUserId() {
        return userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = BcryptUtil.bcryptHash(password);
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
