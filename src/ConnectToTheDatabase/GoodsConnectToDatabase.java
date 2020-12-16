/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConnectToTheDatabase;

import JavaClassObject.UserModify;
import JavaClassObject.Goods;
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
public class GoodsConnectToDatabase {

    @SuppressWarnings("empty-statement")
    public static ArrayList<Goods> findAll() throws SQLException {
        ArrayList<Goods> goods = new ArrayList<>();
        java.sql.Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/qlbh", "root", "");
            statement = connection.createStatement();
            String sql = "SELECT item_code, item_name, supplier.company_name as company_code, typeofgoods.type_name as type_code, amount,unit,import_price,price, image_item from goods, supplier, typeofgoods WHERE goods.company_code = supplier.company_code and goods.type_code = typeofgoods.type_code";
            ResultSet resulSet = statement.executeQuery(sql);
            while (resulSet.next()) {
                Goods good = Goods.getFromResultSet(resulSet);
                goods.add(good);
            }
            System.out.println("Connected!");
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
        return goods;
    }

    @SuppressWarnings({"empty-statement", "empty-statement", "empty-statement"})
    public static int countProduct() throws SQLException {
        int count = 0;
        java.sql.Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/qlbh", "root", "");
            statement = connection.createStatement();
            String sql = "SELECT COUNT(item_code) as count_item FROM goods";
            ResultSet resulSet = statement.executeQuery(sql);
            if (resulSet.next()) {
                count = resulSet.getInt("count_item");
            }
            System.out.println("Connected!");
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

    @SuppressWarnings("empty-statement")
    public static ArrayList<Goods> findBy(String str) throws SQLException {
        ArrayList<Goods> goods = new ArrayList<>();
        java.sql.Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/qlbh", "root", "");
            statement = connection.createStatement();
            String sql = "SELECT item_code, item_name, supplier.company_name as company_code, typeofgoods.type_name as type_code, amount,unit,import_price,price, image_item from goods, supplier, typeofgoods WHERE goods.company_code = supplier.company_code and goods.type_code = typeofgoods.type_code and typeofgoods.type_name = '" + str +"';";
            ResultSet resulSet = statement.executeQuery(sql);
            while (resulSet.next()) {
                Goods good = Goods.getFromResultSet(resulSet);
                goods.add(good);
            }
            System.out.println("Connected!");
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
        return goods;
    }
    @SuppressWarnings("empty-statement")
    public static int countProductBy(String str) throws SQLException {
        int count = 0;
        java.sql.Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/qlbh", "root", "");
            statement = connection.createStatement();
            String sql = "SELECT COUNT(item_code) as count_item FROM goods JOIN typeofgoods ON goods.type_code = typeofgoods.type_code WHERE typeofgoods.type_name = '" + str + "';";
            ResultSet resulSet = statement.executeQuery(sql);
            if (resulSet.next()) {
                count = resulSet.getInt("count_item");
            }
            System.out.println("Connected!");
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
    
    @SuppressWarnings("empty-statement")
    public static ArrayList<Goods> searchProduct(String str) throws SQLException {
        ArrayList<Goods> goods = new ArrayList<>();
        java.sql.Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/qlbh", "root", "");
            statement = connection.createStatement();
            String sql = "SELECT * FROM (goods join supplier on supplier.company_code = goods.company_code) join typeofgoods on typeofgoods.type_code = goods.type_code WHERE item_code LIKE '%" + str + "%' or item_name LIKE '%" + str + "%' or supplier.company_name LIKE '%" + str + "%' or supplier.company_code LIKE '%" + str + "%' or goods.type_code LIKE '%" + str + "%' or typeofgoods.type_name LIKE '%" + str + "%' or amount LIKE '%" + str + "%' or import_price LIKE '%" + str + "%' or price LIKE '%" + str + "%'";
            ResultSet resulSet = statement.executeQuery(sql);
            while (resulSet.next()) {
                Goods g = Goods.getFromResultSet(resulSet);
                goods.add(g);
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
        return goods;
    }
    
    @SuppressWarnings({"empty-statement", "empty-statement", "empty-statement"})
    public static int countSearchProduct(String str) throws SQLException {
        int count = 0;
        java.sql.Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/qlbh", "root", "");
            statement = connection.createStatement();
            String sql = "SELECT COUNT(item_code) as count_item FROM (goods join supplier on supplier.company_code = goods.company_code) join typeofgoods on typeofgoods.type_code = goods.type_code WHERE item_code LIKE '%" + str + "%' or item_name LIKE '%" + str + "%' or supplier.company_name LIKE '%" + str + "%' or supplier.company_code LIKE '%" + str + "%' or goods.type_code LIKE '%" + str + "%' or typeofgoods.type_name LIKE '%" + str + "%' or amount LIKE '%" + str + "%' or import_price LIKE '%" + str + "%' or price LIKE '%" + str + "%'";
            ResultSet resulSet = statement.executeQuery(sql);
            if (resulSet.next()) {
                count = resulSet.getInt("count_item");
            }
            System.out.println("Connected!");
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
    
    @SuppressWarnings({"empty-statement", "empty-statement", "empty-statement"})
    public static Goods findProductForBill(String id) throws SQLException {
        Goods g  = new Goods();
        java.sql.Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/qlbh", "root", "");
            statement = connection.createStatement();
            String sql = "select * from goods where item_code = '" + id + "'";
            ResultSet resulSet = statement.executeQuery(sql);
            if (resulSet.next()) {
                g = Goods.getFromResultSet(resulSet);
            }
            System.out.println("Connected!");
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
        return g;
    }
    
    
    
    public static void main(String[] args) throws SQLException {
    }
}
