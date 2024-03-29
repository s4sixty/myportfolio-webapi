package com.finance.portfolio.controllers;

import com.finance.portfolio.config.annotations.RestControllerWrapper;
import com.finance.portfolio.domain.dto.auth.UserRegistrationRequest;
import com.finance.portfolio.domain.dto.auth.UserRegistrationResponse;
import com.finance.portfolio.services.auth.RegisterService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RestControllerWrapper
@RequestMapping("api/v1")
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @PostMapping("auth/signup")
    public ResponseEntity<UserRegistrationResponse> signUp(@Valid @RequestBody UserRegistrationRequest request) {
        var response = registerService.registerUser(request);
        return ResponseEntity.ok().body(response);
    }
}
