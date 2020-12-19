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
public class Invoicedetails {
    protected String codebill, itemcode;
    protected float price;
    protected int amount, discount;

    public Invoicedetails() {
    }

    public String getCodebill() {
        return codebill;
    }

    public void setCodebill(String codebill) {
        this.codebill = codebill;
    }

    public String getItemcode() {
        return itemcode;
    }

    public void setItemcode(String itemcode) {
        this.itemcode = itemcode;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Invoicedetails{" + "codebill=" + codebill + ", itemcode=" + itemcode + ", price=" + price + ", amount=" + amount + ", discount=" + discount + '}';
    }
    public static Invoicedetails getFromResultSet(ResultSet rs) throws SQLException{
        Invoicedetails ivd = new Invoicedetails();
        ivd.setCodebill(rs.getString("code_bill"));
        ivd.setItemcode(rs.getString("item_code"));
        ivd.setPrice(rs.getFloat("price"));
        ivd.setAmount(rs.getInt("amount"));
        ivd.setDiscount(rs.getInt("discount"));
        return ivd;
    }
}
