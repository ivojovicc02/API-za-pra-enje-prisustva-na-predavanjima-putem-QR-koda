package com.example.attendance.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "lecture_session_id", nullable = false)
    private LectureSession lectureSession; // ⬅️ OVO IME JE KRITIČNO

    private LocalDateTime scannedAt;
}
