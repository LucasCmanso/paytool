package com.paytool.application.core.domain.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;

public enum DocumentType {
    F("fisico"),
    J("juridico");

    @JsonValue
    private String type;

    DocumentType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @JsonCreator
    public static DocumentType fromType(String type) {
        for (DocumentType documentType : DocumentType.values()) {
            if (documentType.getType().equalsIgnoreCase(type)) {
                return documentType;
            }
        }

        return null;
    }

}
