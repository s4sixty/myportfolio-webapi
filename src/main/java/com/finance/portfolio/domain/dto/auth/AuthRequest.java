package com.finance.portfolio.domain.dto.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthRequest {
    @NotBlank(message = "email must not be blank")
    @Email(message = "email is not valid")
    private String email;

    @NotBlank(message = "password must not be blank")
    private String  password;

}
