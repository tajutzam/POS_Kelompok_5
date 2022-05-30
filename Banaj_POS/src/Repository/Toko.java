/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import View.Dashbord;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

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
                Dashbord.label_nama_toko.setText(namatoko);
                Dashbord.label_alamatTok.setText(alamat);
                Dashbord.label_noHp.setText(noHp);
            }
            
        }catch(SQLException e){
            System.out.println(e);
        }
        
    }

    @Override
    public void editDataToko(String nama_toko , String alamat , String no_hp ) {
        
        String sql="UPDATE `toko` SET nama_toko=?,alamat_toko=?,update_at=?,no_hp=? WHERE id_toko ='TOKO01'";
        try(Connection con = db.conectDatabase();
            PreparedStatement pst = con.prepareStatement(sql)){
            
            Calendar calendar = Calendar.getInstance();
            Date dt = calendar.getTime();
           
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String form = format.format(dt);
         
            pst.setString(1, nama_toko);
            pst.setString(2, alamat);
            pst.setString(3, form);
            pst.setString(4, no_hp);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Berhasil Memperbarui data toko harap login ulang !");
            System.exit(0);
            
            
            
        }catch(SQLException e){
            System.out.println(e);
        }
 
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
