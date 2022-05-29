/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import View.Dashbord;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author user
 */
public class Toko implements Tokointerface{
    Database db = new Database();

    @Override
    public void showDataToko() {
        
        String sql ="select * from toko";
        try(Connection con = db.conectDatabase();
                Statement st = con.createStatement();
                ResultSet res = st.executeQuery(sql)){
            
            if(res.next()){
                String namatoko =res.getString("nama_toko");
                String alamat=res.getString("alamat_toko");
                String noHp = res.getString("no_hp");
                String update = res.getString("update_at");
                Dashbord.nama_toko.setText(namatoko);
                Dashbord.alamat_toko.setText(alamat);
                Dashbord.no_hpToko.setText(noHp);
                Dashbord.update_toko.setText(update);
                Dashbord.nama_toko.setText(namatoko);
            }
            
        }catch(SQLException e){
            System.out.println(e);
        }
        
    }

    @Override
    public void editDataToko() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getNamaToko() {
        String sql ="select nama_toko from toko";
         String namatoko="";
        try(Connection con = db.conectDatabase();
                Statement st = con.createStatement();
                ResultSet res = st.executeQuery(sql)){
            
            if(res.next()){
                namatoko=res.getString("nama_toko");
                
            }
            
        }catch(SQLException e){
            System.out.println(e);
        }
     
        
       return namatoko;
        
    }
    
    
    
    
}
