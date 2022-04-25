/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import javax.swing.JComboBox;
import javax.swing.JTable;

/**
 *
 * @author user
 */
public interface SupplierInterface {
    
    String getKodeSupplier(JComboBox box);
    public void showSuplier(JTable table);
    public void addSupplier(String nama_supplier,String kode,String time);
    public String getPrimaryKey();
    public void editSupplier(String kode , String nama , String time);
    
    public void tampilkanDataKeEdit();
    public void deleteSupplier(String kode);
    public String hitungTotalSupplier();
}
