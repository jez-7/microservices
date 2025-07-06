package com.microservice.student.controller;

import com.microservice.student.entity.Student;
import com.microservice.student.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    @Autowired
    private IStudentService service;

    @GetMapping
    ResponseEntity<List<Student>> findAll() {
        List<Student> student = service.findAll();
        return ResponseEntity.ok(student);
    }

    @GetMapping("/{id}")
    ResponseEntity<?> findById (@PathVariable Long id) {
        Optional<Student> student = service.findById(id);
        return ResponseEntity.ok(student);
    }

    @PostMapping
    ResponseEntity<?> create (@RequestBody Student student) {
        Student s = service.create(student);
        return new ResponseEntity<>(s, HttpStatus.CREATED);

    }




}
