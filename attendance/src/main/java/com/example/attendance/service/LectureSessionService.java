package com.example.attendance.service;

import com.example.attendance.model.LectureSession;

import java.util.List;
import java.util.Optional;

public interface LectureSessionService {

    LectureSession create(Long lectureId);

    LectureSession findById(Long id);

    Optional<LectureSession> getByQrToken(String qrToken);
}


