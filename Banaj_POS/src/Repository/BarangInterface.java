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
   void insertTransaksiBeli(String a , String b , String c , String d , int e , String bayar , String kembalian);
   boolean addBarang(String nama_produt ,String kode_product , String harga_beli
            , String harga_jual , String stok , String barang_rusak , String kategori , String supplier);
  //a void deleteBarang();
   String getIdBarang(boolean setNewKode, String kode,JComboBox box);
   public void editBarang(String kode_brg, String nama_product , int stok , int harga_beli , int harga_jual,   int rusak ,  JComboBox kat , JComboBox sup, DataBarangTambah dta,String kode_baru);
   public void deleteBarang(String kode, DataBarangTambah dta);
   public String ambilStringKodeBarang(JComboBox box);
   public void deleteReturn();
   public void addReturn(String kode , String supplier , String rusak);
   public String hitungTotalBarang();
   public boolean cariBarang(String keyword);
   public void deleteBarang();
   public String getIdSupplier(String kode);
   public void TambahBarangBanyak(String kode , String nama , String stok , String harga_beli , String harga_jual ,  String kategori);
   public String getIdBarangTambahBanyak(boolean bol , JComboBox box , JTable tb);
   public void insertDataTambahBanyakProduct(String a , String b , String c);
   public String getKodeKategori(JComboBox box);
   public boolean addBarangBanyak(String nama_produt ,String kode_product , String harga_beli
            , String harga_jual , String stok , String barang_rusak , String kategori , String supplier,DataBarangTambah dt);
   public void setModelRow();
   public void showBarangCombo(JComboBox box);
   public String getIdProductBarcode(String nama);
   public void cetakBarcode(String name);
   public void cariBarangBerdasarkanKategori(String keyword);
   public void cetakBeliBarang(String id);
   public String getStok(String nama_product);
   public String getKodeBarang(JComboBox box);
   public String getHargaBeli(String kode);
   public String getKodeSuppp(String nama);
   public String getKodeKategori(String kode);
   
   public boolean updateStok(String kode , int stok);
   public String getNamaBarang(String kode);
   public int getBarangRusak(String kode);
   public void updateReturnAndBarang(String kode , String jumlahRUsak, String opsi,String rusakNew);
}
