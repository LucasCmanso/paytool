package com.paytool.adapters.outbound.dto;

import com.paytool.application.core.domain.enums.DocumentType;
import com.paytool.application.core.domain.enums.UserType;

import java.math.BigDecimal;
import java.util.UUID;

public record UserResponseDto(

        UUID userId,
        String fullName,
        String document,
        String email,
        BigDecimal balance
) {}