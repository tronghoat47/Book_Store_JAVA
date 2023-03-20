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

/**
 *
 * @author TrongHoa
 */
public class DAOAuth extends DBContext{

    public Account checkAccount(String username, String password) {
        String sql = "select * from Account where username = '"+username+"' and password ='"+password+"'" ;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                return new Account(rs.getString("username"), rs.getString("password"), rs.getInt("role"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOAuth.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static void main(String[] args) {
        DAOAuth d = new DAOAuth();
        System.out.println(d.checkAccount("anhthang", "anhtu").getPassword());
    }

    public boolean register(String username, String password, int role) {
        String sql1 = "select * from Account where UserName='"+username+"'";
        try {
            PreparedStatement st = connection.prepareStatement(sql1);
            ResultSet rs = st.executeQuery();
            if(rs.next())
                return false;
        } catch (SQLException ex) {
            Logger.getLogger(DAOAuth.class.getName()).log(Level.SEVERE, null, ex);
        }
        String sql = "insert into Account values (?, ?, ?) ";
        if(role==1)
            sql += "insert into Admin(UserName) values ('"+username+"')";
        if(role==0)
            sql += "insert into Customer(UserName) values ('"+username+"')";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
            st.setString(2, password);
            st.setInt(3, role);
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOAuth.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    public boolean forget(String username, String password) {
        String sql = "update Account set Password = ? where UserName = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, password);
            st.setString(2, username);
            if(st.executeUpdate()==0)
                return false;
        } catch (SQLException ex) {
            Logger.getLogger(DAOAuth.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

}
