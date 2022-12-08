package com.finance.portfolio.domain.exceptions;

public class SanityCheckException extends BusinessCoreException {
    public SanityCheckException(String message) {
        super(message);
    }
}
