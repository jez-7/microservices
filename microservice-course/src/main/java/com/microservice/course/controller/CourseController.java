package com.microservice.course.controller;

import com.microservice.course.entity.Course;
import com.microservice.course.service.ICourseService;
import com.netflix.discovery.converters.Auto;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("api/v1/courses")
@RestController
public class CourseController {
    @Autowired
    private ICourseService service;
    @GetMapping
    ResponseEntity<List<Course>> findAll() {
        List<Course> c = service.findAll();
        return ResponseEntity.ok(c);
    }
    @GetMapping("/{id}")
    ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Course> c = service.findById(id);
        return ResponseEntity.ok(c);
    }
    @PostMapping
    ResponseEntity<?> create(@RequestBody Course course) {
        Course c = service.create(course);
        return new ResponseEntity<>(c, HttpStatus.CREATED);
    }

    @GetMapping("/search-student/{courseId}")
    public ResponseEntity<?> findStudentsByCourseId(@PathVariable Long courseId) {
        return ResponseEntity.ok(service.findStudentsByCourseId(courseId));
    }




}
