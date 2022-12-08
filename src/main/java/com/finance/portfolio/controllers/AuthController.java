package com.finance.portfolio.controllers;

import com.finance.portfolio.domain.dto.auth.AuthRequest;
import com.finance.portfolio.services.auth.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("auth/login")
    public ResponseEntity login(@RequestBody @Valid AuthRequest request) {
        var response = authService.authenticateUser(request);
        return response;
    }
}
