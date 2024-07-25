package com.waitomo.phonebook.domain.exceptions;

import com.waitomo.phonebook.infrastructure.web.dtos.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AlreadyExistsException.class)
    public ResponseEntity<ErrorResponseDTO> handleAlreadyExistsException(AlreadyExistsException ex){
        ErrorResponseDTO errorResponse = new ErrorResponseDTO(ex.getMessage(), "Registro já existente no sistema");
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleNotFoundException(NotFoundException ex){
        ErrorResponseDTO errorResponse = new ErrorResponseDTO(ex.getMessage(), "Registro(s) não encontrado(s)");
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}