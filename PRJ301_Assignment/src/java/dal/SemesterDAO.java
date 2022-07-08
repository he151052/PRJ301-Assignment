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
import model.Course;
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
                
                Semester se = new Semester();
                se.setSeid(rs.getInt("seid"));
                se.setName(rs.getString("cname"));
               c.setSe(se);
                c.setCredit(rs.getInt("credit"));
                lc.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SemesterDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lc;
    }

    public ArrayList<Course> getCourse() {
        ArrayList<Course> lc = new ArrayList<>();
        try {
            String sql = "select * from Course";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Course c = new Course();
                c.setCid(rs.getInt("cid"));
                c.setcName(rs.getString("cname"));
                Semester s = new Semester();
                s.setSeid(rs.getInt("seid"));
                s.setName(rs.getString("cname"));
                c.setSe(s);
                c.setCredit(rs.getInt("credit"));
                lc.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SemesterDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lc;
    }
    
    

    public static void main(String[] args) {
        SemesterDAO dao = new SemesterDAO();
        ArrayList<Semester> list = dao.getSemseter();
        ArrayList<Course> lc = dao.getCourseBySeid(1);
        ArrayList<Course> cl = dao.getCourse();
        System.out.println(lc);
        for (Course co : cl) {
            System.out.println(co);
        }
//        for (Semester se: list) {
//            System.out.println(se);
//        }
    }
}
