package com.example.attendance.service.impl;

import com.example.attendance.model.Lecture;
import com.example.attendance.model.LectureSession;
import com.example.attendance.repository.LectureRepository;
import com.example.attendance.repository.LectureSessionRepository;
import com.example.attendance.service.LectureSessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LectureSessionServiceImpl implements LectureSessionService {

    private final LectureSessionRepository lectureSessionRepository;
    private final LectureRepository lectureRepository;

    @Override
    public LectureSession create(Long lectureId) {

        Lecture lecture = lectureRepository.findById(lectureId)
                .orElseThrow(() -> new RuntimeException("Lecture not found"));

        LectureSession session = new LectureSession();
        session.setLecture(lecture);

        session.setStartTime(LocalDateTime.now());
        session.setQrExpiresAt(LocalDateTime.now().plusMinutes(5));
        session.setQrToken(UUID.randomUUID().toString());

        return lectureSessionRepository.save(session);
    }

    @Override
    public LectureSession findById(Long id) {
        return lectureSessionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("LectureSession not found"));
    }

    @Override
    public Optional<LectureSession> getByQrToken(String qrToken) {
        return lectureSessionRepository.findByQrToken(qrToken);
    }
}
