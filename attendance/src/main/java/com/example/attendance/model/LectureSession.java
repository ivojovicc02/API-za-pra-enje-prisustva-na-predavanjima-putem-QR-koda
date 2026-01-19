package com.example.attendance.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data

public class LectureSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Lecture lecture;

    private String qrToken;

    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private LocalDateTime qrExpiresAt;
}
