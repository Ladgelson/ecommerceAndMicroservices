package com.ecommerce.produto.exception;

import com.ecommerce.produto.service.exception.ConstraintViolationError;
import com.ecommerce.produto.service.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import java.time.Instant;
import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionHandlerConfiguration {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest req) {
        String error = "Resource not found";
        int status = HttpStatus.NOT_FOUND.value();
        return ResponseEntity.status(status).body(
                StandardError
                        .builder()
                        .status(status)
                        .timestemp(Instant.now())
                        .error(error)
                        .message(e.getMessage())
                        .path(req.getRequestURI())
                .build());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ConstraintViolationError> constraintViolation(ConstraintViolationException e, HttpServletRequest req) {
        String error = "Resource not found";
        int status = HttpStatus.BAD_REQUEST.value();
        ConstraintViolationError constraintViolationError = new ConstraintViolationError(StandardError
                .builder()
                .status(status)
                .timestemp(Instant.now())
                .error(error)
                .message(e.getMessage())
                .path(req.getRequestURI())
                .build());

        constraintViolationError.setConstraintMessages(e.getConstraintViolations()
                .stream()
                .map(constraintViolation -> constraintViolation.getMessage())
                .collect(Collectors.toList()));
        return ResponseEntity.status(status).body(constraintViolationError);
    }
}
