package com.example.attendance.service.impl;

import com.example.attendance.model.LectureSession;
import com.example.attendance.repository.LectureSessionRepository;
import com.example.attendance.service.LectureSessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LectureSessionServiceImpl implements LectureSessionService {

    private final LectureSessionRepository lectureSessionRepository;

    @Override
    public LectureSession create(LectureSession lectureSession) {
        return lectureSessionRepository.save(lectureSession);
    }

    @Override
    public LectureSession create(Long lectureSession) {
        return null;
    }

    @Override
    public LectureSession update(Long id, LectureSession lectureSession) {
        LectureSession existing = getById(id);

        existing.setLecture(lectureSession.getLecture());
        existing.setQrToken(lectureSession.getQrToken());
        existing.setStartTime(lectureSession.getStartTime());
        existing.setEndTime(lectureSession.getEndTime());
        existing.setQrExpiresAt(lectureSession.getQrExpiresAt());

        return lectureSessionRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        lectureSessionRepository.deleteById(id);
    }

    @Override
    public LectureSession getById(Long id) {
        return lectureSessionRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("LectureSession not found"));
    }

    @Override
    public List<LectureSession> getAll() {
        return lectureSessionRepository.findAll();
    }

    @Override
    public Optional<LectureSession> getByQrToken(String qrToken) {
        return lectureSessionRepository.findByQrToken(qrToken);
    }

    @Override
    public LectureSession findById(Long id) {
        return null;
    }
}

