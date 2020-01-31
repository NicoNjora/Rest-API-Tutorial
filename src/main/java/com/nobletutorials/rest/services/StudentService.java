package com.nobletutorials.rest.services;

import com.nobletutorials.rest.models.Student;

import java.util.List;

public interface StudentService {

    List<Student> findAll();

    Student findById(Long id);

    void delete(Long id);

    Student createStudent(Student student);

    Student update(Long id, Student student);
}