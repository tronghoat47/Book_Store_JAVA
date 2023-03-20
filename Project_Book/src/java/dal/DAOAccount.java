/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Admin;
import model.Book;
import model.Category;
import model.Customer;
import model.ListTotal;

/**
 *
 * @author TrongHoa
 */
public class DAOAccount extends DBContext {

    public Admin getAdmin(String username) {
        String sql = "select * from Admin where username = '" + username + "'";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new Admin(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOAccount.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public List<Book> getBook(int adminId) {
        List<Book> list = new ArrayList<>();
        String sql = "select b.*, avg(Rating) as Rating,  sum(Quantity) as Quantity from Book b left join [Order Detail] o \n"
                + "on b.BookID = o.BookID left join Review r on b.BookID = r.BookID group by b.BookID, b.AdminID, b.Author,\n"
                + "b.CategoryID, b.Describe, b.Discount, b.Image, b.Name, b.Price, b.ReleaseDate, b.Title having AdminID=" + adminId;

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Book(rs.getInt("bookID"), rs.getString("name"), rs.getString("title"),
                        rs.getString("describe"), rs.getString("author"), rs.getDouble("price"),
                        rs.getFloat("discount"), rs.getDate("ReleaseDate"), rs.getString("image"),
                        rs.getInt("categoryID"), rs.getInt("adminID"), rs.getInt("quantity"), rs.getInt("rating")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOBook.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public Book getBookByID(int bookId) {
        String sql = "select b.*, c.Name from Book b join Category c on b.CategoryID = c.CategoryID where BookID=" + bookId;

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDouble(6), rs.getFloat(7), rs.getDate(8), rs.getString(9), rs.getInt(10), rs.getInt(11), rs.getString(12));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOBook.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public void updateBook(int bookId, String name, String author, int cateId, String title, Double price, float discount, Date releaseDate, String describe, String image, int adminId) {
        String sql = "UPDATE [dbo].[Book]\n"
                + "   SET [Name] = ?\n"
                + "      ,[Title] = ?\n"
                + "      ,[Describe] = ?\n"
                + "      ,[Author] = ?\n"
                + "      ,[Price] = ?\n"
                + "      ,[Discount] = ?\n"
                + "      ,[ReleaseDate] = ?\n"
                + "      ,[Image] = ?\n"
                + "      ,[CategoryID] = ?\n"
                + "      ,[AdminID] = ?\n"
                + " WHERE BookID=" + bookId;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, name);
            st.setString(2, title);
            st.setString(3, describe);
            st.setString(4, author);
            st.setDouble(5, price);
            st.setFloat(6, discount);
            st.setDate(7, releaseDate);
            st.setString(8, image);
            st.setInt(9, cateId);
            st.setInt(10, adminId);
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addBook(String name, String author, int cateId, String title, Double price, float discount, Date releaseDate, String describe, String image, int adminId) {
        String sql = "INSERT INTO [dbo].[Book]\n"
                + "           ([Name]\n"
                + "           ,[Title]\n"
                + "           ,[Describe]\n"
                + "           ,[Author]\n"
                + "           ,[Price]\n"
                + "           ,[Discount]\n"
                + "           ,[ReleaseDate]\n"
                + "           ,[Image]\n"
                + "           ,[CategoryID]\n"
                + "           ,[AdminID])\n"
                + "     VALUES\n"
                + "           (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, name);
            st.setString(2, title);
            st.setString(3, describe);
            st.setString(4, author);
            st.setDouble(5, price);
            st.setFloat(6, discount);
            st.setDate(7, releaseDate);
            st.setString(8, image);
            st.setInt(9, cateId);
            st.setInt(10, adminId);
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteBook(int id) {
        String sql = "DELETE FROM [dbo].[Book]\n"
                + "      WHERE BookID=" + id;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateAdmin(int adminId, String username, String firstname, String lastname, String email, String phone, String address, String image) {
        String sql = "UPDATE [dbo].[Admin]\n"
                + "   SET [UserName] = ?\n"
                + "      ,[FirstName] = ?\n"
                + "      ,[LastName] = ?\n"
                + "      ,[Email] = ?\n"
                + "      ,[Phone] = ?\n"
                + "      ,[Address] = ?\n"
                + "      ,[Image] = ?\n"
                + " WHERE AdminID=" + adminId;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
            st.setString(2, firstname);
            st.setString(3, lastname);
            st.setString(4, email);
            st.setString(5, phone);
            st.setString(6, address);
            st.setString(7, image);
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Customer getCustomer(String username) {
        String sql = "select * from Customer where UserName='" + username + "'";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOAccount.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public void updateCustomer(int customerId, String username, String firstname, String lastname, String email, String phone, String address, String image) {
        String sql = "UPDATE [dbo].[Customer]\n"
                + "   SET [UserName] = ?\n"
                + "      ,[FirstName] = ?\n"
                + "      ,[LastName] = ?\n"
                + "      ,[Email] = ?\n"
                + "      ,[Phone] = ?\n"
                + "      ,[Address] = ?\n"
                + "      ,[Image] = ?\n"
                + " WHERE CustomerID=" + customerId;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
            st.setString(2, firstname);
            st.setString(3, lastname);
            st.setString(4, email);
            st.setString(5, phone);
            st.setString(6, address);
            st.setString(7, image);
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        DAOAccount d = new DAOAccount();
        System.out.println(d.getChart("khongbiet").get(0).getTunrover());
    }

    public List<Category> getChart(String username) {
        List<Category> list = new ArrayList<>();
        String sql = "select UserName, c.Name, sum(TotalMoney) as Turnover from Admin a join Book b on b.AdminID = a.AdminID\n"
                + "join Category c on b.CategoryID = c.CategoryID\n"
                + "join [Order Detail] o on o.BookID = b.BookID join [Book Order] bo on bo.OrderID=o.OrderID\n"
                + "group by UserName, c.Name having UserName ='" + username + "'";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Category(rs.getString(2), rs.getDouble(3)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOAccount.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public List<ListTotal> getotentialCustomer(String username, Date date) {
        List<ListTotal> list = new ArrayList<>();
        String sql = "select distinct top 3 a.UserName, c.UserName, sum(TotalMoney) as TotalMoney  from Admin a join Book b on a.AdminID = b.AdminID \n"
                + "join [Order Detail] od on od.BookID = b.BookID join [Book Order] bo on bo.OrderID = od.OrderID\n"
                + "join Customer c on c.CustomerID = bo.CustomerID\n"
                + "group by a.UserName, c.UserName having a.UserName = '" + username + "'";
        if (date != null) {
            sql += " and OrderDate >= '" + date + "'";
        }
        sql += " order by TotalMoney desc ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new ListTotal(rs.getString(1), rs.getString(2), rs.getDouble(3)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public List<ListTotal> getBookMostSaleOff(String username, Date date) {
        List<ListTotal> list = new ArrayList<>();
        String sql = "select distinct top 5 b.Image, Name, SUM(Quantity) as Quantity from Admin a join Book b on b.AdminID = a.AdminID\n"
                + "join [Order Detail] od on b.BookID = od.BookID join [Book Order] bo on bo.OrderID = od.OrderID\n"
                + "group by b.Image, Name , UserName\n"
                + "having UserName='" + username + "'";
        if (date != null) {
            sql += " and OrderDate >= '" + date + "'";
        }
        sql += " order by Quantity desc";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new ListTotal(rs.getString(1), rs.getString(2), rs.getInt(3)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public List<ListTotal> getListCustomerMostBuy(String username, Date date) {
        List<ListTotal> list = new ArrayList<>();
        String sql = "select distinct top 3  c.UserName, count(c.UserName) as Quantity from Admin a join Book b on a.AdminID = b.AdminID \n"
                + "join [Order Detail] od on od.BookID = b.BookID join [Book Order] bo on bo.OrderID = od.OrderID\n"
                + "join Customer c on c.CustomerID = bo.CustomerID\n"
                + "group by a.UserName, c.UserName having a.UserName = '" + username + "'";
        if (date != null) {
            sql += " and OrderDate >= '" + date + "'";
        }
        sql += " order by Quantity desc";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new ListTotal(rs.getString(1), rs.getInt(2)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public List<ListTotal> getListCategory(String username, Date date) {
        List<ListTotal> list = new ArrayList<>();
        String sql = "select distinct c.Image, c.Name, sum(TotalMoney) as TotalMoney from Admin a join Book b on b.AdminID = a.AdminID\n"
                + "join Category c on b.CategoryID = c.CategoryID\n"
                + "join [Order Detail] o on o.BookID = b.BookID join [Book Order] bo on bo.OrderID=o.OrderID\n"
                + "group by UserName, c.Name, c.Image having a.UserName = '" + username + "'";
        if (date != null) {
            sql += " and OrderDate >= '" + date + "'";
        }
        sql += " order by TotalMoney desc";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new ListTotal(rs.getDouble(3), rs.getString(1), rs.getString(2)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public List<ListTotal> getChart2(String username) {
        List<ListTotal> list = new ArrayList<>();
        String sql = "select MONTH(OrderDate) as Month, sum(TotalMoney) as TotalMoney from Admin a join Book b on a.AdminID=b.AdminID \n"
                + "join [Order Detail] o on o.BookID = b.BookID\n"
                + "join [Book Order] bo on bo.OrderID = o.OrderID\n"
                + "group by month(OrderDate), UserName having UserName = '" + username + "'";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new ListTotal(rs.getInt(1), rs.getDouble(2)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
