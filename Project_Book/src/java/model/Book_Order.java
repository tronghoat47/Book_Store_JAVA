/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;

/**
 *
 * @author TrongHoa
 */
public class Book_Order {
//	[PaymentMethod] [nvarchar](30) NULL,
//	[RecipientName] [nvarchar](50) NULL,
//	[RecipientPhone] [varchar](15) NULL,

    private int orderId, customerId;
    private Date orderDate;
    private String note, shippingAddress, recipientName, recipientPhone;
    private double totalMoney;

    public Book_Order() {
    }

    public Book_Order(int orderId, int customerId, Date orderDate, String note, String shippingAddress, String recipientName, String recipientPhone, double totalMoney) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.orderDate = orderDate;
        this.note = note;
        this.shippingAddress = shippingAddress;
        this.recipientName = recipientName;
        this.recipientPhone = recipientPhone;
        this.totalMoney = totalMoney;
    }

    public Book_Order(int orderId, Date orderDate, String shippingAddress, String recipientName, String recipientPhone, double totalMoney) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.shippingAddress = shippingAddress;
        this.recipientName = recipientName;
        this.recipientPhone = recipientPhone;
        this.totalMoney = totalMoney;
    }
    
    

    public Book_Order(int customerId, Date orderDate, String note, String shippingAddress, String recipientName, String recipientPhone, double totalMoney) {
        this.customerId = customerId;
        this.orderDate = orderDate;
        this.note = note;
        this.shippingAddress = shippingAddress;
        this.recipientName = recipientName;
        this.recipientPhone = recipientPhone;
        this.totalMoney = totalMoney;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public String getRecipientPhone() {
        return recipientPhone;
    }

    public void setRecipientPhone(String recipientPhone) {
        this.recipientPhone = recipientPhone;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    
}
