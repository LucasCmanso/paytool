package com.paytool.domain.enums;

public enum DocumentType {
    F("fisico"),
    J("juridico");

    private String type;
    DocumentType(String type) {
        this.type = type;
    }
}
