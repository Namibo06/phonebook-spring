package com.waitomo.phonebook.infrastructure.web.responses;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

public record ContactRequest(
        @NonNull
        @NotBlank
        @Size(max = 30, message = "Nome deve ter no máximo 30 caracteres")
        String name,
        @NonNull
        @NotBlank
        @Size(min = 11, max = 11, message = "Número de telefone deve ter exatamente 11 caracteres")
        String numberPhone
){

}
