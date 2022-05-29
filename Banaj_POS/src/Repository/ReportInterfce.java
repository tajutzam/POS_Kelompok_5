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
public interface ReportInterfce {
    public boolean showLaporanToTable(JTable table);
    public void showDetailLaporan(JTable table , String id);
    public void showLaporanPerBulanIni(JTable table);
    public void showLaporanPerhariIni(JTable table);
    public void showLaporanPerminggu(JTable table);
    public void cetakLaporanpenjualan(String tanggal , String sampai);
    
}
