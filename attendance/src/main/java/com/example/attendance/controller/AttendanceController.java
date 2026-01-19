package com.example.attendance.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.example.attendance.service.AttendanceService;

@RestController
@RequestMapping("/api/attendance")
@RequiredArgsConstructor
public class AttendanceController {

    private final AttendanceService attendanceService;

    @PostMapping("/scan")
    public void scan(
            @RequestParam Long studentId,
            @RequestParam String qrToken
    ) {
        attendanceService.scan(studentId, qrToken);
    }
}
