package com.finance.portfolio.domain.exceptions;

public class ItemNotFoundException extends TechnicalCoreException{
    public ItemNotFoundException(String message) {
        super(message);
    }
}
