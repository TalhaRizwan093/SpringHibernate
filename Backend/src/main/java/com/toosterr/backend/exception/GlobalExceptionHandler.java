package com.toosterr.backend.exception;

import com.toosterr.backend.dto.CustomErrorResponse;
import com.toosterr.backend.exception.categoryException.CategoryNotFoundException;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    final MessageSource messageSource;

    public GlobalExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        String message = messageSource.getMessage("api.param.invalid", new Object[]{ex.getMessage()}, LocaleContextHolder.getLocale());
        CustomErrorResponse errorResponse = new CustomErrorResponse(message, HttpStatus.BAD_REQUEST, errors, "ARGUMENT_NOT_VALID");
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<?> handleCategoryNotFoundException(CategoryNotFoundException ex) {
        String message = messageSource.getMessage("category.not.found", new Object[]{ex.getMessage()}, LocaleContextHolder.getLocale());
        CustomErrorResponse errorResponse = new CustomErrorResponse(message,HttpStatus.INTERNAL_SERVER_ERROR,"INTERNAL_SERVER_ERROR");
        return  new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> handleRuntimeException(RuntimeException ex) {
        String message = messageSource.getMessage("internal.server.error", new Object[]{ex.getMessage()}, LocaleContextHolder.getLocale());
        CustomErrorResponse errorResponse = new CustomErrorResponse(message,HttpStatus.INTERNAL_SERVER_ERROR,"INTERNAL_SERVER_ERROR");
        return  new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
