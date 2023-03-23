package com.example.raisingjungsu.domain.user.api;

import com.example.raisingjungsu.domain.user.api.dto.request.LoginRequest;
import com.example.raisingjungsu.domain.user.api.dto.request.SignupRequest;
import com.example.raisingjungsu.domain.user.api.dto.response.TokenResponse;
import com.example.raisingjungsu.domain.user.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/signup")
    public void signup(@RequestBody @Valid SignupRequest request){
        authService.signup(request);
    }

    @PostMapping("/login")
    public TokenResponse login(@RequestBody @Valid LoginRequest request){
        return authService.login(request);
    }
}
