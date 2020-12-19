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
public class Goods {
    protected String itemcode, itemname, companycode, typecode, unit, imageitem;
    protected int amount;
    protected float importprice, price;

    public Goods() {
    }

    public Goods(String itemcode, String itemname, String companycode, String typecode, String unit, String imageitem, int amount, float importprice, float price) {
        this.itemcode = itemcode;
        this.itemname = itemname;
        this.companycode = companycode;
        this.typecode = typecode;
        this.unit = unit;
        this.imageitem = imageitem;
        this.amount = amount;
        this.importprice = importprice;
        this.price = price;
    }
    

    public String getItemcode() {
        return itemcode;
    }

    public void setItemcode(String itemcode) {
        this.itemcode = itemcode;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public String getCompanycode() {
        return companycode;
    }

    public void setCompanycode(String companycode) {
        this.companycode = companycode;
    }

    public String getTypecode() {
        return typecode;
    }

    public void setTypecode(String typecode) {
        this.typecode = typecode;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getImageitem() {
        return imageitem;
    }

    public void setImageitem(String imageitem) {
        this.imageitem = imageitem;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public float getImportprice() {
        return importprice;
    }

    public void setImportprice(float importprice) {
        this.importprice = importprice;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Goods{" + "itemcode=" + itemcode + ", itemname=" + itemname + ", companycode=" + companycode + ", typecode=" + typecode + ", unit=" + unit + ", image_item=" + imageitem + ", amount=" + amount + ", importprice=" + importprice + ", price=" + price + '}';
    }
    public static Goods getFromResultSet(ResultSet rs) throws SQLException{
        Goods item = new Goods();
        item.setItemcode(rs.getString("item_code"));
        item.setItemname(rs.getNString("item_name"));
        item.setCompanycode(rs.getString("company_code"));
        item.setTypecode(rs.getString("type_code"));
        item.setAmount(rs.getInt("amount"));
        item.setUnit(rs.getNString("unit"));
        item.setImportprice(rs.getFloat("import_price"));
        item.setPrice(rs.getFloat("price"));
        item.setImageitem(rs.getString("image_item"));
        return item;
    }
}
