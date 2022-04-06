/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;

/**
 *
 * @author user
 */
public class Kategori implements KategoriInterface{

    public String getCodeKategori(JComboBox box) {
        DatabaseInterface dt = new Database();
        
        
        
        
      
        String kode ="";
        
        String sql ="select kode_kategori from kategori where nama_kategori = '"+box.getSelectedItem().toString()+"' desc limit 1";
        try(Connection con = dt.conectDatabase();
                Statement st = con.createStatement();
                ResultSet res =st.executeQuery(sql)){
            
            while (res.next()) {

                kode = res.getString("kode_kategori");
                
            }
            
        }catch(SQLException e){
            
        }
        return kode;
    }
    
     public String getIdKategori(boolean setNewKode , String kode){
        DatabaseInterface dt = new Database();
         String sql_getIdKategori = "SELECT kode_kategori FROM kategori ORDER BY kode_kategori DESC LIMIT 1";

                
        try(Connection con = dt.conectDatabase();
            PreparedStatement pst = con.prepareStatement(sql_getIdKategori);
            ResultSet res = pst.executeQuery(sql_getIdKategori);   ){
          

            String hsl = "";
            if(res.next()){
                String a = res.getString(1).replaceAll("[a-zA-Z]", "");
                String b = "";
                String c[] = a.split("(?!^)");
                String u = "";

                if("0".equals(c[0])){
                    if("0".equals(c[1])){
                        b = c[2];
                    }else{
                        b = c[1]+c[2];
                    }
                }else{
                    b = a;
                }

                int d = Integer.parseInt(b)+1;

                if(d <= 9){
                    u = "K00";
                }else if(d <= 99 ){
                    u = "K0";
                }else{
                    u = "K";
                }
                hsl = u+""+d;
            }else{
                hsl = "K001";
            }
            
            if(setNewKode){
                kode =hsl;
            }
            
            return hsl;
            
        }catch(SQLException err){
            return err.getMessage();
        }
    }
    
    
}
