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
import View.Dashbord;
import View.DataBarangTambah;
import View.DataTambahSupplier;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
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
        String total = sup.hitungTotalSupplier();
        Dashbord.txt_totalSupplier.setText(total);
    }
    public void addItemSupplier(JComboBox box){
        
        BarangInterface br = new Barang();
        br.addComboboxItem(box, "supplier");
        
    }
    public boolean addSupplier(String nama_supplier,String kode,String time){
        time =   Timestamp.valueOf(LocalDateTime.now()).toString();
        boolean isAdd=false;
        if(nama_supplier.equals("")){
           JOptionPane.showMessageDialog(null, "Harap Isi From dengan benar", "Information", JOptionPane.INFORMATION_MESSAGE);
           isAdd=false;
        }else{
                  sup.addSupplier(nama_supplier,kode,time);
                  isAdd=true;
  
        }
        return isAdd;
        
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
         
      }
      public String getNamaSupplier(String kode){
          SupplierInterface sup = new Supplier();
          String nama=sup.tampilkanNamaSupplier(kode);
          return nama;
      }
      public boolean cariSupplier(String keyword){
          boolean isSucses =false;
          
          SupplierInterface suplier = new Supplier();
          isSucses=suplier.cariSupplier(keyword);
          return isSucses;
      }
      public String getKodeSupplier(){
          SupplierInterface sup = new Supplier();
         return sup.getKodeSupplier(DataBarangTambah.combo_supplier);
      }
}
