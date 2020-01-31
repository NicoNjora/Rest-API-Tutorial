package com.nobletutorials.rest.services;

import com.nobletutorials.rest.NotFoundException;
import com.nobletutorials.rest.models.Student;
import com.nobletutorials.rest.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(Long id) {
        return studentRepository.findById(id).orElseThrow(()-> new NotFoundException("No student with id " +id +" found"));
    }

    @Override
    public void delete(Long id){
        studentRepository.deleteById(id);
    }

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student update(Long id, Student student) {
        Student found = findById(id);
        found.setDob(student.getDob());
        found.setLastName(student.getLastName());
        found.setFirstName(student.getFirstName());
        return studentRepository.save(found);
    }
}
