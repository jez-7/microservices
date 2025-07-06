package com.microservice.student.service;

import com.microservice.student.entity.Student;
import com.microservice.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements IStudentService{

    @Autowired
    private StudentRepository repo;
    @Override
    public List<Student> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<Student> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public Student create(Student student) {
        return repo.save(student);
    }

    @Override
    public List<Student> findByCourseId(Long courseId) {
        return repo.findAllByCourseId(courseId);
    }

    @Override
    public void delete(Student student) {
        repo.delete(student);
    }
}
