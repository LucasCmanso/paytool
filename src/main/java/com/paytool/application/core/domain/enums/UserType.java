package com.paytool.application.core.domain.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

public enum UserType {
    COMMON("commons"),
    TRADESMAN("tradesman");

    @JsonValue
    private String type;

    UserType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @JsonCreator
    public static UserType fromType(String type) {
        for (UserType userType : UserType.values()) {
            if (userType.getType().equals(type)) {
                return userType;
            }
        }

        return null;
    }
}
