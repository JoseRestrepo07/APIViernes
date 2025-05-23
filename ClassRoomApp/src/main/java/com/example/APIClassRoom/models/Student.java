package com.example.APIClassRoom.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_student")
    private Integer id;
    @OneToOne
    @JoinColumn(name = "fk_user", referencedColumnName = "id_user", nullable = false)
    @JsonManagedReference(value = "student-user")
    private User user;
    @Column(name = "grade", nullable = false)
    private Integer grade;
    @Column(name = "born_date", nullable = false)
    private String bornDate;
    @Column(name = "direction", nullable = false, length = 255)
    private String direction;
    @OneToMany(mappedBy = "student")
    @JsonBackReference(value = "student-attendance")
    private List<Attendance> attendances;
    @OneToMany(mappedBy = "student")
    @JsonBackReference(value = "student-grade")
    private List<Grade> grades;
    @OneToMany(mappedBy = "student")
    @JsonBackReference(value = "student-inscription")
    private List<Inscription> inscriptions;

    public Student(){}

    public Student(Integer id, User user, Integer grade, String bornDate, String direction) {
        this.id = id;
        this.user = user;
        this.grade = grade;
        this.bornDate = bornDate;
        this.direction = direction;
    }

    public Integer getId() { return id;}
    public void setId(Integer id) { this.id = id; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public Integer getGrade() { return grade; }
    public void setGrade(Integer grade) { this.grade = grade; }

    public String getBornDate() { return bornDate; }
    public void setBornDate(String bornDate) { this.bornDate = bornDate; }

    public String getDirection() { return direction; }
    public void setDirection(String direction) { this.direction = direction; }
}
