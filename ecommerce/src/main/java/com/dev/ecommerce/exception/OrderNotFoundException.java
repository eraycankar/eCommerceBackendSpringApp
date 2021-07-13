package com.dev.ecommerce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.text.MessageFormat;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class OrderNotFoundException extends RuntimeException{
    public OrderNotFoundException(Long id) {
        super(MessageFormat.format("Could not find Order with id:",id));
    }
}
