package com.dev.ecommerce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
public class OrderDetailNotCreatedException extends RuntimeException {
    public OrderDetailNotCreatedException(String message) {
        super(message);
    }
}
