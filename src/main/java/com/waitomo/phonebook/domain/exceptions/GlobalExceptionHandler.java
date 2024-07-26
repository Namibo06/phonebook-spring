package com.waitomo.phonebook.domain.exceptions;

import com.waitomo.phonebook.infrastructure.web.responses.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handleAlreadyExistsException(AlreadyExistsException ex){
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), "Registro já existente no sistema");
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFoundException(NotFoundException ex){
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), "Registro(s) não encontrado(s)");
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}