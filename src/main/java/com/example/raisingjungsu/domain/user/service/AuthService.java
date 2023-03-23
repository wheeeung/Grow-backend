package com.example.raisingjungsu.domain.user.service;

import com.example.raisingjungsu.domain.user.api.dto.request.LoginRequest;
import com.example.raisingjungsu.domain.user.api.dto.request.SignupRequest;
import com.example.raisingjungsu.domain.user.api.dto.response.TokenResponse;
import com.example.raisingjungsu.domain.user.domain.User;
import com.example.raisingjungsu.domain.user.exception.AlreadyExistException;
import com.example.raisingjungsu.domain.user.exception.PasswordNotMatchesException;
import com.example.raisingjungsu.domain.user.exception.UserNotFoundException;
import com.example.raisingjungsu.domain.user.repository.UserRepository;
import com.example.raisingjungsu.global.jwt.TokenProvider;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final TokenProvider tokenProvider;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void signup(SignupRequest request) {
        if(userRepository.findByEmail(request.getEmail()).isPresent())
            throw new AlreadyExistException();

        User user = User.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .nickname(request.getNickname())
                .build();
        userRepository.save(user);
    }

    @Transactional
    public TokenResponse login(LoginRequest request){
        User user = userRepository.findByEmail(request.getEmail()).orElseThrow(UserNotFoundException::new);
        if(!passwordEncoder.matches(request.getPassword(), user.getPassword()))
            throw new PasswordNotMatchesException();

        String accessToken = tokenProvider.createAccessToken(request.getEmail());
        String refreshToken = tokenProvider.createRefreshToken(request.getEmail());

        return TokenResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }
}
