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
    private Student student;

    @ManyToOne
    private LectureSession session;

    private LocalDateTime timestamp;

    public void setLectureSession(LectureSession session) {
    }
}
