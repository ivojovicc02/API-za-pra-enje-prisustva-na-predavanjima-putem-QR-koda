package com.example.attendance.controller;

import com.example.attendance.service.AttendanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/attendance")
@RequiredArgsConstructor
public class AttendanceController {

    private final AttendanceService attendanceService;

    // 👤 USER – skenira QR kod
    @PreAuthorize("hasRole('USER')")
    @PostMapping("/scan")
    public void scan(
            @RequestParam Long studentId,
            @RequestParam String qrToken
    ) {
        attendanceService.scan(studentId, qrToken);
    }

    // 👑 ADMIN – vidi sve evidencije (primjer)
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/all")
    public Object getAll() {
        return attendanceService.getAll();
    }
}
