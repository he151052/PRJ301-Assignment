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
public class AccountDBContext extends DBContext{
    public Account getByUsernamePassword(String user, String pass) {
        try {
            String sql = "SELECT a.username,ISNULL(r.rid,-1) as rid ,r.rname, ISNULL(f.fid,-1) AS fid,f.fname,f.url\n"
                    + "FROM Account a LEFT JOIN Role_Account ra ON a.username = ra.username\n"
                    + "						LEFT JOIN [Role] r ON r.rid = ra.rid\n"
                    + "						LEFT JOIN [Role_Feature] rf ON rf.rid = r.rid\n"
                    + "						LEFT JOIN Feature f ON f.fid = rf.fid\n"
                    + "WHERE a.username = ? AND a.password = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, user);
            stm.setString(2, pass);
            ResultSet rs = stm.executeQuery();
            Account account = null;
            Role currentRole = new Role();
            currentRole.setRid(-1);
            
            Feature currentFeature = new Feature();
            currentFeature.setFid(-1);
            
            while (rs.next()) {
                if (account == null) {
                    account = new Account();
                    
                    account.setUsername(user);
                }
                int rid = rs.getInt("rid");
                if(rid!=-1)
                {
                    if(rid != currentRole.getRid())
                    {
                        currentRole = new Role();
                        currentRole.setRid(rid);
                        currentRole.setName(rs.getString("rname"));
                        account.getRoles().add(currentRole);
                    }
                }
                
                int fid = rs.getInt("fid");
                if(fid != -1)
                {
                    if(fid != currentFeature.getFid())
                    {
                        currentFeature = new Feature();
                        currentFeature.setFid(fid);
                        currentFeature.setName(rs.getString("fname"));
                        currentFeature.setUrl(rs.getString("url"));
                        currentRole.getFeatures().add(currentFeature);
                    }
                }

            }
            return account;
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
