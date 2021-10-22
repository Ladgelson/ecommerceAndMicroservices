package com.ecommerce.produto.service.exception;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(Object id) {
        super("Resource not found. ID: " + id);
    }
}
