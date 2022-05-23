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
        if(report.showLaporanToTable(table)==true){
            
        }else{
                        JOptionPane.showMessageDialog(null, "Belum Ada Transaksi Pembelian Product Terjadi !" , "Information" , JOptionPane.INFORMATION_MESSAGE);

        }
        
        
    }
    
    
}
