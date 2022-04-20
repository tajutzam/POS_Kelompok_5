/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import javax.swing.JTable;
import Repository.*;
import View.DataTambahKategori;
import View.DataTambahSupplier;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 *
 * @author user
 */
public class kategoriService {
    KategoriInterface kategori = new Kategori();
    
    public void showKategori(JTable table){
        
      
      kategori.showKategori(table);
        
    }
    
      
    public void addSupplier(String nama_supplier,String kode,String time, DataTambahKategori dts){
        time =   Timestamp.valueOf(LocalDateTime.now()).toString();
        kategori.addKategori(nama_supplier, kode, time);
        dts.dispose();
        
    }
    public String getPrimaryKey(){
        
        
        String hasil = kategori.getPrimaryKey();
        return hasil;
    }
    
}
