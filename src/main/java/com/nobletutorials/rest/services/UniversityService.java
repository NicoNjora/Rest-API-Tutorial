package com.nobletutorials.rest.services;

import com.nobletutorials.rest.models.University;

import java.util.List;

public interface UniversityService {

    List<University> findAll();

    University findById(Long id);

    void delete(Long id);

    University createUniversity(University university);

    University update(Long id, University university);
}
