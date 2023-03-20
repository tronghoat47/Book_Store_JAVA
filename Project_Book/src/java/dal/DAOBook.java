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
import model.Book;
import model.NXB;
import model.Review;

/**
 *
 * @author TrongHoa
 */
public class DAOBook extends DBContext {

    public List<Book> getNewBook() {
        List<Book> list = new ArrayList<>();
        String sql = "select b.*, avg(Rating) as Rating,  sum(Quantity) as Quantity from Book b left join [Order Detail] o \n"
                + "on b.BookID = o.BookID left join Review r on b.BookID = r.BookID group by b.BookID, b.AdminID, b.Author,\n"
                + "b.CategoryID, b.Describe, b.Discount, b.Image, b.Name, b.Price, b.ReleaseDate, b.Title order by ReleaseDate desc";

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

    public List<Book> getSoldBook() {
        List<Book> list = new ArrayList<>();
        String sql = "select b.*, avg(Rating) as Rating,  sum(Quantity) as Quantity from Book b left join [Order Detail] o \n"
                + "on b.BookID = o.BookID left join Review r on b.BookID = r.BookID group by b.BookID, b.AdminID, b.Author,\n"
                + "b.CategoryID, b.Describe, b.Discount, b.Image, b.Name, b.Price, b.ReleaseDate, b.Title order by Quantity desc";

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

    public List<Book> getLoveBook() {
        List<Book> list = new ArrayList<>();
        String sql = "select b.*, avg(Rating) as Rating,  sum(Quantity) as Quantity from Book b left join [Order Detail] o \n"
                + "on b.BookID = o.BookID left join Review r on b.BookID = r.BookID group by b.BookID, b.AdminID, b.Author,\n"
                + "b.CategoryID, b.Describe, b.Discount, b.Image, b.Name, b.Price, b.ReleaseDate, b.Title order by Rating desc";

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

    public List<Book> getAllBook() {
        List<Book> list = new ArrayList<>();
        String sql = "select b.*, avg(Rating) as Rating,  sum(Quantity) as Quantity from Book b left join [Order Detail] o \n"
                + "on b.BookID = o.BookID left join Review r on b.BookID = r.BookID group by b.BookID, b.AdminID, b.Author,\n"
                + "b.CategoryID, b.Describe, b.Discount, b.Image, b.Name, b.Price, b.ReleaseDate, b.Title";

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

    public List<Book> getBookByCategory(int id) {
        List<Book> list = new ArrayList<>();
        String sql = "select b.*, avg(Rating) as Rating,  sum(Quantity) as Quantity from Book b left join [Order Detail] o \n"
                + "on b.BookID = o.BookID left join Review r on b.BookID = r.BookID group by b.BookID, b.AdminID, b.Author,\n"
                + "b.CategoryID, b.Describe, b.Discount, b.Image, b.Name, b.Price, b.ReleaseDate, b.Title\n"
                + "having 1=1 ";
        if (id != 0) {
            sql += " and CategoryID=" + id;
        }

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

    public Book getBookById(int id) {
        String sql = "select b.*, avg(Rating) as Rating,  sum(Quantity) as Quantity from Book b left join [Order Detail] o \n"
                + "on b.BookID = o.BookID left join Review r on b.BookID = r.BookID group by b.BookID, b.AdminID, b.Author,\n"
                + "b.CategoryID, b.Describe, b.Discount, b.Image, b.Name, b.Price, b.ReleaseDate, b.Title\n"
                + "having 1=1 ";
        if (id != 0) {
            sql += " and b.bookID=" + id;
        }

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return new Book(rs.getInt("bookID"), rs.getString("name"), rs.getString("title"),
                        rs.getString("describe"), rs.getString("author"), rs.getDouble("price"),
                        rs.getFloat("discount"), rs.getDate("ReleaseDate"), rs.getString("image"),
                        rs.getInt("categoryID"), rs.getInt("adminID"), rs.getInt("quantity"), rs.getInt("rating"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOBook.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public List<Book> getListByPage(List<Book> list, int start, int end) {
        ArrayList<Book> arr = new ArrayList<>();
        for (int i = start; i < end; i++) {
            arr.add(list.get(i));
        }
        return arr;
    }

    public List<Book> searchByKey(String key, Date from, Date to, Double price1, Double price2, int id, String sort) {
        List<Book> list = new ArrayList<>();
        String sql = "select b.*, (Price - price*discount/100) as SortPrice, avg(Rating) as Rating,  sum(Quantity) as Quantity from Book b left join [Order Detail] o \n"
                + "              on b.BookID = o.BookID left join Review r on b.BookID = r.BookID group by b.BookID, b.AdminID, b.Author,\n"
                + "               b.CategoryID, b.Describe, b.Discount, b.Image, b.Name, b.Price, b.ReleaseDate, b.Title\n"
                + "             having 1=1  ";
        if (id != 0) {
            sql += " and CategoryID=" + id;
        }
        if (key != null) {
            sql += " and ((freetext(name, '\"" + key + "\"') or freetext(Author, '\"" + key + "\"')) or Name like N'%" + key + "%')";
        }
        if (from != null) {
            sql += " and ReleaseDate >= '" + from + "'";
        }
        if (to != null) {
            sql += " and ReleaseDate <= '" + to + "'";
        }

        if (price1 != null) {
            sql += " and (Price - price*discount/100) >= " + price1;
        }
        if (price2 != null) {
            sql += " and (Price - price*discount/100) <= " + price2;
        }
        if (sort != null) {
            if (sort.equals("new")) {
                sql += " order by ReleaseDate desc";
            }
            if (sort.equals("price")) {
                sql += " order by SortPrice ";
            }
            if (sort.equals("discount")) {
                sql += " order by Discount desc";
            }
            if (sort.equals("love")) {
                sql += " order by Rating desc";
            }
            if (sort.equals("sold")) {
                sql += " order by Quantity desc";
            }else {
                sql += " and title = N'" + sort+"' ";
            }
        }

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

    public List<Review> getComment(int bookId) {
        List<Review> list = new ArrayList<>();
        String sql = "select r.*, c.UserName, c.Image from Review r join Customer c on r.CustomerID=c.CustomerID where bookID='" + bookId + "' order by Date desc";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Review(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getDate(4), rs.getInt(5), rs.getString(6), rs.getString(7)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOBook.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public List<Book> getListBookSimilar(int bookID, String title, String author, int categoryID) {
        List<Book> list = new ArrayList<>();
        String sql = "select distinct top 10 * from Book where (Title= ? or Author = ? or CategoryID = ?) and BookId!=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, title);
            st.setString(2, author);
            st.setInt(3, categoryID);
            st.setInt(4, bookID);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDouble(6), rs.getFloat(7), rs.getDate(8), rs.getString(9), rs.getInt(10), rs.getInt(11)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOBook.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public List<NXB> getListNXB() {
        List<NXB> list = new ArrayList<>();
        String sql = "select * from NXB";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new NXB(rs.getString(1)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOBook.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public static void main(String[] args) {
        DAOBook d = new DAOBook();
        System.out.println(d.getNXB("NXB Dân Trí").getTitle());
    }

    public NXB getNXB(String title) {
        String sql = "select * from nxb where title='" + title + "'";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new NXB(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOBook.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void updateNXB(String title, String title1) {
        String sql = "UPDATE [dbo].[NXB]\n"
                + "   SET [Title] = ?\n"
                + " WHERE Title = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(2, title);
            st.setString(1, title1);
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOBook.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insertNXB(String title) {
        String sql = "INSERT INTO [dbo].[NXB]\n"
                + "           ([Title])\n"
                + "     VALUES\n"
                + "           ('" + title + "')";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOBook.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteNXB(String title) {
        String sql = "DELETE FROM [dbo].[NXB]\n"
                + "      WHERE Title = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, title);
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOBook.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
