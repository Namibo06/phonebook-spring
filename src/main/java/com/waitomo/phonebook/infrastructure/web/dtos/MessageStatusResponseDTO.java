package com.waitomo.phonebook.infrastructure.web.dtos;

public record MessageStatusResponseDTO(
        String message,
        Integer status
) {
}
