/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Group;
import model.Student;

/**
 *
 * @author oki
 */
public class GroupDAO extends DBContext {

    public ArrayList<Group> getGroupByL(String username) {
        ArrayList<Group> list = new ArrayList<>();
        try {
            String sql = " select * from [Group] g inner join G_Lecturer gl\n"
                    + " on g.gid = gl.gid\n"
                    + " inner join Lecturer l\n"
                    + " on l.lid = gl.lid where l.username = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, username);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Group g = new Group();
                g.setGid(rs.getInt("gid"));
                g.setName(rs.getString("name"));

                list.add(g);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GroupDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public ArrayList<Group> getGroup() {
        ArrayList<Group> list = new ArrayList<>();
        try {
            String sql = " select * from [Group] g ";
            PreparedStatement stm = connection.prepareStatement(sql);

            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Group g = new Group();
                g.setGid(rs.getInt("gid"));
                g.setName(rs.getString("name"));

                list.add(g);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GroupDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public ArrayList<Student> getStudent(int gid ) {
        ArrayList<Student> list = new ArrayList<>();
        try {
            String sql = " Select * from [Group] g\n"
                    + "inner join G_Student gs on g.gid = gs.gid\n"
                    + "inner join Studentt s on s.[Sid] = gs.[sid]\n"
                    + "where g.[gid] = ? ";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, gid);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Student s = new Student();
                s.setSid(rs.getString("Sid"));
                s.setName(rs.getString("Name"));
                Group g = new Group();
                g.setGid(rs.getInt("gid"));
                g.setName(rs.getString("name"));
                s.setGroup(g);
                list.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GroupDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public static void main(String[] args) {
        GroupDAO dao = new GroupDAO();
        ArrayList<Group> list = dao.getGroupByL("sonnt5");
        ArrayList<Group> g = dao.getGroup();
        ArrayList<Student> s = dao.getStudent(1);
        for (Student group : s) {
            System.out.println(group);
        }

    }
}
