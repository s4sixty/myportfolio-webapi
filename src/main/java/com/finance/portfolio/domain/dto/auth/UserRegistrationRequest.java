package com.finance.portfolio.domain.dto.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;


@Getter
@Setter
@AllArgsConstructor
public class UserRegistrationRequest {

    @NotBlank(message = "first name must not be blank")
    public String firstName;

    @NotBlank(message = "last name must not be blank")
    public String lastName;

    @NotBlank(message = "email must not be blank")
    @Email(message = "email is not valid")
    public String email;

    @NotBlank(message = "password must not be blank")
    @Length(min = 6, max = 24)
    public String password;
}
