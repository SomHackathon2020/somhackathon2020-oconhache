package com.example.oconh;

import com.example.oconh.User;

import java.util.HashSet;

public class UserService {

    HashSet<User> users = new HashSet<User>();

    public void register(String user_name, String password) throws Exception{

        User user = new User(user_name, password);
        if(this.checkUserNotExist(user)){ users.add(user); }
        throw new Exception("User or password not valids");
    }

    private boolean checkUserNotExist(User user){
        return !this.users.contains(user);
    }

    public boolean sinIn(String user_name, String password){

        return true;

    }

}
