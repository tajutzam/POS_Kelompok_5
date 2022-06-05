/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import javax.swing.JTable;
import Repository.*;
import View.Dashbord;
import View.DataBarangTambah;
import View.DataTambahKategori;
import View.DataTambahSupplier;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.InputMismatchException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */

public class kategoriService {
    KategoriInterface kategori = new Kategori();
        ImageIcon suscesicon =  new ImageIcon(getClass().getResource("/picture/checked.png"));
        ImageIcon eroricon =  new ImageIcon(getClass().getResource("/picture/warning.png"));
    public void showKategori(JTable table){
        
      
      kategori.showKategori(table);
      String totalKategori=hitungTotalKategori();
      Dashbord.txt_totalKategori.setText(totalKategori);
        
    }
  
    public boolean addSupplier(String nama_supplier,String kode,String time){
        boolean isAdd=false;
        time =   Timestamp.valueOf(LocalDateTime.now()).toString();
        
        if(nama_supplier.equals("")){
            JOptionPane.showMessageDialog(null, "Harap Isi From dengan benar", "Information", JOptionPane.INFORMATION_MESSAGE);
            isAdd=false;
        }else{
            kategori.addKategori(nama_supplier, kode, time);
            isAdd=true;
        }
       return isAdd;
        
    }
    public String getPrimaryKey(){

        String hasil = kategori.getPrimaryKey();
        return hasil;
    }

     public String setKodeLamaKategoriEdit(String kode , JTable table){
        
        DefaultTableModel model = (DefaultTableModel)table.getModel();
     
        int selectedRow =table.getSelectedRow();
        kode = model .getValueAt(selectedRow, 1).toString();

        return kode;

    }
     public void sendDataKategori(String kode , String nama , String time){
         
         
         kategori.sendToEdit(kode, nama, time);
        
     }
     public void editKategori(String kode_kategori , String nama_kategori , String nama_kategoriLama , DataTambahKategori dts){
         try{
           if(!nama_kategori.equals(nama_kategoriLama)){
               if(nama_kategori.length()<4){
                   throw new InputMismatchException(" Kategori tidak boleh kurang dari 4 ");
               }else{
                   kategori.editKategori(kode_kategori, nama_kategori);
                   dts.dispose();
               }
               
         }else{
               throw new InputMismatchException("Gagal Memperbarui, tidak ada perubahan !");
         }  
         }catch(InputMismatchException e){
                          JOptionPane.showMessageDialog(null, "Gagal Memperbarui ,Tidak ada perubahan pada kategori" , "Terjadi Kesalahan", JOptionPane.ERROR_MESSAGE,eroricon );

         }
         
       
     }
     public void deleteKategori(String kode ){
        KategoriInterface ka = new Kategori();
        ka.deleteKategori(kode ,new DataTambahKategori());
       
     }
     public String hitungTotalKategori(){
         String total =kategori.hitungTotalKategori();
         return total;
     }
     public boolean cariKategori(String keyword){
         KategoriInterface kategori = new Kategori();
        boolean isSuces=false;
         if(keyword.equals("")){
             kategori.showKategori(Dashbord.tabel_kategori);
             isSuces=false;  
         }else if(keyword.equals(" ")){
             kategori.showKategori(Dashbord.tabel_kategori);
             isSuces=false;
         }else{
              isSuces=true;
              isSuces =kategori.cariKategori(keyword);
         }
         
         return isSuces;
     }
     public String getKodeKategori(){
         KategoriInterface kategori = new Kategori();
         return kategori.getCodeKategori(DataBarangTambah.combo_kategori);
     }
    
}
