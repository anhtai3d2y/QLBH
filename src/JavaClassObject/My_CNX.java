/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaClassObject;

import com.mysql.cj.jdbc.MysqlDataSource;
import com.sun.jdi.connect.spi.Connection;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.SQLException;

/**
 *
 * @author acer
 */
public class My_CNX {
    private static String serverName = "localhost";
    private static String username = "root";
    private static String dbName = "qlbh";
    private static Integer portNumber = 3306;
    private static String password = "";
    
    public static Connection getConnection(){
        Connection cnx = null;
        
        MysqlDataSource datasource = new MysqlDataSource();
        
        datasource.setServerName(serverName);
        datasource.setUser(username);
        datasource.setPassword(password);
        datasource.setDatabaseName(dbName);
        datasource.setPortNumber(portNumber);
        
        
        try {
            cnx = (Connection) datasource.getConnection();
        } catch (SQLException ex) {
//            Logger.getLogger("Get Connection -> " + My_CNX.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        return cnx;
    }
    
}
