/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaClassObject;
import java.sql.*;
/**
 *
 * @author acer
 */
public class ConnectToDatabase {
    public static void main(String[] args) {
        try {
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost/qlbh", "root", "");
            
            Statement myStmt = myConn.createStatement();
            
            ResultSet myRs = myStmt.executeQuery("select * from users");
            
            
           while(myRs.next()){
               System.out.println(myRs.getString("id") + " " + myRs.getString("username") + " " + myRs.getString("password") + " " + myRs.getString("isadmin"));
           }
           myRs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
