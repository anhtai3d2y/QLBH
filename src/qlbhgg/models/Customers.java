/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlbhgg.models;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author acer
 */
public class Customers {
    protected String customercode, customername, tradingname, address, email, phonenumber;

    public Customers() {
    }

    public String getCustomercode() {
        return customercode;
    }

    public void setCustomercode(String customercode) {
        this.customercode = customercode;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public String getTradingname() {
        return tradingname;
    }

    public void setTradingname(String tradingname) {
        this.tradingname = tradingname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    @Override
    public String toString() {
        return "Customers{" + "customercode=" + customercode + ", customername=" + customername + ", tradingname=" + tradingname + ", address=" + address + ", email=" + email + ", phonenumber=" + phonenumber + '}';
    }
    public static Customers getFromResultSet(ResultSet rs) throws SQLException{
        Customers customer = new Customers();
        customer.setCustomercode(rs.getString("customer_code"));
        customer.setCustomername(rs.getNString("customer_name"));
        customer.setTradingname(rs.getNString("trading_name"));
        customer.setAddress(rs.getNString("address"));
        customer.setEmail(rs.getString("email"));
        customer.setPhonenumber(rs.getString("phone_number"));
        return customer;
    }
}
