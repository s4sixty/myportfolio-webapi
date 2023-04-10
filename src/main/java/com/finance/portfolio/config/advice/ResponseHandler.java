package com.finance.portfolio.config.advice;

import com.finance.portfolio.config.annotations.RestControllerWrapper;
import com.finance.portfolio.domain.dto.core.ApiResult;
import org.slf4j.MDC;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice(annotations = RestControllerWrapper.class)
public class ResponseHandler implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        var activityId = MDC.get("activityId");
        if (body instanceof ApiResult) {
            ((ApiResult<?>) body).setActivityId(activityId);
        }
        return body;
    }
}