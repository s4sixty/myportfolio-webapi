package com.finance.portfolio.services.auth;

import com.finance.portfolio.domain.dao.User;
import com.finance.portfolio.domain.dto.auth.UserRegistrationRequest;
import com.finance.portfolio.domain.dto.auth.UserRegistrationResponse;
import com.finance.portfolio.repositories.UserRepository;
import com.finance.portfolio.util.auth.JwtTokenUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class RegisterService {

    private UserRepository userRepository;
    private ModelMapper modelMapper;
    private JwtTokenUtil jwtTokenUtil;
    private PasswordEncoder encoder;

    public UserRegistrationResponse registerUser(UserRegistrationRequest request) {
        if(userRepository.existsByEmail(request.email)) {
            throw new IllegalStateException("User with email " + request.email + " already exists");
        }
        User user = modelMapper.map(request, User.class);
        user.setPassword(encoder.encode(request.password));
        userRepository.save(user);
        var userResponse = modelMapper.map(user, UserRegistrationResponse.class);
        userResponse.setToken(jwtTokenUtil.generateAccessToken(user));
        return userResponse;
    }
}
