package com.example.attendance.controller;

import com.example.attendance.model.Attendance;
import com.example.attendance.service.AttendanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AttendanceService attendanceService;

    // ✅ samo za test (ostavi slobodno)
    @GetMapping("/test")
    public String adminRoute() {
        return "ADMIN ROUTE – ACCESS GRANTED";
    }

    // 👑 ADMIN – vidi SVE evidencije
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/attendance")
    public List<Attendance> getAllAttendance() {
        return attendanceService.getAll();
    }

    // 👑 ADMIN – vidi evidenciju po sessionu
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/attendance/session/{sessionId}")
    public List<Attendance> getBySession(
            @PathVariable Long sessionId
    ) {
        return attendanceService.getBySession(sessionId);
    }
}
