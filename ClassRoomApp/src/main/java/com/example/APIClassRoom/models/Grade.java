package com.example.APIClassRoom.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "grades")
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_grade")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "fk_student", referencedColumnName = "id_student", nullable = false)
    @JsonManagedReference(value = "student-grade")
    private Student student;
    @ManyToOne
    @JoinColumn(name = "fk_subject", referencedColumnName = "id_subject", nullable = false)
    @JsonManagedReference(value = "subject-grade")
    private Subject subject;
    @Column(nullable = false)
    private Double score;
    @Column(name = "evaluation_date", nullable = false)
    private LocalDate evaluationDate;

    public Grade (){

    }

    public Grade (Integer id, Student student, Subject subject, Double score, LocalDate evaluationDate){
        this.id = id;
        this.student = student;
        this.subject = subject;
        this.score = score;
        this.evaluationDate = evaluationDate;
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

    public Subject getSubject() {
        return subject;
    }
    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Double getScore() {
        return score;
    }
    public void setScore(Double score) {
        this.score = score;
    }

    public LocalDate getEvaluationDate() {
        return evaluationDate;
    }
    public void setEvaluationDate(LocalDate evaluationDate) {
        this.evaluationDate = evaluationDate;
    }
}
