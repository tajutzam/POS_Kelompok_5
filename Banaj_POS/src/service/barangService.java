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
import View.Dashbord;
import View.DataBarangTambah;
import View.TambahBanyakBarang;
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
    ImageIcon eroricon =  new ImageIcon(getClass().getResource("/picture/warning.png"));
    BarangInterface barang = new Barang();
    
    BarangInterface br = new Barang();
    
    public  void showBarang(JTable table){
        
        deleteBarangWhenStokHabis();
        br.showBarang(Dashbord.table_barang, "barang");
        br.showBarang(table, "barang");
        Dashbord.txt_totalBrg.setText(br.hitungTotalBarang());
        Object data[]=new Object[7];

    }
    
    public void showReturSupplier(JTable table){
        
        br.showBarang(table, "return");
        
    }
    public void addItemInCombobox(JComboBox box){
        
        BarangInterface br =new Barang();
        br.addComboboxItem(box, "kategori");
        
    }
    
    public boolean addBarang(String nama_produt ,String kode_product , String harga_beli
            , String harga_jual , String stok , String barang_rusak , String kategori , String supplier,DataBarangTambah dt){
             BarangInterface br = new Barang();
             boolean isAdd=false;
             int hargaJual =Integer.parseInt(harga_jual);
             int hargaBeli = Integer.parseInt(harga_beli);
            
             isAdd=br.addBarang(nama_produt, kode_product, harga_beli, harga_jual, stok, barang_rusak, kategori, supplier, dt);
             
             
        return isAdd;
    }
    
    public String getIdBarang(boolean setNewKode, String kode,JComboBox box){
        BarangInterface barang = new Barang();
        String result =barang.getIdBarang(setNewKode, kode, box);
        return result;
    }  
    
    public String setKodeLamaBarangEdit(String kode , JTable table){
        
        DefaultTableModel model = (DefaultTableModel)table.getModel();
     
        int selectedRow =table.getSelectedRow();
        kode += model .getValueAt(selectedRow, 1).toString();
        return kode;

    }
    
    
    public void editBarang(String kode_brg, String nama_product , int stok , int harga_beli , int harga_jual,   int rusak ,  JComboBox kat , JComboBox sup, DataBarangTambah dta,String kode_baru , boolean opsi){
       
        BarangInterface barang = new Barang();
        if(opsi==false){
            
        }else{
             DataBarangTambah.kode_barang_Edit.setText(kode_baru);
        barang.editBarang(kode_brg, nama_product, stok, harga_beli, harga_jual, rusak, kat, sup, dta, kode_baru);
        }
       
    }
    public void deleteBarang(String kode, DataBarangTambah dta){

        BarangInterface barang = new Barang();
        
        barang.deleteBarang(kode, dta);

    }
    public static void main(String[] args) {
        
  
    }
    public String ambilStringKodeBarang(JComboBox box){
        
       BarangInterface barang = new Barang();
       String result =barang.ambilStringKodeBarang(box);
       return result;
    }
    
    public void deleteBarangWhenStokHabis(){
        
      BarangInterface br = new Barang();
        br.deleteBarang();
        
    }
    public void deleteReturn(){
        BarangInterface barang = new Barang();
        barang.deleteReturn();
    }
    public String hitungTotal(){
       BarangInterface barang  = new Barang();
       String total=barang.hitungTotalBarang();
       return total;
    }
    public void resetKeranjang(){
        
    }
    public void cariBarang(String keyWord){
        BarangInterface barang = new Barang();
        
        if(keyWord.equals("")){
            barang.showBarang(Dashbord.table_barang, "barang");
        }else if(keyWord.equals(" ")){
            barang.showBarang(Dashbord.table_barang, "barang");

        }else{
            barang.cariBarang(keyWord);
        }
        
    }
    
    public String getIdSupplier(JComboBox box){
        String nama =box.getSelectedItem().toString();
        BarangInterface barang = new Barang();
        String result =barang.getIdSupplier(nama);
        return result;
    }
    
    public void insertIdTransaksiBeli(String id , String suplier , String tanggal , String kategori){
        BarangInterface barang = new Barang();
        barang.insertTransaksiBeli(id, suplier, tanggal , kategori);
    }
    public String getKodeKategori(JComboBox box){
       BarangInterface barang = new Barang();
       return barang.getKodeKategori(box);
    }
    public boolean tambahDataKetabel(String kode , String nama , String stok , String harga_beli , String harga_jual , String rusak , String box){
     
     boolean isAdd =false;
     String stokString = stok.replaceAll("[0-9]", "");
     String hargabeli =harga_beli.replaceAll("[0-9]", "");
     String hargaJual =harga_jual.replaceAll("[0-9]", "");
     String rusakString = rusak.replaceAll("[0-9]", "");
     BarangInterface barang = new Barang();
     String  kata="";
    

     
     int rusakInt =Integer.parseInt(rusak);
     if(stok.equals(stokString)){
         isAdd=false;
         kata="Harap Isi Stok dengan angka";
     }else if(harga_beli.equals(hargabeli)){
         isAdd=false;
         kata="Harap isi harga beli dengan angka";
     }else if(harga_jual.equals(hargaJual)){
         isAdd=false;
         kata="Harap isi harga jual dengan angka";
     }else if(!nama.equals("")&&!stok.equals("")&&!harga_beli.equals("")&&!harga_jual.equals("")&&!rusak.equals("")){       
         isAdd=true;
     }
     else{
         isAdd=false;
         kata="Harap Isi semua field";
     }
     if(isAdd==true){
         int stokIntbaru =Integer.parseInt(stok);
         int rusakIntbaru =Integer.parseInt(rusak);
         int hargaJualInt=Integer.parseInt(harga_jual);
         int hargaBeliint =Integer.parseInt(harga_beli);
         if(stokIntbaru<=rusakIntbaru){
              System.out.println("baru");
              isAdd=false;
              kata="Stok Tidak boleh lebih sedikit dari pada barang rusak";
              JOptionPane.showMessageDialog(null, kata, "Terjadi Kesalahan !", JOptionPane.ERROR_MESSAGE, eroricon);     

         }else if(hargaBeliint>=hargaJualInt){
              isAdd=false;
              kata="Harga Jual Harus lebih besar ";
              JOptionPane.showMessageDialog(null, kata, "Terjadi Kesalahan !", JOptionPane.ERROR_MESSAGE, eroricon);      
         }else if(stok.equals("0")){
             isAdd=false;
             kata="Stok tidak boleh 0 ";
             JOptionPane.showMessageDialog(null, kata, "Terjadi Kesalahan !", JOptionPane.ERROR_MESSAGE, eroricon); 
         }else if(harga_jual.equals("0")){
              isAdd=false;
              kata="Harga Jual tidak boleh 0 ";
              JOptionPane.showMessageDialog(null, kata, "Terjadi Kesalahan !", JOptionPane.ERROR_MESSAGE, eroricon); 
         }else if(harga_beli.equals("0")){
             isAdd=false;
              kata="Harga beli tidak boleh 0 ";
              JOptionPane.showMessageDialog(null, kata, "Terjadi Kesalahan !", JOptionPane.ERROR_MESSAGE, eroricon); 
         }
         else{
              barang.TambahBarangBanyak(kode, nama, stok.replaceAll("[^0-9]", ""), harga_beli.replaceAll("[^0-9]", ""), harga_jual.replaceAll("[^0-9]", ""), rusak.replaceAll("[^0-9]", ""), box);
         }
     }
     else{
         JOptionPane.showMessageDialog(null, kata, "Terjadi Kesalahan !", JOptionPane.ERROR_MESSAGE, eroricon);     
     }
     return isAdd;  
    }
    public void setModelTable(JTable table){
        Barang barang = new Barang();
        barang.setModelTable(table);
    }
    public String getIdTableAfterAdd(boolean setNewKode , JComboBox box , JTable table){
       
        String result=barang.getIdBarangTambahBanyak(setNewKode, box, table);
       
                return result;
    }
    public void insertDataTambahBanyakProduct(String id , String jumlah , String product){
       
        barang.insertDataTambahBanyakProduct(id, jumlah, product);
    }
    public boolean addBarangBanyak(String nama_produt ,String kode_product , String harga_beli
            , String harga_jual , String stok , String barang_rusak , String kategori , String supplier,DataBarangTambah dt){
      
        return barang.addBarangBanyak(nama_produt, kode_product, harga_beli, harga_jual, stok, barang_rusak, kategori, supplier, dt);
    }
    public void setModelRow(){
        barang.setModelRow();
    }
    
    
}
