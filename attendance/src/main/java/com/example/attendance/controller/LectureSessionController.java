package com.example.attendance.controller;

import com.example.attendance.model.LectureSession;
import com.example.attendance.service.LectureSessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/lecture-sessions")
@RequiredArgsConstructor
public class LectureSessionController {

    private final LectureSessionService lectureSessionService;

    // 👑 ADMIN – pokreće predavanje (generira QR)
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public LectureSession create(@RequestParam Long lectureId) {
        return lectureSessionService.create(lectureId);
    }

    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @GetMapping("/{id}")
    public LectureSession findById(@PathVariable Long id) {
        return lectureSessionService.findById(id);
    }
}

