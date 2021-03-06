package com.damnjan.beerfactory.exceptions;

import org.springframework.http.HttpStatus;

public class BeerNotFoundException extends Exception {

    private final HttpStatus status = HttpStatus.NOT_FOUND;

    public BeerNotFoundException(String message) {
        super(message);
    }

    public HttpStatus getStatus() {
        return status;
    }
}
