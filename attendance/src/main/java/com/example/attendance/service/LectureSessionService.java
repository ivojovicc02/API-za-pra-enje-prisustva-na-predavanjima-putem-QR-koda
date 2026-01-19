package com.example.attendance.service;

import com.example.attendance.model.LectureSession;

public interface LectureSessionService {

    LectureSession create(Long lectureId);

    LectureSession findById(Long id);
}
