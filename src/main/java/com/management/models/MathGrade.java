package com.management.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;


import jakarta.persistence.*;

@Entity
@Table(name = "math_grade")
public class MathGrade implements Grade{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column(name="student_id")
    private int studentId;

    @Column(name="grade")
    private double grade;

    public MathGrade() {
    }

    public MathGrade(double grade) {
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId){this.studentId=studentId;}

    @Override
    public double getGrade() {
        return grade;
    }

    @Override
    public void setGrade(double grade) {
        this.grade = grade;
    }
}
