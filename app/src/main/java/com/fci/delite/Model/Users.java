package com.fci.delite.Model;

/**
 * Created by hj on 12/17/2017.
 */

public class Users {
    private static Users account;
    private String Name;
    private String Password;
    private String Address;
    private String Email;


    protected Users() {
    }

    public static Users Account(){
        if(account==null)
        {
            account=new Users();
        }
        return account;
    }

    public Users(String name, String password, String address, String email) {
        Name = name;
        Password = password;
        Address = address;
        Email = email;
    }


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
