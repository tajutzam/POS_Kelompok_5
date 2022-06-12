/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import Util.Bulan;
import Util.DateApp;
import View.TransaksiPenjualan;
import com.barcodelib.barcode.Linear;
import java.awt.Color;
import java.io.File;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author user
 */
public class LaporanPenjualan implements ReportInterfce{
    
    
    DatabaseInterface dt = new Database();
   
    String data[] = new String[3];
    

    @Override
    public boolean showLaporanToTable(JTable table) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No");
        model.addColumn("ID Transaksi");
        model.addColumn("Nama Kasir");
        model.addColumn("Tanggal Transaksi");
        model.addColumn("Grand Total");
        table.setRowHeight(30);
        table.setForeground(new Color(90, 90, 90));
        boolean isSuces =false;
        String sql="select transaksi.id_transaksi , pegawai.nama_pegawai ,transaksi.tanggal_transaksi , transaksi.grand_total from pegawai join transaksi on pegawai.id_pegawai = transaksi.id_pegawai order by transaksi.tanggal_transaksi asc  ";
        int no=0;
        try(Connection con = dt.conectDatabase();
                Statement st = con.createStatement();
                ResultSet res = st.executeQuery(sql)){
           
            while(res.next()){
                no++;
                model.addRow(new Object[]{
                 no,
                 res.getString("id_transaksi"),
                 res.getString("pegawai.nama_pegawai"),
                 res.getString("tanggal_transaksi"),
                 ("Rp."+res.getString("grand_total")),
                 
                    
                    
                });
            }
            table.setModel(model);
        }catch(SQLException e){
            System.out.println(e);  
        }
        return isSuces;
        
        
    }

    @Override
    public void showDetailLaporan(JTable table , String id) {
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nama Barang ");
        model.addColumn("Qty");
        model.addColumn("Sub Total");
        
        
        
        String sql ="select transaksi.bayar , transaksi.kembali , transaksi.tanggal_transaksi , transaksi.id_transaksi , pegawai.nama_pegawai , product.nama_product , detail_transaksi.qty ,detail_transaksi.sub_total,  transaksi.grand_total from detail_transaksi join transaksi on detail_transaksi.id_transaksi = transaksi.id_transaksi join pegawai on pegawai.id_pegawai = transaksi.id_pegawai join product on product.kode_product = detail_transaksi.kode_product where transaksi.id_transaksi ='"+id+"'";
        try(Connection con = dt.conectDatabase();
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(sql)){
        String tanggal="";   
        String nama="";
        String bayar="";
        String kembalian="";
        String total="";
            
        
             
        
        while(res.next()){
            
             tanggal=res.getString("tanggal_transaksi");
             nama=res.getString("pegawai.nama_pegawai");
             bayar=res.getString("bayar");
             kembalian=res.getString("kembali");
             total=res.getString("grand_total");
             
            model.addRow(new Object[]{
                res.getString("product.nama_product"),
                res.getString("detail_transaksi.qty"),
                res.getString("detail_transaksi.sub_total")
               
            });
            
        }
        
            TransaksiPenjualan.tanggal_kasir.setText(tanggal);
            TransaksiPenjualan.nama_kasir_value.setText(nama);
            TransaksiPenjualan.grand_totalVlue.setText(total);
            TransaksiPenjualan.bayar_value.setText(bayar);
            TransaksiPenjualan.kembalian_value.setText(kembalian);
        
        table.setModel(model);
            
        }catch(SQLException e){
            System.out.println(e);
        }
    
    }

    @Override
    public void showLaporanPerBulanIni(JTable table) {
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No");
        model.addColumn("ID Transaksi");
        model.addColumn("Nama Kasir");
        model.addColumn("Tanggal Transaksi");
        model.addColumn("Grand Total");
        
        Bulan bulan = new Bulan();
        String indek = String.valueOf(bulan.getindexBulan());
        if(indek.startsWith("0")){
            indek.replaceAll("0","");
        }
        String sql="select transaksi.id_transaksi , pegawai.nama_pegawai ,transaksi.tanggal_transaksi , transaksi.grand_total from pegawai join transaksi on pegawai.id_pegawai = transaksi.id_pegawai  where transaksi.bulan="+indek+" ORDER by tanggal_transaksi DESC";
        try(Connection con = dt.conectDatabase();
            Statement st = con.createStatement();
                ResultSet res = st.executeQuery(sql)){
         
          
              int no=0;
                while(res.next()){
                     no++;
                     model.addRow(new Object[]{
                     no,
                     res.getString("id_transaksi"),
                 res.getString("pegawai.nama_pegawai"),
                 res.getString("tanggal_transaksi"),
                 ("Rp."+res.getString("grand_total")),

                });
       
            
            
        }
            table.setModel(model);
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Tidak ada Transaksi pada bulan ini", "Terjadi kesalahan", JOptionPane.INFORMATION_MESSAGE);
        }
        
      
    }

    @Override
    public void showLaporanPerhariIni(JTable table) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No");
        model.addColumn("ID Transaksi");
        model.addColumn("Nama Kasir");
        model.addColumn("Tanggal Transaksi");
        model.addColumn("Grand Total");
        
        Bulan bulan = new Bulan();
        String indek = String.valueOf(bulan.getindexHari());
       
         DateApp date = new DateApp();
        String tanggalSaatIni = date.getTanggal();
        String sql="select transaksi.id_transaksi , pegawai.nama_pegawai ,transaksi.tanggal_transaksi , transaksi.grand_total from pegawai join transaksi on pegawai.id_pegawai = transaksi.id_pegawai  where transaksi.tanggal_transaksi='"+tanggalSaatIni+"' ORDER by tanggal_transaksi DESC";

        try(Connection con = dt.conectDatabase();
            Statement st = con.createStatement();
                ResultSet res = st.executeQuery(sql)){
         
          
              int no=0;
                while(res.next()){
                     no++;
                     model.addRow(new Object[]{
                     no,
                     res.getString("id_transaksi"),
                 res.getString("pegawai.nama_pegawai"),
                 res.getString("tanggal_transaksi"),
                 ("Rp."+res.getString("grand_total")),

                });
       
            
            
        }
            table.setModel(model);
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Tidak ada Transaksi pada Hari ini", "Terjadi kesalahan", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }

    @Override
    public void showLaporanPerminggu(JTable table) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No");
        model.addColumn("ID Transaksi");
        model.addColumn("Nama Kasir");
        model.addColumn("Tanggal Transaksi");
        model.addColumn("Grand Total");
   
        DateApp date = new DateApp();
        String tanggalSaatini = date.getTanggal();
        String tanggalSeminggu = date.getTanggalMinggu();
        String sql="select transaksi.id_transaksi , pegawai.nama_pegawai ,transaksi.tanggal_transaksi , transaksi.grand_total from pegawai join transaksi on pegawai.id_pegawai = transaksi.id_pegawai  where transaksi.tanggal_transaksi BETWEEN '"+tanggalSeminggu+"' and '"+tanggalSaatini+"' ORDER by tanggal_transaksi DESC;";

        try(Connection con = dt.conectDatabase();
            Statement st = con.createStatement();
                ResultSet res = st.executeQuery(sql)){
         
          
              int no=0;
                while(res.next()){
                     no++;
                     model.addRow(new Object[]{
                     no,
                     res.getString("id_transaksi"),
                 res.getString("pegawai.nama_pegawai"),
                 res.getString("tanggal_transaksi"),
                 ("Rp."+res.getString("grand_total")),

                });
       
            
            
        }
            table.setModel(model);
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Tidak ada Transaksi pada Hari ini", "Terjadi kesalahan", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @Override
    public void cetakLaporanpenjualan(String tanggal, String sampai) {       
        String sql = "select nama_toko , no_hp , alamat_toko from toko";
        String nama_toko;
        String no_hp;
        String alamat;
        try {
            Connection con = dt.conectDatabase();
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(sql);
            if (res.next()) {
                nama_toko = res.getString("nama_toko");
                no_hp = res.getString("no_hp");
                alamat = res.getString("alamat_toko");
                System.out.println(nama_toko);
            } else {
                throw new SQLException("gagal");
            }
            String fileName = "/Report/ReportLaporanPenjualan.jasper";
            InputStream Report;
            Report = getClass().getResourceAsStream(fileName);
            // File namaile = newgetClass().getResourceAsStream("/View/ReporPenjualan.jasper");
            HashMap hash = new HashMap();
           hash.put("tanggal_dari", tanggal);
           hash.put("tanggal_sampai", sampai);
           hash.put("alamat", alamat);
            JasperPrint print;
            print = JasperFillManager.fillReport(Report, hash, con);
            JasperViewer view = new JasperViewer(print ,false);
            view.setVisible(true);
            //JasperPrintManager.printReport(print, false);           
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
       
    }

    @Override
    public void cariLaporanBerdasarkanTransaksi(String id_transaksi , JTable table) {
        Barang barang = new Barang();
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No");
        model.addColumn("ID Transaksi");
        model.addColumn("Nama Kasir");
        model.addColumn("Tanggal Transaksi");
        model.addColumn("Grand Total");
        table.setRowHeight(30);
        table.setForeground(new Color(90, 90, 90));
        boolean isSuces =false;
        String sql="select transaksi.id_transaksi , pegawai.nama_pegawai ,transaksi.tanggal_transaksi , transaksi.grand_total from pegawai join transaksi on pegawai.id_pegawai = transaksi.id_pegawai where transaksi.id_transaksi like '%"+id_transaksi+"%' order by transaksi.tanggal_transaksi asc  ";
        int no=0;
        try(Connection con = dt.conectDatabase();
                Statement st = con.createStatement();
                ResultSet res = st.executeQuery(sql)){
           
            while(res.next()){
                isSuces=true;
                no++;
                model.addRow(new Object[]{
                 no,
                 res.getString("id_transaksi"),
                 res.getString("pegawai.nama_pegawai"),
                 res.getString("tanggal_transaksi"),
                 ("Rp."+res.getString("grand_total")),
   
                });
            }
            
            if(isSuces==false){
                JOptionPane.showMessageDialog(null, "Gagal Menemukan Data", "Terjadi Kesalahan", JOptionPane.ERROR_MESSAGE, barang.getEroricon() );
            }
            table.setModel(model);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
        
        
        
        
    }
    
    
    
    
    
}
