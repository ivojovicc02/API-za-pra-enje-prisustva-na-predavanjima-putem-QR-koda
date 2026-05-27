package com.example.attendance.controller;

import com.example.attendance.dto.*;
import com.example.attendance.model.Student;
import com.example.attendance.model.User;
import com.example.attendance.repository.StudentRepository;
import com.example.attendance.security.JwtTokenProvider;
import com.example.attendance.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserDetailsService userDetailsService;
    private final UserService userService;
    private final StudentRepository studentRepository;

    @PostMapping("/login")
    public LoginResponseDTO login(@RequestBody LoginRequestDTO request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.username(),
                        request.password()
                )
        );

        UserDetails user =
                userDetailsService.loadUserByUsername(request.username());

        String token = jwtTokenProvider.generateToken(user);

        return new LoginResponseDTO(token);
    }

    @PostMapping("/register")
    public void register(@RequestBody RegisterRequestDTO request) {

        User user = new User();
        user.setUsername(request.username());
        user.setPassword(request.password());
        user.setRole(request.role());

        // spremi usera
        User savedUser = userService.createUser(user);

        // ako je USER -> napravi Student
        if (savedUser.getRole().equals("USER")) {

            Student student = new Student();

            student.setName(savedUser.getUsername());
            student.setEmail(savedUser.getUsername() + "@mail.com");
            student.setUser(savedUser);

            studentRepository.save(student);
        }
    }
}