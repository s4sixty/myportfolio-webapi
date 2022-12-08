package com.finance.portfolio.domain.exceptions;

public class UnauthorizedException extends TechnicalCoreException{
    public UnauthorizedException(String message) {
        super(message);
    }
}
