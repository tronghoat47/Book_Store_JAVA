/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;

/**
 *
 * @author TrongHoa
 */
public class Category {
    private int categoryID;
    private String name, image;
    private Double tunrover;

    

    

    public Category() {
    }

    public Category(String name, String image) {
        this.name = name;
        this.image = image;
    }
    
    

    public Category(int categoryID, String name, String image) {
        this.categoryID = categoryID;
        this.name = name;
        this.image = image;
    }
    
    public Category(String name, Double tunrover) {
        this.name = name;
        this.tunrover = tunrover;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    

    public Double getTunrover() {
        return tunrover;
    }

    public void setTunrover(Double tunrover) {
        this.tunrover = tunrover;
    }
    
    
}
