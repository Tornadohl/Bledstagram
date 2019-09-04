package com.codepath.bledstagram;

import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseUser;

@ParseClassName("User")
public class User extends ParseUser {
    public static final  String KEY_USERNAME = "username";
    public static final  String KEY_EMAIL = "email";
    public static final  String KEY_PASSWORD = "password";

    public String getUsername(){
        return getString(KEY_USERNAME);
    }

    public void setUsername(String username){
        put(KEY_USERNAME,username);
    }

    public String getEmail(){
        return  getString(KEY_EMAIL);
    }

    public  void setEmail(String email){
        put(KEY_EMAIL, email);
    }

    public String getPassword(){
        return getString(KEY_PASSWORD);
    }
    public void setPassword(String password){
        put(KEY_PASSWORD, password);
    }

}
