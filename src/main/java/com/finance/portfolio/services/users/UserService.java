package com.finance.portfolio.services.users;

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

@Slf4j
@AllArgsConstructor
@Service
public class UserService implements UserDetailsService {

    private UserRepository userRepository;

    private ModelMapper modelMapper;

    public User getUser(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new IllegalStateException("user not found"));
    }

    public List<UsersResponse> getAllUsers() {
        var users = userRepository.findAll();
        return users.stream()
                .map(user -> modelMapper.map(user, UsersResponse.class))
                .toList();
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return this.getUser(email);
    }
}
