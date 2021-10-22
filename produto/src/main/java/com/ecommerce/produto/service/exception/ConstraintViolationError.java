package com.ecommerce.produto.service.exception;

import com.ecommerce.produto.exception.StandardError;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ConstraintViolationError extends StandardError {
    private List<String> constraintMessages = new ArrayList<>();

    public ConstraintViolationError(StandardError standardError) {
        super(standardError.getTimestemp(),
                standardError.getMessage(),
                standardError.getStatus(),
                standardError.getError(),
                standardError.getPath());
    }
}
