package com.abhi.entities;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;

@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 50,name = "user_id")
    private int uid;

    @Override
    public String toString() {
        return "Users{" +
                "uid=" + uid +
                ", uName='" + uName + '\'' +
                ", uMail='" + uMail + '\'' +
                ", uPassword='" + uPassword + '\'' +
                ", uPhone='" + uPhone + '\'' +
                ", uPic='" + uPic + '\'' +
                ", uAddress='" + uAddress + '\'' +
                ", userType='" + userType + '\'' +
                '}';
    }

    @Column(length = 50,name = "user_name")
    private  String uName;
    @Column(length = 50,name = "user_mail",unique = true)
    private  String uMail;
    @Column(length = 20,name = "user_password")
    private  String uPassword;
    @Column(length = 12,name = "user_number")
    private  String uPhone;
    @Column(length = 1500,name = "user_pic")
    private  String uPic;
    @Column(length = 150,name = "user_address")
    private  String uAddress;
    @Column(name="user_type")
    private String userType;

    public Users(int uid, String uName, String uMail, String uPassword, String uPhone, String uPic, String uAddress) {
        this.uid = uid;
        this.uName = uName;
        this.uMail = uMail;
        this.uPassword = uPassword;
        this.uPhone = uPhone;
        this.uPic = uPic;
        this.uAddress = uAddress;
    }

    public Users(String uName, String uMail, String uPassword, String uPhone, String uPic, String uAddress,String type) {
        this.uName = uName;
        this.uMail = uMail;
        this.uPassword = uPassword;
        this.uPhone = uPhone;
        this.uPic = uPic;
        this.uAddress = uAddress;
        this.userType=type;
    }

    public Users() {
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuMail() {
        return uMail;
    }

    public void setuMail(String uMail) {
        this.uMail = uMail;
    }

    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword;
    }

    public String getuPhone() {
        return uPhone;
    }

    public void setuPhone(String uPhone) {
        this.uPhone = uPhone;
    }

    public String getuPic() {
        return uPic;
    }

    public void setuPic(String uPic) {
        this.uPic = uPic;
    }

    public String getuAddress() {
        return uAddress;
    }

    public void setuAddress(String uAddress) {
        this.uAddress = uAddress;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
