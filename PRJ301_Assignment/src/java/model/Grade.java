/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;

/**
 *
 * @author oki
 */
public class Grade {
    private Student student;
    private Assesment assesment;
    private double grade;
    private Date date;
    private Group group;

    public Grade() {
    }

    public Grade(Student student, Assesment assesment, double grade, Date date, Group group) {
        this.student = student;
        this.assesment = assesment;
        this.grade = grade;
        this.date = date;
        this.group = group;
    }

    @Override
    public String toString() {
        return "Grade{" + "student=" + student + ", assesment=" + assesment + ", grade=" + grade + ", date=" + date + ", group=" + group + '}';
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Assesment getAssesment() {
        return assesment;
    }

    public void setAssesment(Assesment assesment) {
        this.assesment = assesment;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
    
    
    
}
