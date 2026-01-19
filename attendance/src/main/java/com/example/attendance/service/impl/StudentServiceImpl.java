package com.example.attendance.service.impl;

import com.example.attendance.dto.StudentRequestDTO;
import com.example.attendance.dto.StudentResponseDTO;
import com.example.attendance.service.StudentService;
import lombok.RequiredArgsConstructor;
import com.example.attendance.model.Student;
import org.springframework.stereotype.Service;
import com.example.attendance.repository.StudentRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public StudentResponseDTO create(StudentRequestDTO dto) {
        Student student = new Student();
        student.setName(dto.name());
        student.setEmail(dto.email());

        Student saved = studentRepository.save(student);
        return new StudentResponseDTO(saved.getId(), saved.getName(), saved.getEmail());
    }

    @Override
    public List<StudentResponseDTO> findAll() {
        return studentRepository.findAll()
                .stream()
                .map(s -> new StudentResponseDTO(s.getId(), s.getName(), s.getEmail()))
                .toList();
    }

    @Override
    public StudentResponseDTO findById(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        return new StudentResponseDTO(student.getId(), student.getName(), student.getEmail());
    }

    @Override
    public StudentResponseDTO update(Long id, StudentRequestDTO dto) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        student.setName(dto.name());
        student.setEmail(dto.email());

        Student updated = studentRepository.save(student);
        return new StudentResponseDTO(updated.getId(), updated.getName(), updated.getEmail());
    }

    @Override
    public void delete(Long id) {
        studentRepository.deleteById(id);
    }
}
