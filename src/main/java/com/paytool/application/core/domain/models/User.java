package com.paytool.application.core.domain.models;

import com.paytool.application.core.domain.enums.DocumentType;
import com.paytool.application.core.domain.enums.UserType;

import java.math.BigDecimal;
import java.util.UUID;

public class User {

    private UUID userId;
    private String fullName;
    private DocumentType documentType;
    private String document;
    private String email;
    private String password;
    private UserType userType;
    private BigDecimal balance;

    public User(){}

    public User(UUID userId, String fullName, DocumentType documentType, String document, String email, String password, UserType userType, BigDecimal balance) {
        this.userId = userId;
        this.fullName = fullName;
        this.documentType = documentType;
        this.document = document;
        this.email = email;
        this.password = password;
        this.userType = userType;
        this.balance = balance;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
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
        this.password = password;
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