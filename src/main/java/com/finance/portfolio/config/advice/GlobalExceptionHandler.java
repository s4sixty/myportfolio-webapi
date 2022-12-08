package com.finance.portfolio.config.advice;

import com.finance.portfolio.domain.dto.core.ApiResult;
import com.finance.portfolio.domain.dto.core.ApiResultCodes;
import com.finance.portfolio.domain.dto.core.ExceptionDTO;
import com.finance.portfolio.domain.exceptions.BusinessCoreException;
import com.finance.portfolio.domain.exceptions.TechnicalCoreException;
import com.finance.portfolio.domain.exceptions.UnauthorizedException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.AccessDeniedException;
import java.util.ArrayList;
import java.util.List;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
@RestController
@Slf4j
public class GlobalExceptionHandler {

    @ResponseStatus(value = HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(value = {AccessDeniedException.class, BadCredentialsException.class,
            UnauthorizedException.class, InsufficientAuthenticationException.class})
    public final ApiResult<String> handleUnauthorizedException(Exception ex) {
        return ApiResult.<String>builder()
                .resultCode(ApiResultCodes.BUSINESS_FAILURE.toString())
                .exception(buildExceptionDto(ex))
                .build();
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public final ApiResult<String> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        return ApiResult.<String>builder()
                .resultCode(ApiResultCodes.BUSINESS_FAILURE.toString())
                .exception(buildExceptionDto(ex))
                .build();
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {BusinessCoreException.class})
    public final ApiResult<String> handleBusinessException(Exception ex) {
        return ApiResult.<String>builder()
                .resultCode(ApiResultCodes.BUSINESS_FAILURE.toString())
                .exception(buildExceptionDto(ex))
                .build();
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {TechnicalCoreException.class})
    public final ApiResult<String> handleTechnicalException(Exception ex) {
        return ApiResult.<String>builder()
                .resultCode(ApiResultCodes.TECHNICAL_FAILURE.toString())
                .exception(buildExceptionDto(ex))
                .build();
    }

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = {Exception.class})
    public final ApiResult<String> handleAllExceptions(Exception ex) {
        return ApiResult.<String>builder()
                .resultCode(ApiResultCodes.TECHNICAL_FAILURE.toString())
                .exception(buildExceptionDto(ex))
                .build();
    }

    private ExceptionDTO buildExceptionDto(Exception ex) {
        var message = ex.getMessage();

        if(message.isEmpty() || message.isBlank()) message = ex.getClass().getName();

        var exceptionDto = ExceptionDTO.builder()
                .message(message)
                .build();

        if(ex instanceof BindException) {
            List<String> details = new ArrayList<>();
            for(ObjectError error : ((BindException) ex).getBindingResult().getAllErrors()) {
                details.add(error.getDefaultMessage());
            }
            exceptionDto.setDetails(details);
            exceptionDto.setMessage("Data validation error");
        }

        return exceptionDto;
    }
}
