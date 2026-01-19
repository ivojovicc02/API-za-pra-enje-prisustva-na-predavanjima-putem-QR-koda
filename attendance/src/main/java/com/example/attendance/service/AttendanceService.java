package com.example.attendance.service;

public interface AttendanceService {
    void scan(Long studentId, String qrToken);
}

