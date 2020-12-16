/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConnectToTheDatabase;

import JavaClassObject.Suppliers;
import JavaClassObject.UserModify;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author acer
 */
public class SupplierConnectToDatabase {
    @SuppressWarnings("empty-statement")
    public static ArrayList<Suppliers> findAllSupplier() throws SQLException {
        ArrayList<Suppliers> ListSupplier = new ArrayList<>();
        java.sql.Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/qlbh", "root", "");
            statement = connection.createStatement();
            String sql = "select * from supplier";
            ResultSet resulSet = statement.executeQuery(sql);
            while (resulSet.next()) {
                Suppliers s = Suppliers.getFromResultSet(resulSet);
                ListSupplier.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        return ListSupplier;
    }
    
    @SuppressWarnings("empty-statement")
    public static int countSupplier() throws SQLException {
        int count = 0;
        java.sql.Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/qlbh", "root", "");
            statement = connection.createStatement();
            String sql = "select count(company_code) as count_supplier from supplier";
            ResultSet resulSet = statement.executeQuery(sql);
            if (resulSet.next()) {
                count = resulSet.getInt("count_supplier");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        return count;
    }
    public static void main(String[] args) throws SQLException {
        ArrayList<Suppliers> ListSupplier = SupplierConnectToDatabase.findAllSupplier();
        ListSupplier.forEach(suppliers -> {
            System.out.println(suppliers.toString());
        });
        int count = SupplierConnectToDatabase.countSupplier();
        System.out.println(count);
    }
}
