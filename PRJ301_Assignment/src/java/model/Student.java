/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author oki
 */
public class Student {
    private String sid;
    private String name; 
    private Group group;

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" + "sid=" + sid + ", name=" + name + ", group=" + group + '}';
    }

    public Student(String sid, String name, Group group) {
        this.sid = sid;
        this.name = name;
        this.group = group;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
    
}
