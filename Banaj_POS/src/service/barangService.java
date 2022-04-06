/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Repository.Barang;
import Repository.BarangInterface;
import Repository.Database;
import Repository.DatabaseInterface;
import Util.tanggalSaatIni;
import View.DataBarangTambah;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class barangService {
    DatabaseInterface dt = new Database();
    ImageIcon suscesicon =  new ImageIcon(getClass().getResource("/picture/checked.png"));
    
    
    public  void showBarang(JTable table){
        BarangInterface br = new Barang();
        br.showBarang(table, "barang");
    }
    public void addItemInCombobox(JComboBox box){
        
        BarangInterface br =new Barang();
        br.addComboboxItem(box, "kategori");
        
    }
    public void addBarang(String nama_produt ,String kode_product , String harga_beli
            , String harga_jual , String stok , String barang_rusak , String kategori , String supplier,DataBarangTambah dt){
             BarangInterface br = new Barang();
        
             br.addBarang(nama_produt, kode_product, harga_beli, harga_jual, stok, barang_rusak, kategori, supplier,dt);

    }
    
    public String getIdBarang(boolean setNewKode, String kode,JComboBox box){
          String hsl = "";
         String kodeKategori="";
          
         String namaKategoriTmp ;
         String namaKategoriResult;
         String hurufKategori="";
         String sqlGetKodeKat ="select kode_kategori from kategori where nama_kategori = '"+box.getSelectedItem().toString()+"'";
         try(Connection con = dt.conectDatabase();
             Statement st = con.createStatement() ;
             ResultSet res =st.executeQuery(sqlGetKodeKat)    ){
             
             if(res.next()){
                 kodeKategori=res.getString("kode_kategori");
                 
             }
             
             
         }catch(SQLException e){
             System.out.println(e.getMessage());
         }
         
         
         
         String sqlNamaKategori="select nama_kategori from kategori where kode_kategori = '"+kodeKategori+"'";
         
         try(Connection con = dt.conectDatabase();
                 Statement st = con.createStatement();
                 ResultSet resi = st.executeQuery(sqlNamaKategori))
         {
             while(resi.next()){
                 namaKategoriTmp = resi.getString("nama_kategori"); 
                 char a =namaKategoriTmp.charAt(0);
                 char b = namaKategoriTmp.charAt(2);
                 char c = namaKategoriTmp.charAt(namaKategoriTmp.length()-1);
                 String finalA =Character.toString(a);
                 String finalB =Character.toString(b);
                 String finalC =Character.toString(c);
                 hurufKategori = finalA+finalB+finalC;
             }
         }catch(SQLException e){
             System.out.println(e.getMessage());
         }   
             
        String sql_getKodeBarang = "SELECT kode_product FROM product where kategori='"+kodeKategori+"' ORDER BY kode_product DESC LIMIT 1";
        try(Connection con = dt.conectDatabase();
            PreparedStatement pst = con.prepareStatement(sql_getKodeBarang);
            ResultSet res = pst.executeQuery(sql_getKodeBarang);){
          
            if(setNewKode==false){
                
             
            if(res.next()){
                String a = res.getString(1).replaceAll("[a-zA-Z]", "");
                String b = "";
                String c[] = a.split("(?!^)");
                String u = "";

                if("0".equals(c[0])){
                    if("0".equals(c[1])){
                        if("0".equals(c[2])){
                            b = c[3];
                        }else{
                            b = c[2]+c[3];
                        }
                    }else{
                        b = c[1]+c[2]+c[3];
                    }
                }else{
                    b = a;
                }

                int d = Integer.parseInt(b)+1;

                if(d <= 9){
                    u = "000";
                }else if(d <= 99 ){
                    u = "00";
                }else if(d <= 999){
                    u = "0";
                }else{
                    u = "";
                }
                hsl = u+""+d;
            }else{
                hsl = "0001";
            }
                
            }else if(setNewKode==true){
           
            if(res.next()){
                String a = res.getString(1).replaceAll("[a-zA-Z]", "");
                String b = "";
                String c[] = a.split("(?!^)");
                String u = "";

                if("0".equals(c[0])){
                    if("0".equals(c[1])){
                        if("0".equals(c[2])){
                            b = c[3];
                        }else{
                            b = c[2]+c[3];
                        }
                    }else{
                        b = c[1]+c[2]+c[3];
                    }
                }else{
                    b = a;
                }

                int d = Integer.parseInt(b)+1;

                if(d <= 9){
                    u = hurufKategori+"000";
                }else if(d <= 99 ){
                    u = hurufKategori+"00";
                }else if(d <= 999){
                    u = hurufKategori+"0";
                }else{
                    u = hurufKategori;
                }
                hsl = u+""+d;
            }else{
                hsl = hurufKategori+"0001";
            }
            }
           
          
            
            return hsl.toUpperCase();
            
        }catch(SQLException err){
            return err.getMessage();
        }
    
      }  
    
    public String setKodeLamaBarangEdit(String kode , JTable table){
        
        DefaultTableModel model = (DefaultTableModel)table.getModel();
     
        int selectedRow =table.getSelectedRow();
        kode += model .getValueAt(selectedRow, 1).toString();
        return kode;
        
        
    }
    
    
    public void editBarang(String kode_brg, String nama_product , int stok , int harga_beli , int harga_jual,   int rusak ,  JComboBox kat , JComboBox sup, DataBarangTambah dta,String kode_baru){
        String kode_kategori=""; 
        String kode_supplier ="";
        tanggalSaatIni tg = new tanggalSaatIni();
        // query untuk menampilkan kode product dan supplier
        String sqlShowProduct="select * from product where kode_product ='"+kode_brg+"'";
        // sql untuk update product
        String sql ="update product set nama_product =? ,stok =? , " 
                +"harga_beli = ? , harga_jual=?, supplier=?, "        
                +"kategori =?, update_at =? , rusak =?, kode_product=? where kode_product ='"+kode_brg+"'";
        //
        String sqlShow ="select kode_kategori from kategori where nama_kategori ='"+kat.getSelectedItem().toString()+"'";
        String sqlShowSup ="select kode_supplier from supplier where nama_supplier ='"+sup.getSelectedItem().toString()+"'";
        try (Connection con = dt.conectDatabase();
                
            Statement stShow =con.createStatement(); 
            Statement stSup = con.createStatement();
            Statement stKat = con.createStatement();
                
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet resKat = stKat.executeQuery(sqlShow);
            ResultSet rsShowProduct =stShow.executeQuery(sqlShowProduct);
            ResultSet resSup = stSup.executeQuery(sqlShowSup);
                
            ){
            
           
            
            while(rsShowProduct.next()){
                if(resKat.next()){
                     kode_kategori =resKat.getString("kode_kategori");  
                }
                if(resSup.next()){
                      kode_supplier=resSup.getString("kode_supplier");
                }
           
            }
            
           
            
            pst.setString(1, nama_product);
            pst.setInt(2, stok);
            pst.setInt(3, harga_beli);
            pst.setInt(4, harga_jual);
            System.out.println(kode_kategori);
            pst.setString(5, kode_supplier);
            pst.setString(6, kode_kategori);
            pst.setTimestamp(7, new Timestamp(System.currentTimeMillis()));
            pst.setInt(8, rusak);
            pst.setString(9, kode_baru);
            pst.execute(); 
            
            JOptionPane.showMessageDialog(null, "Data Product Berhasil Diperbarui, Silakan Refresh Kembali !", "Success !", JOptionPane.INFORMATION_MESSAGE, suscesicon);
            dta.dispose();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
    }
    public void deleteBarang(String kode, DataBarangTambah dta){
        
        int resetData = JOptionPane.showOptionDialog(null, "Apakah Anda Yakin Ingin Menghapus product ?", "Informasi !", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
        if(resetData==0){
            String sql ="delete from product where kode_product = ?";
            try(Connection con = dt.conectDatabase();
            PreparedStatement pst =con.prepareStatement(sql);)
            {
               pst.setString(1, kode);
               pst.executeUpdate();
           
               JOptionPane.showMessageDialog(null, "Product Berhasil Dihapus Silahkan Refresh !", "Sukses !", JOptionPane.INFORMATION_MESSAGE,suscesicon);
               dta.dispose();
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Product gagal di hapus !","Eror !",JOptionPane.WARNING_MESSAGE);
            }
            
        }
        
        
        
        
    
        
        
    }
    public static void main(String[] args) {
        
  
    }
    public String ambilStringKodeBarang(JComboBox box){
        
         String kodeKategori="";
          
         String namaKategoriTmp ;
         String namaKategoriResult;
         String hurufKategori="";
         String sqlGetKodeKat ="select kode_kategori from kategori where nama_kategori = '"+box.getSelectedItem().toString()+"'";
         try(Connection con = dt.conectDatabase();
             Statement st = con.createStatement() ;
             ResultSet res =st.executeQuery(sqlGetKodeKat)    ){
             
             if(res.next()){
                 kodeKategori=res.getString("kode_kategori");
                 
             }
             
             
         }catch(SQLException e){
             System.out.println(e.getMessage());
         }
       
         String sqlNamaKategori="select nama_kategori from kategori where kode_kategori = '"+kodeKategori+"'";
         
         try(Connection con = dt.conectDatabase();
                 Statement st = con.createStatement();
                 ResultSet resi = st.executeQuery(sqlNamaKategori))
         {
             while(resi.next()){
                 namaKategoriTmp = resi.getString("nama_kategori"); 
                 char a =namaKategoriTmp.charAt(0);
                 char b = namaKategoriTmp.charAt(2);
                 char c = namaKategoriTmp.charAt(namaKategoriTmp.length()-1);
                 String finalA =Character.toString(a);
                 String finalB =Character.toString(b);
                 String finalC =Character.toString(c);
                 hurufKategori = finalA+finalB+finalC;
             }
         }catch(SQLException e){
             System.out.println(e.getMessage());
         }   
        return hurufKategori.toUpperCase();
        
    }
}
