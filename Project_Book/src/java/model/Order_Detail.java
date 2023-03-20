/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;

/**
 *
 * @author TrongHoa
 */
public class Order_Detail {
//    [BookID] [int] NOT NULL,
//	[OrderID] [int] NOT NULL,
//	[Quantity] [int] NULL,
//	[TotalMoney] [money] NULL,
    private Book book;
    private int  orderId, quantity;
    private boolean re;

    public Order_Detail() {
    }

    public Order_Detail(Book book, int orderId, int quantity) {
        this.book = book;
        this.orderId = orderId;
        this.quantity = quantity;
    }

    public boolean isRe() {
        return re;
    }

    public void setRe(boolean re) {
        this.re = re;
    }
    
    

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

        
}
