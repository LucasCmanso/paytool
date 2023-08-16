package com.paytool.domain.models;

import com.paytool.domain.enums.DocumentType;
import com.paytool.domain.enums.UserType;

import java.math.BigDecimal;

public class User {

    private String fullName;
    private Enum<DocumentType> documentType;
    private String document;
    private String email;
    private String password;
    private Enum<UserType> userType;
    private BigDecimal balance;

    public User(String fullName, Enum<DocumentType> documentType, String document, String email, String password, Enum<UserType> userType) {
        this.fullName = fullName;
        this.documentType = documentType;
        this.document = document;
        this.email = email;
        this.password = password;
        this.userType = userType;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Enum<DocumentType> getDocumentType() {
        return documentType;
    }

    public void setDocumentType(Enum<DocumentType> documentType) {
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

    public Enum<UserType> getUserType() {
        return userType;
    }

    public void setUserType(Enum<UserType> userType) {
        this.userType = userType;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "{" +
                "fullName='" + fullName + '\'' +
                ", documentType=" + documentType +
                ", document='" + document + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", userType=" + userType +
                '}';
    }
}