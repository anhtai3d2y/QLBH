/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlbhgg.dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import qlbhgg.models.TypeOfGoods;

/**
 *
 * @author acer
 */
public class TypeOfGoodDao {
    public static void setComboboxType(JComboBox cbb) throws SQLException{
        java.sql.Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/qlbh", "root", "");
            statement = connection.createStatement();
            String sql = "SELECT type_name FROM typeofgoods";
            ResultSet resulSet = statement.executeQuery(sql);
            while(resulSet.next()){
                cbb.addItem(resulSet.getNString("type_name"));
            }
            System.out.println("Connected!");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TypeOfGoods.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TypeOfGoods.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
    }
}
