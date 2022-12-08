package com.finance.portfolio.services.user;

import com.finance.portfolio.domain.dao.Role;
import com.finance.portfolio.repositories.RoleRepository;
import com.finance.portfolio.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Slf4j
@Service
public class RoleService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;

    public Role saveRole(Role role) {
        return null;
    }

    public void addRolesToUser(Long userId, List<Long> roles) {
        var user = userRepository.findById(userId).orElseThrow(() -> new IllegalStateException("user not found"));
        var userRoles = user.getRoles();
        for(var role : roles) {
            var newRole = this.roleRepository.findById(role);
            userRoles.add(newRole.get());
        }
        log.info("roles {} have been added to user {}", roles, user.getEmail());
    }
}
