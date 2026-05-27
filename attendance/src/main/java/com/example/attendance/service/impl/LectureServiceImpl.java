package com.example.attendance.service.impl;

import com.example.attendance.model.Lecture;
import com.example.attendance.repository.LectureRepository;
import com.example.attendance.service.LectureService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LectureServiceImpl implements LectureService {

    private final LectureRepository lectureRepository;

    @Override
    public Lecture createLecture(Lecture lecture) {
        return lectureRepository.save(lecture);
    }

    @Override
    public List<Lecture> getAllLectures() {
        return lectureRepository.findAll();
    }

    @Override
    public Lecture getLectureById(Long id) {
        return lectureRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Lecture not found"));
    }

    @Override
    public Lecture updateLecture(Long id, Lecture lecture) {
        Lecture existing = getLectureById(id);

        existing.setSubjectName(lecture.getSubjectName());
        existing.setProfessorName(lecture.getProfessorName());

        return lectureRepository.save(existing);
    }

    @Override
    public void deleteLecture(Long id) {
        lectureRepository.deleteById(id);
    }
}
