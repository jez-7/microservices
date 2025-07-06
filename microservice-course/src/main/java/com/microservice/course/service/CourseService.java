package com.microservice.course.service;

import com.microservice.course.entity.Course;
import com.microservice.course.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService implements ICourseService {

    @Autowired
    private CourseRepository repo;
    @Override
    public List<Course> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<Course> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public Course create(Course course) {
        return repo.save(course);
    }
}
