package com.example.attendance.service.impl;

import lombok.RequiredArgsConstructor;
import com.example.attendance.model.Lecture;
import com.example.attendance.model.LectureSession;
import org.springframework.stereotype.Service;
import com.example.attendance.repository.LectureRepository;
import com.example.attendance.repository.LectureSessionRepository;
import com.example.attendance.service.LectureSessionService;

@Service
@RequiredArgsConstructor
public class LectureSessionServiceImpl implements LectureSessionService {

    private final LectureRepository lectureRepository;
    private final LectureSessionRepository lectureSessionRepository;

    @Override
    public LectureSession create(Long lectureId) {

        Lecture lecture = lectureRepository.findById(lectureId)
                .orElseThrow(() -> new RuntimeException("Lecture not found"));

        LectureSession session = new LectureSession();
        session.setLecture(lecture);

        return lectureSessionRepository.save(session);
    }

    @Override
    public LectureSession findById(Long id) {
        return lectureSessionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Session not found"));
    }
}
