package com.nobletutorials.rest.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "universities")
public class University {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @NotNull(groups = Create.class)
    @Column(name = "name")
    private String name;

    @NotNull(groups = Create.class)
    @Column(name = "location")
    private String location;

    @Column(name = "year_founded")
    private String yearFounded;

    @OneToMany(mappedBy = "university")
    private List<Student> students;

    public University(String name, String location){
        this.name = name;
        this.location = location;
    }

    public University(){}

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getYearFounded() {
        return yearFounded;
    }

    public void setYearFounded(String yearFounded) {
        this.yearFounded = yearFounded;
    }

    public interface Update{}

    public interface Create{}
}
