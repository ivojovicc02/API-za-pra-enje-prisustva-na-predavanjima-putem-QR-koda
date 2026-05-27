package com.example.attendance.service.impl;

import com.example.attendance.model.*;
import com.example.attendance.repository.*;
import com.example.attendance.service.AttendanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AttendanceServiceImpl implements AttendanceService {

    private final StudentRepository studentRepository;
    private final LectureSessionRepository lectureSessionRepository;
    private final AttendanceRepository attendanceRepository;
    private final UserRepository userRepository;

    @Override
    public void scan(String qrToken) {

        String username = SecurityContextHolder.getContext()
                .getAuthentication()
                .getName();

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Student student = studentRepository.findByUser(user)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        LectureSession session = lectureSessionRepository
                .findByQrToken(qrToken)
                .orElseThrow(() -> new RuntimeException("Invalid QR token"));

        if (session.getQrExpiresAt().isBefore(LocalDateTime.now())) {
            throw new RuntimeException("QR code expired");
        }

        if (attendanceRepository.existsByStudentAndLectureSession(student, session)) {
            throw new RuntimeException("Already scanned");
        }

        Attendance attendance = new Attendance();
        attendance.setStudent(student);
        attendance.setLectureSession(session);
        attendance.setScannedAt(LocalDateTime.now());

        attendanceRepository.save(attendance);
    }

    // ostalo zasad prazno
    @Override public Attendance create(Attendance a) { return null; }
    @Override public List<Attendance> getAll() { return null; }
    @Override public Attendance getById(Long id) { return null; }
    @Override public Attendance update(Long id, Attendance a) { return null; }
    @Override public void delete(Long id) {}
    @Override public List<Attendance> getBySession(Long sessionId) { return null; }
}