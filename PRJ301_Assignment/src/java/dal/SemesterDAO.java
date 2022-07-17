/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Assesment;
import model.Course;
import model.Grade;
import model.Semester;

/**
 *
 * @author oki
 */
public class SemesterDAO extends DBContext {

    public ArrayList<Semester> getSemseter() {
        ArrayList<Semester> list = new ArrayList<>();
        try {
            String sql = "select * from Semester";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Semester se = new Semester();
                se.setSeid(rs.getInt("seid"));
                se.setName(rs.getString("name"));
                list.add(se);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SemesterDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public Semester getSemesterById(int seid) {
        try {
            String sql = "select * from Semester where seid = ? ";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, seid);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Semester se = new Semester();
                se.setSeid(rs.getInt("seid"));
                se.setName(rs.getString("name"));
                return se;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SemesterDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Course> getCourseBySeid(int seid) {
        ArrayList<Course> lc = new ArrayList<>();
        try {
            String sql = "select * from Course "
                    + "where seid = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, seid);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Course c = new Course();
                c.setCid(rs.getInt("cid"));
                c.setcName(rs.getString("cname"));

                Semester se = getSemesterById(rs.getInt("seid"));
                c.setSe(se);
                c.setCredit(rs.getInt("credit"));
                lc.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SemesterDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lc;
    }

    public Course getCourseById(int cid) {

        try {
            String sql = "select * from Course where cid = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, cid);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Course c = new Course();
                c.setCid(rs.getInt("cid"));
                c.setcName(rs.getString("cname"));
                c.setCredit(rs.getInt("credit"));
                Semester se = getSemesterById(rs.getInt("seid"));
                c.setSe(se);
                return c;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SemesterDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Assesment> getAssesmentByCID(int cid) {
        ArrayList<Assesment> ass = new ArrayList<>();
        try {
            String sql = "Select * from Assesment a\n"
                    + "Inner Join Course c\n"
                    + "ON a.cid = c.cid\n"
                    + "inner join Grade g\n"
                    + "on a.aid = g.aid\n"
                    + "where c.[cid] = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, cid);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Assesment a = new Assesment();
                a.setAid(rs.getInt("aid"));
                a.setName(rs.getString("name"));
                a.setWeight(rs.getDouble("weight"));
                Course c = getCourseById(rs.getInt("cid"));
                a.setCourse(c);
                Grade g = new Grade();
                g.setGrade(rs.getDouble("grade"));
                a.setGrade(g);
                ass.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SemesterDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ass;
    }

    public ArrayList<Semester> getTranscript() {
        ArrayList<Semester> list = new ArrayList<>();
        try {
            String sql = "select ROW_NUMBER() over (order by s.seid asc) as  [no],"
                    + "s.seid, s.[name],c.cid, c.[cname],c.credit from [Semester] s inner join Course c\n"
                    + "on s.seid = c.seid ";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Semester se = new Semester();
                se.setNo(rs.getInt("no"));
                se.setSeid(rs.getInt("seid"));
                se.setName(rs.getString("name"));
                Course c = getCourseById(rs.getInt("cid"));
                se.setCourse(c);
                list.add(se);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SemesterDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public ArrayList<Course> getCourse() {
        ArrayList<Course> list = new ArrayList<>();
        try {
            String sql = "select * from Course c inner join Assesment a\n"
                    + "on c.cid = a.cid inner join Grade g on a.aid = g.aid";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Course c = new Course();
                c.setCid(rs.getInt("cid"));
                Assesment a = new Assesment();
                a.setAid(rs.getInt("aid"));
                a.setName(rs.getString("name"));
                a.setWeight(rs.getFloat("weight"));
                Grade g = new Grade();
                g.setGrade(rs.getFloat("grade"));
                a.setGrade(g);
                Course co = new Course();
                co.setCid(rs.getInt("cid"));
                a.setCourse(co);
                c.setAss(a);
                list.add(c);

            }
        } catch (SQLException ex) {
            Logger.getLogger(SemesterDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public static void main(String[] args) {
        SemesterDAO dao = new SemesterDAO();
        ArrayList<Semester> list = dao.getSemseter();
        ArrayList<Course> lc = dao.getCourseBySeid(5);
//        ArrayList<Course> cl = dao.getCourse();
//        System.out.println(lc);
//        for (Course co : cl) {
//            System.out.println(co);
//        }
//        for (Semester se: list) {
//            System.out.println(se);
//        }

//        Course a = dao.getCourseById(1);
//        System.out.println(a);
//            ArrayList<Assesment> ass = dao.getAssesmentByCID(1);
//            for(Assesment a : ass){
//                System.out.println(ass);
//            }
//        ArrayList<Semester> trans = dao.getTranscript();
//        for (Semester tran : trans) {
//            System.out.println(tran);
//        }
        ArrayList<Course> c = dao.getCourse();
        for (Course course : c) {
            System.out.println(c);
        }
    }
}
