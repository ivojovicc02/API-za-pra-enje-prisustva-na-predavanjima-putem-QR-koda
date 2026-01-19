package com.example.attendance.service;

import com.example.attendance.dto.StudentRequestDTO;
import com.example.attendance.dto.StudentResponseDTO;

import java.util.List;

public interface StudentService {
    StudentResponseDTO create(StudentRequestDTO dto);
    List<StudentResponseDTO> findAll();
    StudentResponseDTO findById(Long id);
    StudentResponseDTO update(Long id, StudentRequestDTO dto);
    void delete(Long id);
}
