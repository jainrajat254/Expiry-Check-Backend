package com.example.ExpiryCheck.service;

import com.example.ExpiryCheck.data.Items;
import com.example.ExpiryCheck.data.LoginCredentials;
import com.example.ExpiryCheck.data.LoginResponse;
import com.example.ExpiryCheck.repository.AuthRepository;
import com.example.ExpiryCheck.schemas.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthService {

    @Autowired
    private AuthRepository authRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);

    public Object login(LoginCredentials loginCredentials) {
        String username = loginCredentials.getUsername();
        String password = loginCredentials.getPassword();

        Users users = authRepository.findByUsername(username);

        if (users == null) {
            throw new BadCredentialsException("No such username exists");
        }

        if (!bCryptPasswordEncoder.matches(password, users.getPassword())) {
            throw new BadCredentialsException("Password not correct");
        }

        return new LoginResponse(
                users.getFullName(),
                users.getUsername(),
                users.getItems()
        );
    }

    public Users register(Users users) {
        if (authRepository.findByUsername(users.getUsername()) != null) {
            throw new BadCredentialsException("Username already exists");
        }
        users.setPassword(bCryptPasswordEncoder.encode(users.getPassword()));
        return authRepository.save(users);
    }

}
