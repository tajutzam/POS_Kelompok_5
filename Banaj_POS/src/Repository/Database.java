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
                String jdbcUrl="jdbc:mysql://localhost:3306/banaj_database";
                String jdbcUser="root";
                String jdbcPassword="zam";
                mySqlCon=DriverManager.getConnection(jdbcUrl,jdbcUser,jdbcPassword );
                System.out.println("Berhasil Connect database");
            
        }catch(SQLException e){
            
        }
        return mySqlCon;
    }
   
}
