package com.nobletutorials.rest.services;

import com.nobletutorials.rest.NotFoundException;
import com.nobletutorials.rest.models.Student;
import com.nobletutorials.rest.models.University;
import com.nobletutorials.rest.repositories.UniversityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversityServiceImpl implements UniversityService {

    private final UniversityRepository universityRepository;
    private final StudentService studentService;

    public UniversityServiceImpl(UniversityRepository universityRepository, StudentService studentService  ) {
        this.universityRepository = universityRepository;
        this.studentService = studentService;
    }

    @Override
    public List<University> findAll() {
        return universityRepository.findAll();
    }

    @Override
    public University findById(Long id) {
        return universityRepository.findById(id).orElseThrow(()-> new NotFoundException("No university with id " +id +" found"));
    }

    @Override
    public void delete(Long id){
        universityRepository.deleteById(id);
    }

    @Override
    public University createUniversity(University university) {
        return universityRepository.save(university);
    }

    @Override
    public University update(Long id, University university) {
        University found = findById(id);
        found.setLocation(university.getLocation());
        found.setYearFounded(university.getYearFounded());
        found.setName(university.getName());
        return universityRepository.save(found);
    }

    @Override
    public Student createStudent(Long universityId, Student student) {
        University university = findById(universityId);
        student.setUniversity(university);
        return studentService.createStudent(student);
    }
}
