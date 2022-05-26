/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Repository.LaporanPenjualan;
import Repository.ReportInterfce;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author user
 */
public class LaporanService {

    ReportInterfce reportPenjualan = new LaporanPenjualan();
  
   
    public void showLaporanToTable(JTable table) {
       boolean isSuces=false; 
       reportPenjualan.showLaporanToTable(table);
       if(table.getRowCount()==0){
                                  JOptionPane.showMessageDialog(null, "Belum Ada Transaksi Pembelian Product Terjadi !" , "Information" , JOptionPane.INFORMATION_MESSAGE);

       }
       
          
      
      
    }
    public void showLaporanPenjualan(JTable table , String id){
        
        reportPenjualan.showDetailLaporan(table, id);
    }
    public void showLaporanPerbulan(JTable table){
        ReportInterfce report = new LaporanPenjualan();
        report.showLaporanPerBulanIni(table);
        
    }
    public void showLaporanPerhari(JTable table){
        ReportInterfce report = new LaporanPenjualan();
        report.showLaporanPerhariIni(table);
    }
    public void showLaporanPerminggu(JTable table){
        ReportInterfce report = new LaporanPenjualan();
        report.showLaporanPerminggu(table);
    }
    
    
}
