/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import javax.swing.JTable;

/**
 *
 * @author user
 */


public interface OrderInterface {
    public void addIdTransaksi(String id,String a , String b , String c , String d,String e);
    public boolean cariBarang(String keyword , JTable table  , String opsi);
    public String selectToOrder(String kode);
    public void addProductToKeranjang(String kode );
    public void insertOrder();
    public void insertDataOrder(String id , String kode , String subTotal ,String qty , int subPembelian);
    public void cetakStruct(String kode ,String diskon  , String harga);
    public void cetakStructPembelian(String transaksi);
    public String showPenjualan(int indek);
  
    public String getUntung();
    public String getPengeluaran();
    public int showPenjualanint(int indek);
    public void barangPalingBanyakDiminati(JTable table);
    public String showKategoriPalingBanyakDiminati();
    public void showKategoritotable();
    public void barangPalingBanyakDiminatiKategori(JTable table);
    public void barangPalingBanyakDiminatikeyword(String keyword , JTable table);
    public String getSaranStokMenurutBulanI(String kategori , String product);
    
  
}
