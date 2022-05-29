/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Repository.LaporanPembelian;
import Repository.ReportInterfce;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author user
 */
public class LaporanPembelianServicce {

    ReportInterfce report = new LaporanPembelian();
    
    public void showLaporanToTable(JTable table) {
        report.showLaporanToTable(table);
        if(table.getRowCount()==0){
                                    JOptionPane.showMessageDialog(null, "Belum Ada Transaksi Pembelian Product Terjadi !" , "Information" , JOptionPane.INFORMATION_MESSAGE);

        }
       
        
        
    }
    public void showDetailPembelian(JTable table , String id){
        report.showDetailLaporan(table, id);
    }
    public void showLaporanPerbulan(JTable table){
        report.showLaporanPerBulanIni(table);
    }
    public void showLaporanPerhari(JTable table){
        report.showLaporanPerhariIni(table);
    }
    public void showLaporanPerminggu(JTable table){
        report.showLaporanPerminggu(table);
    }
    public void cetakLaporanPembelian(String dari , String sampai){
        report.cetakLaporanpenjualan(sampai, sampai);
    }
    
}
