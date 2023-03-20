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
public class Book {
    private int bookID;
    private String name, title, describe, author;
    private double price;
    private float discount;
    private Date releaseDate;
    private String image;
    private int categoryID;
    private int adminID;
    private int sold;
    private int rate;
    private String categoryName;

    public Book(int bookID, String name, String title, String describe, String author, double price, float discount, Date releaseDate, String image, int categoryID, int adminID, String categoryName) {
        this.bookID = bookID;
        this.name = name;
        this.title = title;
        this.describe = describe;
        this.author = author;
        this.price = price;
        this.discount = discount;
        this.releaseDate = releaseDate;
        this.image = image;
        this.categoryID = categoryID;
        this.adminID = adminID;
        this.sold = sold;
        this.rate = rate;
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    
    

    public Book() {
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
    
    

    public Book(int bookID, String name, String title, String describe, String author, double price, float discount, Date releaseDate, String image, int categoryID, int adminID) {
        this.bookID = bookID;
        this.name = name;
        this.title = title;
        this.describe = describe;
        this.author = author;
        this.price = price;
        this.discount = discount;
        this.releaseDate = releaseDate;
        this.image = image;
        this.categoryID = categoryID;
        this.adminID = adminID;
    }

    public Book(int bookID, String name, String title, String describe, String author, double price, float discount, Date releaseDate, String image, int categoryID, int adminID, int sold, int rate) {
        this.bookID = bookID;
        this.name = name;
        this.title = title;
        this.describe = describe;
        this.author = author;
        this.price = price;
        this.discount = discount;
        this.releaseDate = releaseDate;
        this.image = image;
        this.categoryID = categoryID;
        this.adminID = adminID;
        this.sold = sold;
        this.rate= rate;
    }
    
    

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }
    
    

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public int getAdminID() {
        return adminID;
    }

    public void setAdminID(int adminID) {
        this.adminID = adminID;
    }
    
}
