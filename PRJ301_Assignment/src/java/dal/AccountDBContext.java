/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;
import model.Feature;
import model.Role;

/**
 *
 * @author oki
 */
public class AccountDBContext extends DBContext {

    public Account getByUsernamePassword(String user, String pass) {
        try {
            String sql = "select * from Account a inner join Role_Account ra\n"
                    + " on a.username = ra.username \n"
                    + " where a.username = ? and a.[password] = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, user);
            stm.setString(2, pass);
            ResultSet rs = stm.executeQuery();
            

            while (rs.next()) {
               Account a = new Account();
               a.setUsername(rs.getString("username"));
               
               Role r = new Role();
               r.setRid(rs.getInt("rid"));
               a.setRole(r);
               return a;

            }
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void main(String[] args) {
        AccountDBContext dao = new AccountDBContext();
        Account a = dao.getByUsernamePassword("he151052", "he151052");
        System.out.println(a);

    }
}
