package com.example.oconh;

public class User {

    private String name;
    private String password;
    private String age;
    private String education;
    private String phone;
    private String mail;

    public User(String name,String password,String age, String education, String phone, String mail){
        this.name = name;
        this.password = password;
        this.age = age;
        this.education = education;
        this.phone = phone;
        this.mail = mail;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getPassword(){
        return this.password;
    }

    public void setPassword(String password){
        this.password = password;
    }
}
