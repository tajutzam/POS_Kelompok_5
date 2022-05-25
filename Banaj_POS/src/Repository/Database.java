/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class Database implements DatabaseInterface{

    static {
        try{
            
            Driver driver = new com.mysql.jdbc.Driver();
            DriverManager.registerDriver(driver);
        }catch(SQLException e){
            System.out.println("Gagal Register Driver");
        }     
    }
    public static Connection mySqlCon;
    public Connection conectDatabase() {
        
        try{
                String jdbcUrl="jdbc:mysql://localhost:3306/db_banajTest";
                String jdbcUser="root";
                String jdbcPassword="zam";
                mySqlCon=DriverManager.getConnection(jdbcUrl,jdbcUser,jdbcPassword );
              
            
        }catch(SQLException e){
            
            JOptionPane.showMessageDialog(null, "Gagal Koneksi KeServer ! , ERROR : " + e.getMessage() , "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        return mySqlCon;
    }
   
}
