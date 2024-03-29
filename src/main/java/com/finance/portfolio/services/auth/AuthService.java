package com.finance.portfolio.services.auth;

import com.finance.portfolio.domain.dao.User;
import com.finance.portfolio.domain.dto.auth.AuthRequest;
import com.finance.portfolio.domain.dto.auth.AuthResponse;
import com.finance.portfolio.util.auth.JwtTokenUtil;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthService {
    private JwtTokenUtil jwtTokenUtil;
    private AuthenticationManager authManager;

    public AuthResponse authenticateUser(AuthRequest request) {
        try {
            Authentication authentication = authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getEmail(), request.getPassword())
            );

            User user = (User) authentication.getPrincipal();
            String accessToken = jwtTokenUtil.generateAccessToken(user);
            return new AuthResponse(user.getEmail(), accessToken);

        } catch (BadCredentialsException ex) {
            throw new BadCredentialsException("Invalid credentials", ex);
        }
    }
}
