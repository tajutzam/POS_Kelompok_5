/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import View.DataBarangTambah;
import java.sql.Date;
import javax.swing.JComboBox;
import javax.swing.JTable;

/**
 *
 * @author user
 */
public interface BarangInterface {
   void showBarang(JTable table,String opsi);
   void addComboboxItem(JComboBox box , String opsi);
   void addBarang(String nama_produt ,String kode_product , String harga_beli
            , String harga_jual , String stok , String barang_rusak , String kategori , String supplier,DataBarangTambah dt);
   void deleteBarang();
   String getIdBarang(boolean setNewKode, String kode,JComboBox box);
   public void editBarang(String kode_brg, String nama_product , int stok , int harga_beli , int harga_jual,   int rusak ,  JComboBox kat , JComboBox sup, DataBarangTambah dta,String kode_baru);
   public void deleteBarang(String kode, DataBarangTambah dta);
   public String ambilStringKodeBarang(JComboBox box);
   public void deleteReturn();
   public void addReturn(String kode , String supplier , String rusak);
   public String hitungTotalBarang();
}
