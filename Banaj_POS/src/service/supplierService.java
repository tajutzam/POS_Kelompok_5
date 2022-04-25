/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Repository.Barang;
import Repository.BarangInterface;
import Repository.KategoriInterface;
import Repository.Supplier;
import Repository.SupplierInterface;
import View.DataTambahSupplier;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author user
 */
public class supplierService {
    SupplierInterface sup = new Supplier();
    
    public void showSupplier(JTable table){
        
        sup.showSuplier(table);
    }
    public void addItemSupplier(JComboBox box){
        
        BarangInterface br = new Barang();
        br.addComboboxItem(box, "supplier");
        
    }
    public void addSupplier(String nama_supplier,String kode,String time, DataTambahSupplier dts){
        time =   Timestamp.valueOf(LocalDateTime.now()).toString();
        sup.addSupplier(nama_supplier,kode,time);
        dts.dispose();
        
    }
    public String getKode(){
        String kode =sup.getPrimaryKey();
        return kode;
    }
     public String setKodeSupplierEdit(String kode , JTable table){
        
        DefaultTableModel model = (DefaultTableModel)table.getModel();
     
        int selectedRow =table.getSelectedRow();
        kode = model .getValueAt(selectedRow, 1).toString();

        return kode;

    }
      public String setKodeLamaSupplierEdit(String kode , JTable table){
        
        DefaultTableModel model = (DefaultTableModel)table.getModel();
     
        int selectedRow =table.getSelectedRow();
        kode = model .getValueAt(selectedRow, 1).toString();

        return kode;

      }
      public void editSupplier(String kode , String nama , String time , DataTambahSupplier dt){
          SupplierInterface suplier = new Supplier();
          suplier.editSupplier(kode, nama, time);
          dt.dispose();
      }
      public void deleteSupplier(String kode , DataTambahSupplier dt){
          SupplierInterface sup = new Supplier();
          
          sup.deleteSupplier(kode);
          dt.dispose();
      }
}
