package com.example.attendance.repository;

import com.example.attendance.model.Attendance;
import com.example.attendance.model.LectureSession;
import com.example.attendance.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    boolean existsByStudentAndSession(Student student, LectureSession session);
}

