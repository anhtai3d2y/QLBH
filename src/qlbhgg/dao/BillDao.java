/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlbhgg.dao;

import qlbhgg.models.Bill;
import qlbhgg.models.Users;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
public class BillDao {
    @SuppressWarnings("empty-statement")
    public static ArrayList<Bill> findAllBill() throws SQLException {
        ArrayList<Bill> ListBill = new ArrayList<>();
        java.sql.Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/qlbh", "root", "");
            statement = connection.createStatement();
            String sql = "select * from bill";
            ResultSet resulSet = statement.executeQuery(sql);
            while (resulSet.next()) {
                Bill b = Bill.getFromResultSet(resulSet);
                ListBill.add(b);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Bill.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Bill.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        return ListBill;
    }
    
    @SuppressWarnings("empty-statement")
    public static int countBill() throws SQLException {
        int count = 0;
        java.sql.Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/qlbh", "root", "");
            statement = connection.createStatement();
            String sql = "select count(code_bill) as count_bill from bill";
            ResultSet resulSet = statement.executeQuery(sql);
            if (resulSet.next()) {
                count = resulSet.getInt("count_bill");
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Bill.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Bill.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        return count;
    }
    
    public static ArrayList<Bill> searchBill(String str) {
        ArrayList<Bill> ListBills = new ArrayList<Bill>();
        java.sql.Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/qlbh", "root", "");
            String sql = "SELECT DISTINCT bill.code_bill, bill.customer_code, bill.id_user, bill.id_user, bill.invoice_creation_date, bill.note FROM ((((bill JOIN invoicedetails on bill.code_bill = invoicedetails.code_bill) JOIN users on users.id_user = bill.id_user) JOIN goods on goods.item_code = invoicedetails.item_code) JOIN supplier ON supplier.company_code = goods.company_code) JOIN typeofgoods on typeofgoods.type_code = goods.type_code WHERE (bill.code_bill LIKE '%" + str +"%' OR bill.customer_code LIKE '%" + str +"%' OR bill.id_user LIKE '%" + str +"%' OR bill.invoice_creation_date LIKE '%" + str +"%' OR invoicedetails.price LIKE '%" + str +"%' OR invoicedetails.amount LIKE '%" + str +"%' OR goods.item_name LIKE '%" + str +"%' OR goods.company_code LIKE '%" + str +"%' OR goods.type_code LIKE '%" + str +"%' OR supplier.company_name LIKE '%" + str +"%' OR typeofgoods.type_name LIKE '%" + str +"%' OR users.full_name LIKE '%" + str +"%')";
            statement = connection.createStatement();
            ResultSet resulSet = statement.executeQuery(sql);
            while(resulSet.next()){
                Bill b = Bill.getFromResultSet(resulSet);
                ListBills.add(b);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Bill.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Bill.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return ListBills;
    }
    
    public static int countsearchBill(String str) {
        int count = 0;
        java.sql.Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/qlbh", "root", "");
            String sql = "SELECT count(bill.code_bill) as count_searchbill FROM ((((bill JOIN invoicedetails on bill.code_bill = invoicedetails.code_bill) JOIN users on users.id_user = bill.id_user) JOIN goods on goods.item_code = invoicedetails.item_code) JOIN supplier ON supplier.company_code = goods.company_code) JOIN typeofgoods on typeofgoods.type_code = goods.type_code WHERE (bill.code_bill LIKE '%" + str +"%' OR bill.customer_code LIKE '%" + str +"%' OR bill.id_user LIKE '%" + str +"%' OR bill.invoice_creation_date LIKE '%" + str +"%' OR invoicedetails.price LIKE '%" + str +"%' OR invoicedetails.amount LIKE '%" + str +"%' OR goods.item_name LIKE '%" + str +"%' OR goods.company_code LIKE '%" + str +"%' OR goods.type_code LIKE '%" + str +"%' OR supplier.company_name LIKE '%" + str +"%' OR typeofgoods.type_name LIKE '%" + str +"%' OR users.full_name LIKE '%" + str +"%')";
            statement = connection.createStatement();
            ResultSet resulSet = statement.executeQuery(sql);
            if(resulSet.next()){
                count  = resulSet.getInt("count_searchbill");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Bill.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Bill.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return count;
    }
    
    public static void main(String[] args) throws SQLException {
        int count = BillDao.countsearchBill("B000000001");
        System.out.println(count);
        ArrayList<Bill> ListBills = BillDao.searchBill("B000000001");
        for (Bill ListBill : ListBills) {
            System.out.println(ListBill.toString());
        }
    }
}
