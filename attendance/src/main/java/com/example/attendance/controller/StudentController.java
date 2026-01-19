package com.example.attendance.controller;

import com.example.attendance.dto.StudentRequestDTO;
import com.example.attendance.dto.StudentResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.example.attendance.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public StudentResponseDTO create(@RequestBody @Valid StudentRequestDTO dto) {
        return studentService.create(dto);
    }

    @GetMapping
    public List<StudentResponseDTO> findAll() {
        return studentService.findAll();
    }

    @GetMapping("/{id}")
    public StudentResponseDTO findById(@PathVariable Long id) {
        return studentService.findById(id);
    }

    @PutMapping("/{id}")
    public StudentResponseDTO update(@PathVariable Long id,
                                     @RequestBody @Valid StudentRequestDTO dto) {
        return studentService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        studentService.delete(id);
    }
}