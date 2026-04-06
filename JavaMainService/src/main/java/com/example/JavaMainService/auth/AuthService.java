package com.example.JavaMainService.auth;

import com.example.JavaMainService.auth.errors.LoginBusyException;
import com.example.JavaMainService.auth.model.RegisterRequestDTO;
import com.example.JavaMainService.auth.model.RegisterResponseDTO;
import com.example.JavaMainService.user.Role;
import com.example.JavaMainService.user.User;
import com.example.JavaMainService.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final AuthMapper authMapper;

    public void register(RegisterRequestDTO request) {
        Optional<User> checkLoginBusy = userRepository.findByLogin(request.login());

        if (checkLoginBusy.isPresent()) {
            throw new LoginBusyException("логин уже занят");
        }

        User userToSave = authMapper.registerDtoToUser(request);
        userRepository.save(userToSave);
    }
}
