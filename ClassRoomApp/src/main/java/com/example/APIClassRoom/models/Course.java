package com.example.APIClassRoom.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_course")
    private Integer id;
    private String name;
    @ManyToOne
    @JoinColumn(name="fk_teacher", referencedColumnName = "id_teacher")
    @JsonBackReference(value = "teacher-course")
    Teacher teacher;
    @OneToMany(mappedBy = "course")
    @JsonBackReference(value = "course-attendance")
    private List<Attendance> attendances;
    @OneToMany(mappedBy = "course")
    @JsonBackReference(value = "course-subject")
    private List<Subject> subjects;
    @OneToMany(mappedBy = "course")
    @JsonBackReference(value = "course-inscription")
    private List<Inscription> inscriptions;
    public Course() {
    }

    public Course(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
