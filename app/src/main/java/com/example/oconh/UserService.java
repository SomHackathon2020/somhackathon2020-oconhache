package com.example.oconh;

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

    public boolean singIn(String user_name, String password) throws Exception{
        return this.checkCredentialsAreValid(user_name, password);
    }

    private boolean checkCredentialsAreValid(String user_name, String password) throws Exception{
        for(User user: this.users){
            if(user.getName().equalsIgnoreCase(user_name) && user.getPassword().equalsIgnoreCase(password)){
                return true;
            }
        }
        throw new Exception("Credential not valid");
    }

}
