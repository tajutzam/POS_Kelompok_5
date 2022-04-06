/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import Util.tanggalSaatIni;
import View.Dashbord;
import View.DataBarangTambah;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author user
 */

public class Barang implements BarangInterface{
    Database dt = new Database();
    tanggalSaatIni tg = new tanggalSaatIni();
    

    @Override
    public  void showBarang(JTable table,String opsi) {
        DefaultTableModel model = new DefaultTableModel();
       
       
        int no =1;
        
        try{
          //  sql = "SELECT barang.kode_barang, barang.nama_barang, kategori.nama_kategori, barang.harga, barang.stok, supplier.nama_supplier FROM barang JOIN kategori ON barang.kategori = kategori.id_kategori JOIN supplier ON barang.supplier = supplier.id_supplier ORDER BY barang.nama_barang ASC";
            String sqlKat ="select * from kategori";
            String sqlSup ="select * from supplier";
            String sqlsh ="select * from product";
            String sql = "select product.kode_product,product.nama_product, product.harga_jual,product.harga_beli,product.stok,supplier.nama_supplier,kategori.nama_kategori from product join kategori on product.kategori = kategori.kode_kategori join supplier on product.supplier = supplier.kode_supplier order by product.kode_product asc ";
            String sqlKategori ="select kode_kategori, nama_kategori from kategori order by kode_kategori asc";
            String sqlSupplier ="select kode_supplier, nama_supplier from supplier order by kode_supplier asc";
            
            Connection con = dt.conectDatabase();
            Statement st =con.createStatement();
            Statement sta = con.createStatement();
            Statement stkat = con.createStatement();
            Statement stSup = con.createStatement();
            ResultSet res = st.executeQuery(sql);
            ResultSet res2 = sta.executeQuery(sqlsh);
            ResultSet resK = stkat.executeQuery(sqlKat);
            ResultSet resSup = stSup.executeQuery(sqlSup);
                    
            
                //akan menampilkan data barang
                if(opsi.equals("barang")){ 
                    
                    res=st.executeQuery(sql);
                    model.addColumn("No");
                    model.addColumn("Kode Barang");
                    model.addColumn("Nama Barang");
                    model.addColumn("Stok");
                    model.addColumn("Harga Beli");
                    model.addColumn("Harga Jual");
                    model.addColumn("Supplier");
                    model.addColumn("Kategori");
                    
                    if(res2.next()){
                        
                        while(res.next()){
                           
                        model.addRow(new Object[]{
                        no,res.getString("kode_product"),
                        res.getString("nama_product"),
                        res.getString("stok"),
                        res.getString("harga_beli"),
                        res.getString("harga_jual"),
                        res.getString("supplier.nama_supplier"),
                        res.getString("kategori.nama_kategori"),
                        });
                        no++; 
                        }
                       

                      
                
                        
                        
                    }else{
                        
                        JOptionPane.showMessageDialog(null, "Barang Kosong Silahkan Tambah Barang", "Information", JOptionPane.OK_OPTION);

                    }
                    
                  
                    
                //akan menampilkan data kategori  
                }else if(opsi.equals("kategori")){
                    res=st.executeQuery(sqlKategori);
                    
                    model.addColumn("No");
                    model.addColumn("Kode Kategori");
                    model.addColumn("Nama Kategori");
          
                    if(resK.next()){
                        while(res.next()){
                          model.addRow(new Object[]{
                          no,
                          res.getString("kode_kategori"),
                          res.getString("nama_kategori"),
                          });

                          no++; 
                        }
                       
                        
                    }else{
                     JOptionPane.showMessageDialog(null, "Kategori Kosong Silahkan Tambah Kategori", "Information", JOptionPane.OK_OPTION);

                    }
                    

                con.close();
                st.close();
                res.close();
                }else if(opsi.equals("supplier")){
                    res=st.executeQuery(sqlSupplier);
                    model.addColumn("No");
                    model.addColumn("Kode Supplier");
                    model.addColumn("Nama Supplier");
                    if(resSup.next()){
                         while(res.next()){
                           model.addRow(new Object[]{
                           no,
                           res.getString("kode_supplier"),
                           res.getString("nama_supplier")
                           
                       });
                        
                    }
                    }else{
                    JOptionPane.showMessageDialog(null, "Supplier Kosong Silahkan Tambah Supplier", "Information", JOptionPane.OK_OPTION);

                    }
                    
                   

                con.close();
                st.close();
                res.close();
                
                    
                }

            table.setModel(model);
        }catch(SQLException exception){
            JOptionPane.showMessageDialog(null, exception.getMessage());
        }
       
        
       
    }

