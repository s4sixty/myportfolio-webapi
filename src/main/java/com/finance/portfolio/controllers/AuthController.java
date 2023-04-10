package com.finance.portfolio.controllers;

import com.finance.portfolio.config.annotations.RestControllerWrapper;
import com.finance.portfolio.domain.dto.auth.AuthRequest;
import com.finance.portfolio.domain.dto.auth.AuthResponse;
import com.finance.portfolio.domain.dto.core.ApiResult;
import com.finance.portfolio.domain.dto.core.ApiResultCodes;
import com.finance.portfolio.services.auth.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RestControllerWrapper
@RequestMapping("api/v1")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("auth/login")
    public ApiResult<AuthResponse> login(@RequestBody @Valid AuthRequest request) {
        var response = authService.authenticateUser(request);
        return ApiResult.<AuthResponse>builder()
                .data(response)
                .resultCode(ApiResultCodes.SUCCESS.toString())
                .build();
    }
}
