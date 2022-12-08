package com.finance.portfolio.domain.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserRegistrationResponse {
    public String firstName;

    public String lastName;

    public String email;

    public String token;
}
