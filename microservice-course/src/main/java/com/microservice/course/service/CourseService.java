package com.microservice.course.service;

import com.microservice.course.client.StudentClient;
import com.microservice.course.dto.StudentDTO;
import com.microservice.course.entity.Course;
import com.microservice.course.http.response.StudentsByCourseResponse;
import com.microservice.course.repository.CourseRepository;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService implements ICourseService {

    @Autowired
    private CourseRepository repo;

    @Autowired
    private StudentClient client;
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

    @Override
    public StudentsByCourseResponse findStudentsByCourseId(Long courseId) {

        Course course = repo.findById(courseId).orElseThrow();

        List<StudentDTO> studentDTOList = client.findAllStudentsByCourse(courseId);

        return  StudentsByCourseResponse.builder()
                .courseName(course.getName())
                .teacher(course.getTeacher())
                .studentDTOList(studentDTOList)
                .build();
    }
}
