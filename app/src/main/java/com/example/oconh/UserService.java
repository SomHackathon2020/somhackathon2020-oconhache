package com.example.oconh;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.example.oconh.User;

import java.util.HashSet;

public class UserService {

    HashSet<User> users = new HashSet<User>();

    public void register(String name,String password,String age, String education, String phone, String mail) throws Exception{

        User user = new User(name,password,age, education, phone, mail);
        if(this.checkUserNotExist(user)){ users.add(user); }
        throw new Exception("User or password not valids");
    }

    private boolean checkUserNotExist(User user){
        return !this.users.contains(user);
    }

    public boolean singIn(String user_name, String password){

        return true;

    }

}
