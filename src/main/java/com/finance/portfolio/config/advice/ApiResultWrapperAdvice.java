package com.finance.portfolio.config.advice;

import com.finance.portfolio.domain.dto.core.ApiResult;
import com.finance.portfolio.domain.dto.core.ApiResultCodes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;


@ControllerAdvice
@Slf4j
public class ApiResultWrapperAdvice implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        // TODO: wrap supported controllers with an annotation
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        ApiResult<?> apiResult;
        if(body instanceof ApiResult) {
            apiResult = (ApiResult<?>) body;
        } else {
            apiResult = ApiResult.builder()
                    .resultCode(ApiResultCodes.SUCCESS.toString())
                    .data(body)
                    .build();
        }
        return apiResult;
    }
}
