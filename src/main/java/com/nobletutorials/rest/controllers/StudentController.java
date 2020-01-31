package com.nobletutorials.rest.controllers;

import com.nobletutorials.rest.models.Student;
import com.nobletutorials.rest.services.StudentService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> findAll(){
        return studentService.findAll();
    }

    @GetMapping(value = "{id}")
    public Student findById(@PathVariable Long id){
        return studentService.findById(id);
    }

    @PostMapping
    public Student createStudent(@Validated(Student.Create.class)
            @RequestBody Student student){
        return studentService.createStudent(student);
    }

    @DeleteMapping(value = "{id}")
    public void deleteStudent(@PathVariable Long id){
        studentService.delete(id);
    }

//    No need of validating presence of id as it required as part of the url
    @PatchMapping(value = "{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student){
        return studentService.update(id, student);
    }
}