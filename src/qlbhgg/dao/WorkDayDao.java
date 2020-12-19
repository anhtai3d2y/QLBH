/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlbhgg.dao;

import qlbhgg.models.WorkDay;
import qlbhgg.models.Users;
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
public class WorkDayDao {
    @SuppressWarnings("empty-statement")
    public static ArrayList<WorkDay> findAll() throws SQLException {
        ArrayList<WorkDay> ListWorkDay = new ArrayList<>();
        java.sql.Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/qlbh", "root", "");
            statement = connection.createStatement();
            String sql = "SELECT * FROM timekeeping";
            ResultSet resulSet = statement.executeQuery(sql);
            while (resulSet.next()) {
                WorkDay workday = WorkDay.getFromResultSet(resulSet);
                ListWorkDay.add(workday);
            }
            System.out.println("Connected!");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(WorkDay.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(WorkDay.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        return ListWorkDay;
    }
    
    @SuppressWarnings("empty-statement")
    public static ArrayList<WorkDay> findByUsername(Users user) throws SQLException {
        ArrayList<WorkDay> ListWorkDay = new ArrayList<>();
        java.sql.Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/qlbh", "root", "");
            statement = connection.createStatement();
            String sql = "SELECT * FROM timekeeping WHERE id_user = '" + user.getId() + "'";
            ResultSet resulSet = statement.executeQuery(sql);
            while (resulSet.next()) {
                WorkDay workday = WorkDay.getFromResultSet(resulSet);
                ListWorkDay.add(workday);
            }
            System.out.println("Connected!");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(WorkDay.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(WorkDay.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        return ListWorkDay;
    }
    
    @SuppressWarnings("empty-statement")
    public static int countWorkDay(String id, int month, int year) throws SQLException {
        int count = 0;
        java.sql.Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/qlbh", "root", "");
            statement = connection.createStatement();
            String sql = "SELECT COUNT(work_day) as count_day FROM `timekeeping` WHERE id_user = '" + id + "' and month(work_day) = " + month + " and year(work_day) = " + year;
            ResultSet resulSet = statement.executeQuery(sql);
            if (resulSet.next()) {
                count = resulSet.getInt("count_day");
            }
            System.out.println("Connected!");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(WorkDay.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(WorkDay.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        return count;
    }
    
    public static void main(String[] args) throws SQLException {
        System.out.println(WorkDayDao.countWorkDay("US00000002", 11, 2020));
    }
}
