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
    private int seid;
    private String name;
    ArrayList<Course> c = new ArrayList<>();

    public ArrayList<Course> getC() {
        return c;
    }

    public void setC(ArrayList<Course> c) {
        this.c = c;
    }
    
    public Semester() {
    }

    public Semester(int seid, String name) {
        this.seid = seid;
        this.name = name;
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
        return "Semester{" + "seid=" + seid + ", name=" + name + '}';
    }
    
}
