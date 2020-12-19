/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlbhgg.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author acer
 */
public class Users {
    protected String id, username, password, gender, fullname, address, phonenumber, email, image_user, role, status;
    protected Date birthday, startdate;
    protected float basicsalary, allowance;

    public Users() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getImage_user() {
        return image_user;
    }

    public void setImage_user(String image_user) {
        this.image_user = image_user;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public float getBasicsalary() {
        return basicsalary;
    }

    public void setBasicsalary(float basicsalary) {
        this.basicsalary = basicsalary;
    }

    public float getAllowance() {
        return allowance;
    }

    public void setAllowance(float allowance) {
        this.allowance = allowance;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Users{" + "id=" + id + ", username=" + username + ", password=" + password + ", gender=" + gender + ", fullname=" + fullname + ", address=" + address + ", phonenumber=" + phonenumber + ", email=" + email  + ", image_user=" + image_user + ", role=" + role + ", status=" + status + ", birthday=" + birthday + ", startdate=" + startdate + ", basicsalary=" + basicsalary + ", allowance=" + allowance + ", status=" + status + '}';
    }

    
    

    
    public boolean checkPassword(String password){
        return this.password.equals(password);
    }
    public static Users getFromResultSet(ResultSet rs) throws SQLException{
        Users user = new Users();
        user.setId(rs.getString("id_user"));
        user.setUsername(rs.getString("user_name"));
        user.setPassword(rs.getString("password"));
        user.setRole(rs.getNString("role"));
        user.setFullname(rs.getNString("full_name"));
        user.setGender(rs.getNString("gender"));
        user.setBirthday(rs.getDate("birthday"));
        user.setStartdate(rs.getDate("start_date"));
        user.setAddress(rs.getNString("address"));
        user.setPhonenumber(rs.getString("phone_number"));
        user.setEmail(rs.getString("email"));
        user.setBasicsalary(rs.getFloat("basic_salary"));
        user.setAllowance(rs.getFloat("allowance"));
        user.setImage_user(rs.getString("image_user"));
        user.setStatus(rs.getNString("status"));
        return user;
    }
}
