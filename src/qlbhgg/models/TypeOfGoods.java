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
public class TypeOfGoods {
    protected String typecode, typename;

    public TypeOfGoods() {
    }

    public String getTypecode() {
        return typecode;
    }

    public void setTypecode(String typecode) {
        this.typecode = typecode;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    @Override
    public String toString() {
        return "TypeOfGoods{" + "typecode=" + typecode + ", typename=" + typename + '}';
    }
    public static TypeOfGoods getFromResultSet(ResultSet rs) throws SQLException{
        TypeOfGoods tog = new TypeOfGoods();
        tog.setTypecode(rs.getString("type_code"));
        tog.setTypename(rs.getNString("type_name"));
        return tog;
    }
}
