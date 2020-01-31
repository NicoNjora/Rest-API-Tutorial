package com.nobletutorials.rest.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull(groups = Update.class)
    @Column(name = "id")
    private Long id;

    @NotNull(groups = Create.class)
    @Column(name = "first_name")
    private String firstName;

    @NotNull(groups = Create.class)
    @Column(name = "last_name")
    private String lastName;

    @Column(name = "dob")
    private Date dob;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "university_id")
    private University university;

    public Student(String firstName, String lastName, University university) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.university = university;
    }

    public Student() {}

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public interface Update{}

    public interface Create{}
}
