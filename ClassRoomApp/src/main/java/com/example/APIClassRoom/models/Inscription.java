package com.example.APIClassRoom.models;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table(name = "inscriptions")
public class Inscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_inscription")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "fk_student", referencedColumnName = "id_student", nullable = false)
    @JsonManagedReference(value = "student-inscription")
    private Student student;
    @ManyToOne
    @JoinColumn(name = "fk_course", referencedColumnName = "id_course", nullable = false)
    @JsonManagedReference(value = "course-inscription")
    private Course course;
    @Column(name = "inscription_date", nullable = false)
    private String inscriptionDate;

    public Inscription(){}

    public Inscription(Integer id, Student student, Course course, String inscriptionDate) {
        this.id = id;
        this.student = student;
        this.course = course;
        this.inscriptionDate = inscriptionDate;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }
    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }
    public void setCourse(Course course) {
        this.course = course;
    }

    public String getInscriptionDate() {
        return inscriptionDate;
    }
    public void setInscriptionDate(String inscriptionDate) {
        this.inscriptionDate = inscriptionDate;
    }
}
