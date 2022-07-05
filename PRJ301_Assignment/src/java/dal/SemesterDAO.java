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
import model.Semester;

/**
 *
 * @author oki
 */
public class SemesterDAO extends DBContext{
    
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
    public static void main(String[] args) {
        SemesterDAO dao = new SemesterDAO();
        ArrayList<Semester> list = dao.getSemseter();

        for (Semester se: list) {
            System.out.println(se);
        }
    }
}
