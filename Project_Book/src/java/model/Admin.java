/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;

/**
 *
 * @author TrongHoa
 */
public class Admin {
//	[AccountID] [int] NULL,
//	[FirstName] [nvarchar](max) NULL,
//	[LastName] [nvarchar](max) NULL,
//	[Email] [varchar](max) NULL,
//	[Phone] [varchar](15) NULL,
//	[Address] [nvarchar](max) NULL,
//	[Image] [varchar](1) NULL,
    private int adminId;
    private String  username, firstname, lastname, email, phone, address, image;

    public Admin() {
    }

    public Admin( String username, String firstname, String lastname, String email, String phone, String address, String image) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.image = image;
    }

    public Admin(int adminId,  String username, String firstname, String lastname, String email, String phone, String address, String image) {
        this.adminId = adminId;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.image = image;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    
    
}
