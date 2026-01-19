package com.example.attendance.repository;

import com.example.attendance.model.LectureSession;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LectureSessionRepository extends JpaRepository<LectureSession, Long> {
    Optional<LectureSession> findByQrToken(String qrToken);
}

