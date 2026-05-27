package com.example.attendance.service;

import com.example.attendance.model.Lecture;

import java.util.List;

public interface LectureService {

    Lecture createLecture(Lecture lecture);

    List<Lecture> getAllLectures();

    Lecture getLectureById(Long id);

    Lecture updateLecture(Long id, Lecture lecture);

    void deleteLecture(Long id);


}
