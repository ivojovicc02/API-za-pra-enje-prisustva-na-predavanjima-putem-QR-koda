package com.example.attendance.service;

import com.example.attendance.model.LectureSession;

import java.util.List;
import java.util.Optional;

public interface LectureSessionService {

    LectureSession create(LectureSession lectureSession);

    LectureSession create(Long lectureSession);

    LectureSession update(Long id, LectureSession lectureSession);

    void delete(Long id);

    LectureSession getById(Long id);

    List<LectureSession> getAll();

    // 👇 bitno za QR
    Optional<LectureSession> getByQrToken(String qrToken);

    LectureSession findById(Long id);
}
