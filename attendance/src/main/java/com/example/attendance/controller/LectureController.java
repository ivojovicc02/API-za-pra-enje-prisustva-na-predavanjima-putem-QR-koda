package com.example.attendance.controller;

import com.example.attendance.model.Lecture;
import com.example.attendance.service.LectureService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lectures")
@RequiredArgsConstructor
public class LectureController {

    private final LectureService lectureService;

    // =========================
    // READ – USER + ADMIN
    // =========================

    @GetMapping
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public List<Lecture> getAllLectures() {
        return lectureService.getAllLectures();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public Lecture getLectureById(@PathVariable Long id) {
        return lectureService.getLectureById(id);
    }

    // =========================
    // CREATE – ADMIN
    // =========================

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public Lecture createLecture(@RequestBody Lecture lecture) {
        return lectureService.createLecture(lecture);
    }

    // =========================
    // UPDATE – ADMIN
    // =========================

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Lecture updateLecture(
            @PathVariable Long id,
            @RequestBody Lecture lecture
    ) {
        return lectureService.updateLecture(id, lecture);
    }

    // =========================
    // DELETE – ADMIN
    // =========================

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteLecture(@PathVariable Long id) {
        lectureService.deleteLecture(id);
    }
}


