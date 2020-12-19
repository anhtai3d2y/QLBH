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
public class Suppliers {
    protected String companycode, companyname, tradingname, address, email, phonenumber, logo;

    public Suppliers() {
    }

    public String getCompanycode() {
        return companycode;
    }

    public void setCompanycode(String companycode) {
        this.companycode = companycode;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
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

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
    
    

    @Override
    public String toString() {
        return "Suppliers{" + "companycode=" + companycode + ", companyname=" + companyname + ", tradingname=" + tradingname + ", address=" + address + ", email=" + email + ", phonenumber=" + phonenumber + '}';
    }
    public static Suppliers getFromResultSet(ResultSet rs) throws SQLException{
        Suppliers supplier = new Suppliers();
        supplier.setCompanycode(rs.getString("company_code"));
        supplier.setCompanyname(rs.getNString("company_name"));
        supplier.setTradingname(rs.getNString("trading_name"));
        supplier.setAddress(rs.getNString("address"));
        supplier.setEmail(rs.getString("email"));
        supplier.setPhonenumber(rs.getString("phone_number"));
        supplier.setLogo(rs.getString("logo_supplier"));
        return supplier;
    }
}
