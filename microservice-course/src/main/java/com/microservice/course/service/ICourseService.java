package com.microservice.course.service;

import com.microservice.course.entity.Course;
import com.microservice.course.http.response.StudentsByCourseResponse;

import java.util.List;
import java.util.Optional;

public interface ICourseService {

    List<Course> findAll();
    Optional<Course> findById(Long id);
    Course create(Course course);

    StudentsByCourseResponse findStudentsByCourseId(Long courseId);




}
