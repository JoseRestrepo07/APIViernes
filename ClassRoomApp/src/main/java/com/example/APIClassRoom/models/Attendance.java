package com.example.APIClassRoom.models;

import com.example.APIClassRoom.helpers.AttendanceStatus;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "attendances")
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_attendance")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "fk_student", referencedColumnName = "id_student", nullable = false)
    @JsonManagedReference(value = "student-attendance")
    private Student student;
    @ManyToOne
    @JoinColumn(name = "fk_course", referencedColumnName = "id_course", nullable = false)
    @JsonManagedReference(value = "course-attendance")
    private Course course;
    @Column(nullable = false)
    private LocalDate date;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AttendanceStatus status;

    public Attendance (){}

    public Attendance (Integer id, Student student, Course course, LocalDate date, AttendanceStatus status){
        this.id = id;
        this.student = student;
        this.status = status;
        this.course = course;
        this.date = date;
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

    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }

    public AttendanceStatus getStatus() {
        return status;
    }
    public void setStatus(AttendanceStatus status) {
        this.status = status;
    }
}
