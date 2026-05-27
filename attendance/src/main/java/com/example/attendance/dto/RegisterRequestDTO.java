package com.example.attendance.dto;

public record RegisterRequestDTO(
        String username,
        String password,
        String role   // "USER" ili "ADMIN"
) {}

