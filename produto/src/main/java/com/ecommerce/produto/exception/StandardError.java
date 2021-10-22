package com.ecommerce.produto.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StandardError {
    private Instant timestemp;
    private String message;
    private int status;
    private String error;
    private String path;
}
