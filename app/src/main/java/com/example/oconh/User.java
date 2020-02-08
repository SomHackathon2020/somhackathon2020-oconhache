package com.example.oconh;

public class User {

    private String name;
    private String password;
    private int age;
    private String education;
    private int phone;
    private String mail;

    public User(String name,String password,int age, String education, int phone, String mail){

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

    public int getAge(){
        return this.age;
    }

    public String getEducation() {
        return this.education;
    }

    public int getPhone() {
        return this.phone;
    }

    public String getMail() {
        return this.mail;
    }
}
