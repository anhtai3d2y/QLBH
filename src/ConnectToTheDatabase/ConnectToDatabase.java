/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConnectToTheDatabase;
import java.sql.*;
/**
 *
 * @author acer
 */
public class ConnectToDatabase {
    private static ConnectToDatabase instance = null;

    private static final String JDBC_STRING = "jdbc:mysql://localhost";
    private static final String DB_NAME = "qlbh";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "";
    private static final String URL = JDBC_STRING + "/" + DB_NAME;

    private Connection conn = null;
    
    private ConnectToDatabase() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.conn = DriverManager.getConnection(URL, DB_USER, DB_PASS);
            System.out.println("Connect database success!");
        } catch (Exception e) {
            System.out.println("Connect database error:");
            System.out.println(e.toString());
        }
    }
    
    public Connection getConnection(){
        return this.conn;
    }
    
    public static ConnectToDatabase getInstance(){
        if (instance == null) {
            instance = new ConnectToDatabase();
        }
        return instance;
    }
            
    public static void main(String[] args) {
        try {
            Connection connection = getInstance().getConnection();
            Statement stmt = connection.createStatement();
            String query = "SELECT CURRENT_TIMESTAMP";
            ResultSet rs = stmt.executeQuery(query);
            // show data
            while (rs.next()) {
                System.out.println(rs.getDate("CURRENT_TIMESTAMP").toString());
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
