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
    public void addIdTransaksi(String id,String a , String b , String c , String d);
    public boolean cariBarang(String keyword , JTable table  , String opsi);
    public String selectToOrder(String kode);
    public void addProductToKeranjang(String kode );
    public void insertOrder();
    public void insertDataOrder(String id , String kode , String subTotal ,String qty);
    public void cetakStruct(String kode ,String diskon , String kasir);
    
}
