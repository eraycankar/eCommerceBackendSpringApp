package com.dev.ecommerce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
public class OrderNotCreatedException  extends RuntimeException {

    public OrderNotCreatedException(String message) {
        super(message);
    }
}

