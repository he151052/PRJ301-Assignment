/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author oki
 */
public class Semester {
    private int no;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }
    private int seid;
    private String name;
   private Course course;

    public Semester(int no,int seid, String name, Course course) {
        this.no = no;
        this.seid = seid;
        this.name = name;
        this.course = course;
    }
    
    public Semester() {
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    

    public int getSeid() {
        return seid;
    }

    public void setSeid(int seid) {
        this.seid = seid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Semester{" + "seid=" + seid + ", name=" + name + ", course=" + course + '}';
    }

    
    
}