    @Override
    public void addComboboxItem(JComboBox box, String opsi) {
           
        try{
             Connection con = dt.conectDatabase();
             Statement st =con.createStatement();
             ResultSet res;
        
            if(opsi.equals("kategori")){
            
             String sql ="select nama_kategori from kategori";
             res=st.executeQuery(sql);
             while(res.next()){
                 box.addItem(res.getString("nama_kategori"));   
                 
             }
             con.close();
             st.close();
             res.close();
    
        }
            else if(opsi.equals("supplier")){
                String sql ="select nama_supplier from supplier";
                res =st.executeQuery(sql);
                while(res.next()){
                    box.addItem(res.getString("nama_supplier"));
                }
             con.close();
             st.close();
             res.close();
            }
            
        }catch(SQLException e){
            
            
        }
        
    }

    @Override
    public void addBarang(String nama_produt ,String kode_product , String harga_beli
            , String harga_jual , String stok , String barang_rusak  , String kategori , String supplier , DataBarangTambah dta) {
       
       boolean isNotMatch=false;
       
       
         
         
         
       String sqlInsert="Insert into product (`kode_product`, `nama_product`, `stok`, `harga_beli`, `harga_jual`, `supplier`, `kategori`, `create_at`, `update_at`, `rusak`)"
               + " values (? , ? , ? , ? , ? , ? , ? , ? , ? , ?)";
       
     
           
       
           try(Connection con = dt.conectDatabase();
           PreparedStatement pst =con.prepareStatement(sqlInsert)){
           
     
            if(!nama_produt.equals("")&&!harga_beli.equals("")&&!harga_jual.equals("")&&!stok.equals("")&&!barang_rusak.equals(""))  {
                if(barang_rusak.equals("")){
                    throw  new SQLException("Data tidak Boleh kosong ");
                }
    
            pst.setString(1, kode_product.toUpperCase());
            pst.setString(2, nama_produt);
            pst.setString(3, stok.replaceAll("[^a-zA-Z0-9]", "").replaceAll("[a-zA-Z]", ""));

            harga_beli.replaceAll("[^a-zA-Z0-9]", "").replaceAll("[a-zA-Z]", "");
            harga_jual.replaceAll("[^a-zA-Z0-9]", "").replaceAll("[a-zA-Z]", "");
            int harga_b =Integer.parseInt(harga_beli);
            int harga_j =Integer.parseInt(harga_jual);
            
            if(harga_b >= harga_j){
                throw new SQLException("Harga Jual tidak memungkingkan Input ulang !!");
            }
            pst.setString(4, harga_beli);
            pst.setString(5, harga_jual);

            pst.setString(6, supplier);
            pst.setString(7, kategori);
            pst.setTimestamp(8, Timestamp.valueOf(LocalDateTime.now()));
            pst.setTimestamp(9,Timestamp.valueOf(LocalDateTime.now()));
            pst.setString(10, barang_rusak.replaceAll("[^a-zA-Z0-9]", "").replaceAll("[a-zA-Z]", ""));
            pst.execute();
       
            JOptionPane.showMessageDialog(null, "berhasil Menambahkan Barang dengan nama "+nama_produt+"","Susces",JOptionPane.INFORMATION_MESSAGE);
            dta.dispose();
          
            }  else{
                throw new SQLException("Data tidak boleh kosong ");
            }
               
           
             
         

           
           
          
           
           
           
       }catch(SQLException e){
              JOptionPane.showMessageDialog(null, e.getMessage(), "Terjadi Kesalahan !", JOptionPane.INFORMATION_MESSAGE);
       }
        
    }
    
    
    
    
    
    
}
