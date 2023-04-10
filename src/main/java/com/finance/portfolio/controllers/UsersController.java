package com.finance.portfolio.controllers;

import com.finance.portfolio.config.annotations.RestControllerWrapper;
import com.finance.portfolio.domain.dto.user.UsersResponse;
import com.finance.portfolio.services.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RestControllerWrapper
@RequestMapping("api/v1")
public class UsersController {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<UsersResponse>> getUsers() {
        var response = userService.getAllUsers();
        return ResponseEntity.ok(response);
    }
}
