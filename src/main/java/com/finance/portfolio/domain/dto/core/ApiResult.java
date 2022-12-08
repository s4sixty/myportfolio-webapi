package com.finance.portfolio.domain.dto.core;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Collection;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class ApiResult<T> {
    String activityId;
    String resultCode;
    Collection<String> messages;
    T data;
    ExceptionDTO exception;
}