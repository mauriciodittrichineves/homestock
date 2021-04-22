package com.homestock.homestock.exception;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UnauthorizedException extends RuntimeException {
    private String message;
    public UnauthorizedException(String message) {
        super(message);
    }
}
