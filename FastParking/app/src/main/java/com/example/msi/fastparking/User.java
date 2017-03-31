package com.example.msi.fastparking;

/**
 * Created by msi on 5/10/2016.
 */
public class User {
    String name, username,password,seatTaken;
    int special;
    public User(String name, String username,String seatTaken){
        this.name = name;
        this.username=username;
        this.seatTaken = seatTaken;
        this.special = 1;
        this.password = null;
    }
    public User(String username){
        this.username = username;
        this.name = "";
        this.seatTaken = null;
        this.special = 1;
        this.password = null;
    }
    public void setPassword(String p){
        this.password = p;
    }
    public String getPassword(){
        return password;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public String getName(){
        return name;
    }
    public String getUsername() {
        return username;
    }
    public void setSeatTaken(String seatTaken){
        this.seatTaken = seatTaken;
    }
    public String getSeatTaken(){
        return seatTaken;
    }
    public void setSpecial(int special){
        this.special = special;
    }
    public int getSpecial() {
        return special;
    }
}
