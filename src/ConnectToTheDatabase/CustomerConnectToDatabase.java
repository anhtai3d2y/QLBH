/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConnectToTheDatabase;

import JavaClassObject.Bill;
import JavaClassObject.Customers;
import JavaClassObject.UserModify;
import java.beans.Statement;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author acer
 */
@SuppressWarnings("empty-statement")
public class CustomerConnectToDatabase {
    @SuppressWarnings("empty-statement")
    public static Customers findCustomerById(String id) throws SQLException {
        Customers customer = new Customers();
        java.sql.Connection connection = null;
        java.sql.Statement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/qlbh", "root", "");
            statement = connection.createStatement();
            String sql = "select * from customer where customer_code = '" + id + "'";
            ResultSet resulSet = statement.executeQuery(sql);
            while (resulSet.next()) {
                customer = Customers.getFromResultSet(resulSet);
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(UserModify.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(UserModify.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
            }
        };
        return customer;
    }
    
    @SuppressWarnings("empty-statement")
    public static ArrayList<Customers> findAllCustomer() throws SQLException {
        ArrayList<Customers> customers = new ArrayList<>();
        java.sql.Connection connection = null;
        java.sql.Statement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/qlbh", "root", "");
            statement = connection.createStatement();
            String sql = "select * from customer";
            ResultSet resulSet = statement.executeQuery(sql);
            while (resulSet.next()) {
                Customers customer = Customers.getFromResultSet(resulSet);
                customers.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(UserModify.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(UserModify.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
            }
        };
        return customers;
    }
    
    public static ArrayList<Customers> searchCustomer(String str) throws SQLException {
        ArrayList<Customers> customers = new ArrayList<>();
        java.sql.Connection connection = null;
        java.sql.Statement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/qlbh", "root", "");
            statement = connection.createStatement();
            String sql = "select * from customer where customer_code like '%" + str + "%' or customer_name like '%" + str + "%' or trading_name like '%" + str + "%' or address like '%" + str + "%' or email like '%" + str + "%' or phone_number like '%" + str + "%'";
            ResultSet resulSet = statement.executeQuery(sql);
            while (resulSet.next()) {
                Customers customer = Customers.getFromResultSet(resulSet);
                customers.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(UserModify.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(UserModify.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
            }
        };
        return customers;
    }
    
    public static void main(String[] args) throws SQLException {
        ArrayList<Customers> lc = CustomerConnectToDatabase.searchCustomer("build bộ pc");
        for (Customers customers : lc) {
            System.out.println(customers.toString());
        }
   }
}
