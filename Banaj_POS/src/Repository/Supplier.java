/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;

/**
 *
 * @author user
 */
public class Supplier implements SupplierInterface{
    
    DatabaseInterface dt = new Database();
    


    @Override
    public String getKodeSupplier(JComboBox box) {
        String kode ="";
        
        String sql ="select kode_supplier from supplier where nama_supplier = '"+box.getSelectedItem().toString()+"' desc limit 1";
        try(Connection con = dt.conectDatabase();
                Statement st = con.createStatement();
                ResultSet res =st.executeQuery(sql)){
            
            while (res.next()) {

                kode = res.getString("kode_supplier");
                
            }
            
        }catch(SQLException e){
            
        }
        return kode;
    }
        

    public static void main(String[] args) {
        
        
        
    }
   
}
