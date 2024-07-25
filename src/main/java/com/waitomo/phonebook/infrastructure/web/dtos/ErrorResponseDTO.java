package com.waitomo.phonebook.infrastructure.web.dtos;

public record ErrorResponseDTO(
        String message,
        String details
) {
}
