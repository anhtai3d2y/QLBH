/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlbhgg.models;

/**
 *
 * @author acer
 */
public class User {
    int id;
    String username;
    String password;
    int isadmin;

    public User() {
    }

    public User(int id, String username, String password, int isadmin) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.isadmin = isadmin;
    }

    public User(String username, String password, int isadmin) {
        this.username = username;
        this.password = password;
        this.isadmin = isadmin;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public int getIsadmin(){
        return isadmin;
    }
    
    public void setIsadmin(int isadmin){
        this.isadmin = isadmin;
    }
    
}
