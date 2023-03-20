/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Book_Order;
import model.Cart;
import model.Customer;
import model.Item;
import model.Order_Detail;

/**
 *
 * @author TrongHoa
 */
public class DAOCheckout extends DBContext {

    public void addOrder(Customer c, Cart cart, String note, String address, String name, String phone) {
        LocalDate curDate = LocalDate.now();
        String date = curDate.toString();
        //ADD order
        String sql = "INSERT INTO [dbo].[Book Order]\n"
                + "           ([CustomerID]\n"
                + "           ,[OrderDate]\n"
                + "           ,[Note]\n"
                + "           ,[ShippingAddress]\n"
                + "           ,[RecipientName]\n"
                + "           ,[RecipientPhone]\n"
                + "           ,[TotalMoney])\n"
                + "     VALUES\n"
                + "           (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement st;
        try {
            st = connection.prepareStatement(sql);
            st.setInt(1, c.getCustomerId());
            st.setString(2, date);
            st.setString(3, note);
            st.setString(4, address);
            st.setString(5, name);
            st.setString(6, phone);
            st.setDouble(7, cart.getTotalMoney());
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOCheckout.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Lay id cua order vua add
        String sql1 = "select top 1 OrderID from [Book Order] order by OrderID desc";
        try {
            PreparedStatement st1 = connection.prepareStatement(sql1);
            ResultSet rs = st1.executeQuery();
            //Add vao bang orderDetail
            if (rs.next()) {
                int oid = rs.getInt(1);
                for (Item i : cart.getItems()) {
                    String sql2 = "INSERT INTO [dbo].[Order Detail]\n"
                            + "           ([BookID]\n"
                            + "           ,[OrderID]\n"
                            + "           ,[Quantity])\n"
                            + "     VALUES\n"
                            + "           (?, ?, ?)";
                    PreparedStatement st2 = connection.prepareStatement(sql2);
                    st2.setInt(1, i.getBook().getBookID());
                    st2.setInt(2, oid);
                    st2.setInt(3, i.getQuantity());
                    st2.executeUpdate();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOCheckout.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List<Book_Order> getHistoryBuy(int customerId) {
        List<Book_Order> list = new ArrayList<>();
        String sql = "select * from [Book Order] where CustomerID=" + customerId + " order by OrderID desc";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Book_Order(rs.getInt(1), rs.getInt(2), rs.getDate(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getDouble(8)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOCheckout.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public List<Order_Detail> getOrderDetail(int orderId) {
        List<Order_Detail> list = new ArrayList<>();
        String sql = "select o.*, Name, Image from [Order Detail] o join [Book Order] bo on o.OrderID = bo.OrderID\n"
                + "join Book b on b.BookID = o.BookID where o.OrderID=" + orderId;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Order_Detail(new DAOBook().getBookById(rs.getInt(1)), rs.getInt(2), rs.getInt(3)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOCheckout.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public int addReview(int bookId, int customerId, String cmt, int rating) {
        LocalDate curDate = LocalDate.now();
        String date = curDate.toString();
        String sql = "INSERT INTO [dbo].[Review]\n"
                + "           ([BookID]\n"
                + "           ,[CustomerID]\n"
                + "           ,[Comment]\n"
                + "           ,[Date]\n"
                + "           ,[Rating])\n"
                + "     VALUES\n"
                + "           (?, ?, ?, ?, ?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, bookId);
            st.setInt(2, customerId);
            st.setString(3, cmt);
            st.setString(4, date);
            st.setInt(5, rating);
            return st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOCheckout.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public static void main(String[] args) {
        DAOCheckout d = new DAOCheckout();
    }

    public List<Book_Order> getManager(int adminId) {
        List<Book_Order> list = new ArrayList<>();
        String sql = "select bo.OrderID, bo.OrderDate, bo.ShippingAddress, bo.RecipientName, bo.RecipientPhone, bo.TotalMoney\n"
                + "from Admin a join Book b on a.AdminID=b.AdminID join [Order Detail] o on o.BookID = b.BookID\n"
                + "join [Book Order] bo on bo.OrderID = o.OrderID \n"
                + "group by a.AdminID, a.UserName, bo.OrderID, bo.OrderDate, bo.TotalMoney, bo.ShippingAddress, bo.RecipientName, bo.RecipientPhone\n"
                + "having a.AdminID="+adminId+" order by OrderDate desc ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Book_Order(rs.getInt(1), rs.getDate(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDouble(6)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOCheckout.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public Order_Detail checkReview(int bookID, int orderId) {
        String sql = "select * from Review where BookID="+bookID+" and CustomerID="+orderId;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if(rs.next())
                return new Order_Detail(new DAOBook().getBookById(bookID), orderId, 0);
        } catch (SQLException ex) {
            Logger.getLogger(DAOCheckout.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
}
