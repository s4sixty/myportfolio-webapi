package com.finance.portfolio.domain.dto.core;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Collection;

@Data
@SuperBuilder
public class ApiResult<T> {
    String activityId;
    String resultCode;
    Collection<String> messages;
    T data;
    ExceptionDTO exception;
}