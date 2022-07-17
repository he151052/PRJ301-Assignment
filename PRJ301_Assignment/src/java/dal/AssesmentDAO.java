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

/**
 *
 * @author oki
 */
public class AssesmentDAO extends DBContext {

    public Assesment getProduct(String cid) {
        
        try {
            String sql = "Select * from Assesment a inner join Course c on a.cid = c.cid\n"
                    + "inner join Grade g on a.aid = g.aid where c.cid = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, cid);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Assesment a = new Assesment();
                a.setAid(rs.getInt("aid"));
                a.setName(rs.getString("name"));
                a.setWeight(rs.getDouble("weight"));

                Course c = new Course();
                c.setCid(rs.getInt("cid"));
                c.setcName(rs.getString("cname"));
                a.setCourse(c);

                Grade g = new Grade();
                g.setGrade(rs.getDouble("grade"));
                a.setGrade(g);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(SemesterDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Assesment> assesment() {
        ArrayList<Assesment> list = new ArrayList<>();
        try {
            String sql = "Select * from Assesment a inner join Course c on a.cid = c.cid\n"
                    + "inner join Grade g on a.aid = g.aid ";
            PreparedStatement stm = connection.prepareStatement(sql);
            
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Assesment a = new Assesment();
                a.setAid(rs.getInt("aid"));
                a.setName(rs.getString("name"));
                a.setWeight(rs.getDouble("weight"));

                Course c = new Course();
                c.setCid(rs.getInt("cid"));
                c.setcName(rs.getString("cname"));
                a.setCourse(c);

                Grade g = new Grade();
                g.setGrade(rs.getFloat("grade"));
                a.setGrade(g);
                list.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SemesterDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public static void main(String[] args) {
        AssesmentDAO dao = new AssesmentDAO();
        ArrayList<Assesment> trans = dao.assesment();
        for (Assesment a : trans) {
            System.out.println(a);
        }
    }
}
