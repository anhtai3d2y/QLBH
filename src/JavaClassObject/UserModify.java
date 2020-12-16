/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaClassObject;

import JavaClassObject.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * CRUD (findUser, update, insert, delete)
 *
 * @author acer
 */
public class UserModify {

    public static ArrayList<User> findUser() {
        ArrayList<User> userList = new ArrayList<>();
        java.sql.Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/qlbh", "root", "");
            statement = connection.createStatement();
            String sql = "select * from users";
            ResultSet resulSet = statement.executeQuery(sql);
            while (resulSet.next()) {
                User ur = new User(resulSet.getInt("id"), resulSet.getString("user_name"), resulSet.getString("password"), resulSet.getInt("is_admin"));
                userList.add(ur);
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
        }
        return userList;
    }

    public static void insert(User us) {
        java.sql.Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/qlbh", "root", "");
            String sql = "insert into users(user_name, password, is_admin) values('?','?',b'?')";
            statement = connection.prepareCall(sql);
            statement.setString(1, us.getUsername());
            statement.setString(2, us.getPassword());
            statement.setInt(3, us.getIsadmin());

            statement.execute();

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
        }
    }

    public static void update(User us) {
        java.sql.Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/qlbh", "root", "");
            String sql = "update users set password = ?, is_admin = ? where user_name = ?";
            statement = connection.prepareCall(sql);

            statement.setString(1, us.getPassword());
            statement.setInt(2, us.getIsadmin());
            statement.setString(3, us.getUsername());

            statement.execute();

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
        }
    }

    public static void delete(User us) {
        java.sql.Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/qlbh", "root", "");
            String sql = "delete form users where user_name = ?";
            statement = connection.prepareCall(sql);

            statement.setString(1, us.getUsername());

            statement.execute();

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
        }
    }
}
