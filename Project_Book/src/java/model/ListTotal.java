/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;

/**
 *
 * @author TrongHoa
 */
public class ListTotal {
    private String usernameAd;
    private String usernameCu;
    private int month;
    private Double totalMoney;
    
    private String image, name;
    private int quantity;

    public ListTotal(Double totalMoney, String image, String name) {
        this.totalMoney = totalMoney;
        this.image = image;
        this.name = name;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }
    
    

    public ListTotal(int month, Double totalMoney) {
        this.month = month;
        this.totalMoney = totalMoney;
    }
    
    

    public ListTotal(String image, String name, int quantity) {
        this.image = image;
        this.name = name;
        this.quantity = quantity;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ListTotal(String usernameCu, int quantity) {
        this.usernameCu = usernameCu;
        this.quantity = quantity;
    }
    
    

    public ListTotal() {
    }

    public ListTotal(String usernameAd, String usernameCu, Double totalMoney) {
        this.usernameAd = usernameAd;
        this.usernameCu = usernameCu;
        this.totalMoney = totalMoney;
    }

    public String getUsernameAd() {
        return usernameAd;
    }

    public void setUsernameAd(String usernameAd) {
        this.usernameAd = usernameAd;
    }

    public String getUsernameCu() {
        return usernameCu;
    }

    public void setUsernameCu(String usernameCu) {
        this.usernameCu = usernameCu;
    }

    public Double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
    }

    
    
    
}
