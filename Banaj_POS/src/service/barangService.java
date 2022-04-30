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
    BarangInterface br = new Barang();
    
    public  void showBarang(JTable table){
       
        br.showBarang(table, "barang");
        Dashbord.txt_totalBrg.setText(br.hitungTotalBarang());
        
        
    }
    public void showReturSupplier(JTable table){
        br.showBarang(table, "return");
        
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
    
    
    public void editBarang(String kode_brg, String nama_product , int stok , int harga_beli , int harga_jual,   int rusak ,  JComboBox kat , JComboBox sup, DataBarangTambah dta,String kode_baru){
       
        BarangInterface barang = new Barang();
      
        
       
        barang.editBarang(kode_brg, nama_product, stok, harga_beli, harga_jual, rusak, kat, sup, dta, kode_baru);
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
}
