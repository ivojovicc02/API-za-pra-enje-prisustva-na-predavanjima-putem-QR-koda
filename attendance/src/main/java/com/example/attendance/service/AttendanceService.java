package com.example.attendance.service;

import com.example.attendance.model.Attendance;
import java.util.List;

public interface AttendanceService {

    void scan(String qrToken);

    Attendance create(Attendance a);
    List<Attendance> getAll();
    Attendance getById(Long id);
    Attendance update(Long id, Attendance a);
    void delete(Long id);

    List<Attendance> getBySession(Long sessionId);
}