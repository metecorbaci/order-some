package com.ordersome.backend.controller;

import com.ordersome.backend.dto.LoginReqDto;
import com.ordersome.backend.dto.RegisterReqDto;
import com.ordersome.backend.service.AuthService;
import com.ordersome.backend.util.JwtUtil;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
// Swagger da gözükecek olan tag'in adı ve açıklaması
@Tag(name = "Auth", description = "User Auth APIS")
public class AuthController {

    @Autowired
    private AuthService authService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity login(@Valid @RequestBody LoginReqDto loginReqDto) {
        return authService.login(loginReqDto);
    }

    @PostMapping("/register")
    public ResponseEntity register(@Valid @RequestBody RegisterReqDto registerReqDto){
        return authService.registerUser(registerReqDto);
    }

}
