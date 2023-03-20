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
public class Review {
//   [BookID] [int] NOT NULL,
//	[CustomerID] [int] NOT NULL,
//	[Comment] [ntext] NULL,
//	[Date] [date] NULL,
//	[Rating] [int] NULL,
    private int bookId, customerId;
    private String comment;
    private Date date;
    private int rating;
    private String username;
    private String image;

    public Review() {
    }

    public Review(int bookId, int customerId, String comment, Date date, int rating) {
        this.bookId = bookId;
        this.customerId = customerId;
        this.comment = comment;
        this.date = date;
        this.rating = rating;
    }
    
    public Review(int bookId, int customerId, String comment, Date date, int rating, String username, String image) {
        this.bookId = bookId;
        this.customerId = customerId;
        this.comment = comment;
        this.date = date;
        this.rating = rating;
        this.username = username;
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
    

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    
    
}
