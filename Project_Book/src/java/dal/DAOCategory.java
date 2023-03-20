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
import model.Category;

/**
 *
 * @author TrongHoa
 */
public class DAOCategory extends DBContext {

    public List<Category> getAllCate() {
        List<Category> list = new ArrayList<>();
        String sql = "select * from category";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Category(rs.getInt("categoryID"), rs.getString("name"), rs.getString("image")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public void addCate(String cate, String img) {
        String sql = "INSERT INTO [dbo].[Category]\n"
                + "           ([Name]\n"
                + "           ,[Image])\n"
                + "     VALUES\n"
                + "           (?, ?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, cate);
            st.setString(2, img);
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteCate(int id) {
        String sql = "delete from Category where categoryID = " + id;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Category getCate(int id) {
        String sql = "select * from category where categoryID = " + id;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new Category(rs.getInt("categoryID"), rs.getString("name"), rs.getString("image"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void main(String[] args) {
        DAOCategory dal = new DAOCategory();
        System.out.println(dal.getCate(3).getName());
    }

    public void updateCate(int cateId, String name, String image) {
        String sql = "UPDATE [dbo].[Category]\n"
                + "   SET [Name] = ?\n"
                + "      ,[Image] = ?\n"
                + " WHERE CategoryID = " + cateId;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, name);
            st.setString(2, image);
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
