/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlbhgg.dao;

import qlbhgg.models.Invoicedetails;
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
public class InvoicedetailsDao {
    @SuppressWarnings("empty-statement")
    public static ArrayList<Invoicedetails> findInvoicedetailsByIdBill(String id) throws SQLException {
        ArrayList<Invoicedetails> ListInvoicedetails = new ArrayList<>();
        java.sql.Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/qlbh", "root", "");
            statement = connection.createStatement();
            String sql = "select * from invoicedetails where code_bill = '" + id + "'";
            ResultSet resulSet = statement.executeQuery(sql);
            while (resulSet.next()) {
                Invoicedetails iv = Invoicedetails.getFromResultSet(resulSet);
                ListInvoicedetails.add(iv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Invoicedetails.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Invoicedetails.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        return ListInvoicedetails;
    }
    public static void main(String[] args) throws SQLException {
    }
}
