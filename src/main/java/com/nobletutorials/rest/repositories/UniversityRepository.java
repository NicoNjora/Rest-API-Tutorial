package com.nobletutorials.rest.repositories;

import com.nobletutorials.rest.models.University;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UniversityRepository extends JpaRepository<University, Long> {
}
