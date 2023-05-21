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
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

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

    @GetMapping("/admin")
    public ResponseEntity<String> getAdmin(Principal principal) {
        JwtAuthenticationToken token = (JwtAuthenticationToken) principal;
        String userName = (String) token.getTokenAttributes().get("name");
        String userEmail = (String) token.getTokenAttributes().get("email");
        return ResponseEntity.ok("Hello Admin \nUser Name : " + userName + "\nUser Email : " + userEmail);
    }
}
