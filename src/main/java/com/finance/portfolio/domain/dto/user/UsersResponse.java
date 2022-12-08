package com.finance.portfolio.domain.dto.user;

import com.finance.portfolio.domain.dao.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsersResponse {
    private Long id;

    public String firstName;

    public String lastName;

    public String email;

    public Date creationDate;

    public List<Role> roles;

    public boolean enabled;
}
