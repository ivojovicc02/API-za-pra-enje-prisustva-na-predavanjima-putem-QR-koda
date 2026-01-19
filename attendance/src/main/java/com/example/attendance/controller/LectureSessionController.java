package com.example.attendance.controller;

import lombok.RequiredArgsConstructor;
import com.example.attendance.model.LectureSession;
import org.springframework.web.bind.annotation.*;
import com.example.attendance.service.LectureSessionService;

@RestController
@RequestMapping("/api/lecture-sessions")
@RequiredArgsConstructor
public class LectureSessionController {

    private final LectureSessionService lectureSessionService;

    // Profesor pokreće predavanje
    @PostMapping
    public LectureSession create(@RequestParam Long lectureId) {
        return lectureSessionService.create(lectureId);
    }

    // (opcionalno) dohvat jedne session
    @GetMapping("/{id}")
    public LectureSession findById(@PathVariable Long id) {
        return lectureSessionService.findById(id);
    }
}
