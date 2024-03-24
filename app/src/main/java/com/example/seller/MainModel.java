package com.example.seller;
///ใช้ในการเก็บข้อมูลของผในแอปพลิเคชัน
///String name: เก็บชื่อ
//String email: เก็บอีเมล
//String surl: เก็บ URL ของรูปภาพ
public class MainModel {
    String name,email,surl;

    MainModel(){

    }
    public MainModel(String name, String email, String surl) {
        this.name = name;
        this.email = email;
        this.surl = surl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSurl() {
        return surl;
    }

    public void setSurl(String surl) {
        this.surl = surl;
    }
}
