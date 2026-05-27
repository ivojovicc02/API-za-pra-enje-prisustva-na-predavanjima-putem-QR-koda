package com.example.attendance.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class LectureSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Lecture lecture;

    @Column(unique = true, nullable = false)
    private String qrToken;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private LocalDateTime qrExpiresAt;
}
