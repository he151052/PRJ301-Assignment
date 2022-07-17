/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;



/**
 *
 * @author oki
 */
public class Course {
    private int cid;
    private String cName;
    private Semester se;
    private Assesment ass;

    public Assesment getAss() {
        return ass;
    }

    public void setAss(Assesment ass) {
        this.ass = ass;
    }
    private int credit;
   


    public Course() {
    }

    public Course(int cid, String cName, Semester se, int credit) {
        this.cid = cid;
        this.cName = cName;
        this.se = se;
        this.credit = credit;
    }

    

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

   

    public Semester getSe() {
        return se;
    }

    public void setSe(Semester se) {
        this.se = se;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    @Override
    public String toString() {
        return "Course{" + "cid=" + cid + ", name=" + cName + ", se=" + se + ", credit=" + credit + ", ass "+ass +'}' +"\n";
    }
    
}
