package com.microservice.student.service;

import com.microservice.student.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
public interface IStudentService {

    List<Student> findAll();

    Optional<Student> findById(Long id);

    Student create(Student student);

    List<Student> findByCourseId(Long courseId);

    void delete(Student student);





}
