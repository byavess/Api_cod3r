package com.example.demo.ProdutoResourse.excepetion;

import com.example.demo.exception.DatabaseException;
import com.example.demo.exception.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice//intercepta as exeções que acontecerem para que esse objeto possa executar um tratamento
public class ResourceExeceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)//setando otipo de exceção
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
        String erro = "Resouce not found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(Instant.now(), status.value(), erro, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);

    }

    @ExceptionHandler(DatabaseException.class)//setando otipo de exceção
    public ResponseEntity<StandardError> database(DatabaseException e, HttpServletRequest request) {
        String erro = "Database error";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError err = new StandardError(Instant.now(), status.value(), erro, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

}