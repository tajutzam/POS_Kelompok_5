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
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class Kategori implements KategoriInterface{
        DatabaseInterface dt = new Database();
        DefaultTableModel model = new DefaultTableModel();
        ImageIcon suscesicon =  new ImageIcon(getClass().getResource("/picture/checked.png"));
        ImageIcon eroricon =  new ImageIcon(getClass().getResource("/picture/warning.png"));

        @Override
    public String getCodeKategori(JComboBox box) {
    
        
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

    @Override
    public void showKategori(JTable table) {
        int no=0;
        
        
        model.addColumn("No");
        model.addColumn("Kode Kategori");
        model.addColumn("Nama Kategori");
        
        String sql="select kode_kategori, nama_kategori from kategori order by kode_kategori asc";
        try(Connection con =dt.conectDatabase();
            Statement st =con.createStatement();
            ResultSet res =st.executeQuery(sql)){
            
            
            while(res.next()){
              no++;
              model.addRow(new Object[]{
                          no,
                          res.getString("kode_kategori"),
                          res.getString("nama_kategori"),
                          });

                          }
            
            table.setModel(model);

        }catch(SQLException e){
            
        }
    }

    @Override
    public void addKategori(String name , String kode , String time) {
        
        String sql="insert into kategori values (? , ? , ? , ?)";
        
        
        try(Connection con = dt.conectDatabase();
            PreparedStatement pst = con.prepareStatement(sql);
            ){
            pst.setString(1, kode);
            pst.setString(2, name);
            pst.setString(3, time);
            pst.setString(4, time);
            
            pst.execute();
            JOptionPane.showMessageDialog(null, "Berhasil Menambahkan Kategori","succes", JOptionPane.INFORMATION_MESSAGE, suscesicon);

        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Gagal Menambahkan Kategori","Terjadi Kesalahan", JOptionPane.INFORMATION_MESSAGE, eroricon);
            
        }
        
    }
      public String getPrimaryKey(){
        
        
        String sql_getKodeBarang="select kode_kategori from kategori order by kode_kategori desc limit 1";
        try(Connection con = dt.conectDatabase();
            PreparedStatement pst = con.prepareStatement(sql_getKodeBarang);
            ResultSet res = pst.executeQuery(sql_getKodeBarang);){
          
          
            

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
  
            return hsl.toUpperCase();
            
        }catch(SQLException err){
            return err.getMessage();
        }
        
        

    }

    @Override
    public void sendToEdit(String kode , String nama_kategori , String time ) {
       
        String sql ="select kode_kategori , nama_kategori , update_at from kategori where kode_kategori = '"+kode+"'";
        try(Connection con = dt.conectDatabase();
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(sql)){
            
            if(res.next()){
                kode =res.getString("kode_kategori");
                nama_kategori =res.getString("nama_kategori");
                time =res.getString("update_at");
                
            }
            
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Gagal Update Kategori"+e.getMessage(), "Terjadi Kesalahan", JOptionPane.INFORMATION_MESSAGE, eroricon);
        }
      
        
        
        
    }

    @Override
    public String getKodeKategori(JTable table) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        @Override
    public void editKategori(String kode , String nama_kategori){
        String sqlUpdate="update kategori set nama_kategori = ?  where kode_kategori =?";
        try(Connection con = dt.conectDatabase();
            PreparedStatement pst = con.prepareStatement(sqlUpdate)){
            
            pst.setString(1, nama_kategori);
            pst.setString(2, kode);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Berhasil Memperbarui Kategori , ","Succes", JOptionPane.INFORMATION_MESSAGE, suscesicon);
        }catch(SQLException e){
          JOptionPane.showMessageDialog(null, "Gagal Memperbarui Kategori"+e.getMessage(), "Terjadi Kesalahan", JOptionPane.ERROR_MESSAGE, eroricon);

        }
        
    }
  
    
    
      
   

}
