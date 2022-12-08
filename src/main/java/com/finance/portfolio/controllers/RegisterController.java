package com.finance.portfolio.controllers;

import com.finance.portfolio.domain.dto.auth.UserRegistrationRequest;
import com.finance.portfolio.domain.dto.auth.UserRegistrationResponse;
import com.finance.portfolio.services.auth.RegisterService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/v1")
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @PostMapping("auth/signup")
    public UserRegistrationResponse signUp(@Valid @RequestBody UserRegistrationRequest request) {
        var response = registerService.registerUser(request);
        return response;
    }
}
