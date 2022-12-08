package com.finance.portfolio.services.user;

import com.finance.portfolio.domain.dao.User;
import com.finance.portfolio.domain.dto.user.UsersResponse;
import com.finance.portfolio.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@AllArgsConstructor
@Service
public class UserService implements UserDetailsService {

    private UserRepository userRepository;

    private ModelMapper modelMapper;

    public User getUser(String email) {
        var user = userRepository.findByEmail(email).orElseThrow(() -> new IllegalStateException("user not found"));
        return user;
    }

    public List<UsersResponse> getAllUsers() {
        var users = userRepository.findAll();
        var usersResponse = users.stream()
                .map(user -> modelMapper.map(user, UsersResponse.class))
                .collect(Collectors.toList());
        return usersResponse;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        var user = this.getUser(email);
        return user;
    }
}
