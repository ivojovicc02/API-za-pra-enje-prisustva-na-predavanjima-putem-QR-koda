package com.example.attendance.service.impl;

import com.example.attendance.service.AttendanceService;
import lombok.RequiredArgsConstructor;
import com.example.attendance.model.Attendance;
import com.example.attendance.model.LectureSession;
import com.example.attendance.model.Student;
import org.springframework.stereotype.Service;
import com.example.attendance.repository.AttendanceRepository;
import com.example.attendance.repository.LectureSessionRepository;
import com.example.attendance.repository.StudentRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AttendanceServiceImpl implements AttendanceService {

    private final StudentRepository studentRepository;
    private final LectureSessionRepository lectureSessionRepository;
    private final AttendanceRepository attendanceRepository;

    @Override
    public Attendance create(Attendance a) {
        return null;
    }

    @Override
    public List<Attendance> getAll() {
        return null;
    }

    @Override
    public Attendance getById(Long id) {
        return null;
    }

    @Override
    public Attendance update(Long id, Attendance a) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void scan(Long studentId, String qrToken) {

        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        LectureSession session = lectureSessionRepository.findByQrToken(qrToken)
                .orElseThrow(() -> new RuntimeException("Invalid QR code"));

        Attendance attendance = new Attendance();
        attendance.setStudent(student);
        attendance.setLectureSession(session);

        attendanceRepository.save(attendance);
    }
}
