package com.paytool.adapters.outbound.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.paytool.application.core.domain.enums.DocumentType;
import com.paytool.application.core.domain.enums.UserType;

import java.math.BigDecimal;
import java.util.UUID;

public record UserDto  (

        UUID userId,
        String fullName,
        DocumentType documentType,
        String document,
        String email,
        String password,
        UserType userType,
        BigDecimal balance
) {}