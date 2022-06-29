/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import Util.Bulan;
import Util.DateApp;
import View.TransaksiPembelian1;
import java.awt.Color;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.stream.Stream;
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
public class LaporanPembelian implements  ReportInterfce{
 
    //pholimorpisme
    DatabaseInterface dt = new Database();
    Barang barang = new Barang();
    
    @Override
    public boolean showLaporanToTable(JTable table) {
        
        boolean isSuces =false;
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No");
        model.addColumn("ID Transaksi");
        model.addColumn("Kasir");
        model.addColumn("Tanggal Transaksi");
        model.addColumn("Grand Total");
        model.addColumn("Nama Supplier");
        model.addColumn("Nama Kategori");
        table.setRowHeight(30);
        table.setForeground(new Color(90, 90, 90));
        
        String sql ="select pegawai.nama_pegawai , beli_product.id_beliProduct , supplier.nama_supplier , beli_product.tanggal_beliProduct , kategori.nama_kategori , beli_product.grand_total from supplier join beli_product on supplier.kode_supplier = beli_product.supplier join kategori on beli_product.kategori = kategori.kode_kategori join pegawai on pegawai.id_pegawai = beli_product.pegawai order by beli_product.tanggal_beliProduct asc ";
        int no=0;
        try(Connection con = dt.conectDatabase();
                Statement st = con.createStatement();
                ResultSet res = st.executeQuery(sql)){
             
            
            while(res.next()){
                
                 isSuces=true;
                 no++;
                 model.addRow(new Object[]{
                 no,
                 res.getString("id_beliProduct"),
                 res.getString("pegawai.nama_pegawai"),
                 res.getString("tanggal_beliProduct"),
                 ("Rp."+res.getString("grand_total")),
                 res.getString("supplier.nama_supplier"),
                 res.getString("kategori.nama_kategori")
                 
                    
                    
                });
            }
            if(isSuces=false){
                model.addRow(new Object[]{
                    "Tidak ada transaksi"
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
        model.addColumn("Nama Barang");
        model.addColumn("Jumlah");
       
        String sql="select supplier.nama_supplier , beli_product.tanggal_beliProduct, beli_product.id_beliProduct,supplier.nama_supplier , beli_product.grand_total , pegawai.nama_pegawai , beli_product.bayar , beli_product.kembalian , detail_beli_product.jumlahBeli ,product.nama_product from beli_product join detail_beli_product on beli_product.id_beliProduct=detail_beli_product.id_beliProduct join pegawai on pegawai.id_pegawai = beli_product.pegawai join product on product.kode_product = detail_beli_product.product join supplier on supplier.kode_supplier =beli_product.supplier where beli_product.id_beliProduct='"+id+ "' ";
        
        try(Connection con = dt.conectDatabase();
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(sql)){
            
            String nama ="";
            String total="";
            String tanggal="";
            String bayar="";
            String kembali="";
            String nama_supplier ="";
            
         
            while(res.next()){
                
                total=res.getString("beli_product.grand_total");
                tanggal=res.getString("beli_product.tanggal_beliProduct");
                bayar=res.getString("beli_product.bayar");
                kembali=res.getString("beli_product.kembalian");
                nama_supplier=res.getString("supplier.nama_supplier");
                
                model.addRow(new Object[]{
                    res.getString("product.nama_product"),
                    res.getString("detail_beli_product.jumlahBeli"),
                    
                });               
            }
            TransaksiPembelian1.grand_totalVlue.setText(total);
            TransaksiPembelian1.nama_kasir_value.setText(nama_supplier);
            TransaksiPembelian1.bayar_value.setText(bayar);
            TransaksiPembelian1.kembalian_value.setText(kembali);
            TransaksiPembelian1.tanggal_kasir.setText(tanggal);
            
            
          
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
        model.addColumn("Kasir");
        model.addColumn("Tanggal Transaksi");
        model.addColumn("Grand Total");
        model.addColumn("Nama Supplier");
        model.addColumn("Nama Kategori");
        table.setRowHeight(30);
        table.setForeground(new Color(90, 90, 90));
        Bulan bulan = new Bulan();
        int indexBulan = bulan.getindexBulan();
        String sql ="select pegawai.nama_pegawai , beli_product.id_beliProduct , supplier.nama_supplier , beli_product.tanggal_beliProduct , kategori.nama_kategori , beli_product.grand_total from supplier join beli_product on supplier.kode_supplier = beli_product.supplier join kategori on beli_product.kategori = kategori.kode_kategori join pegawai on pegawai.id_pegawai = beli_product.pegawai where beli_product.bulan ="+indexBulan+" order by beli_product.tanggal_beliProduct desc";
        int no=0;
        try(Connection con = dt.conectDatabase();
                Statement st = con.createStatement();
                ResultSet res = st.executeQuery(sql)){
             
            boolean isSucses=false;
            while(res.next()){
               isSucses=true;
                 no++;
                 model.addRow(new Object[]{
                 no,
                 res.getString("id_beliProduct"),
                 res.getString("pegawai.nama_pegawai"),
                 res.getString("tanggal_beliProduct"),
                 ("Rp."+res.getString("grand_total")),
                 res.getString("supplier.nama_supplier"),
                 res.getString("kategori.nama_kategori")
                 
                    
                    
                });
            }
            if(isSucses==false){
                model.addRow(new Object[]{
                    "Tidak ada transaksi Pada bulan Ini"
                });
            }
            table.setModel(model);
        }catch(SQLException e){
            System.out.println(e);  
        }
      
    }

    @Override
    public void showLaporanPerminggu(JTable table) {
          
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No");
        model.addColumn("ID Transaksi");
        model.addColumn("Kasir");
        model.addColumn("Tanggal Transaksi");
        model.addColumn("Grand Total");
        model.addColumn("Nama Supplier");
        model.addColumn("Nama Kategori");
        table.setRowHeight(30);
        table.setForeground(new Color(90, 90, 90));
     
        
        DateApp date = new DateApp();
        String tanggalSaatini = date.getTanggal();
        String tanggalSeminggu = date.getTanggalMinggu();
        String sql ="select pegawai.nama_pegawai , beli_product.id_beliProduct , supplier.nama_supplier , beli_product.tanggal_beliProduct , kategori.nama_kategori , beli_product.grand_total from supplier join beli_product on supplier.kode_supplier = beli_product.supplier join kategori on beli_product.kategori = kategori.kode_kategori join pegawai on pegawai.id_pegawai = beli_product.pegawai where beli_product.tanggal_beliProduct between '"+tanggalSeminggu+"' and '"+tanggalSaatini+"' order by beli_product.tanggal_beliProduct desc ";
        int no=0;
        try(Connection con = dt.conectDatabase();
                Statement st = con.createStatement();
                ResultSet res = st.executeQuery(sql)){
             
            boolean isSuces=false;
            while(res.next()){
                isSuces=true;
                 no++;
                 model.addRow(new Object[]{
                 no,
                 res.getString("id_beliProduct"),
                 res.getString("pegawai.nama_pegawai"),
                 res.getString("tanggal_beliProduct"),
                 ("Rp."+res.getString("grand_total")),
                 res.getString("supplier.nama_supplier"),
                 res.getString("kategori.nama_kategori")
                 
                    
                    
                });
            }
            
            if(isSuces==false){
                model.addRow(new Object[]{
                    "Tidak ada Transaksi Pada Minggu Ini"
                });
            }
            table.setModel(model);
        }catch(SQLException e){
            System.out.println(e);  
        }
      
    }

    @Override
    public void showLaporanPerhariIni(JTable table) {
          
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No");
        model.addColumn("ID Transaksi");
        model.addColumn("Kasir");
        model.addColumn("Tanggal Transaksi");
        model.addColumn("Grand Total");
        model.addColumn("Nama Supplier");
        model.addColumn("Nama Kategori");
        table.setRowHeight(30);
        table.setForeground(new Color(90, 90, 90));
       
        DateApp date = new DateApp();
        String tanggalSaatIni = date.getTanggal();
        String sql ="select pegawai.nama_pegawai , beli_product.id_beliProduct , supplier.nama_supplier , beli_product.tanggal_beliProduct , kategori.nama_kategori , beli_product.grand_total from supplier join beli_product on supplier.kode_supplier = beli_product.supplier join kategori on beli_product.kategori = kategori.kode_kategori join pegawai on pegawai.id_pegawai = beli_product.pegawai where beli_product.tanggal_beliProduct ='"+tanggalSaatIni+"'  order by beli_product.tanggal_beliProduct desc";
        int no=0;
        try(Connection con = dt.conectDatabase();
                Statement st = con.createStatement();
                ResultSet res = st.executeQuery(sql)){
             
            boolean isSuces=false;
            while(res.next()){
               isSuces=true;
                 no++;
                 model.addRow(new Object[]{
                 no,
                 res.getString("id_beliProduct"),
                 res.getString("pegawai.nama_pegawai"),
                 res.getString("tanggal_beliProduct"),
                 ("Rp."+res.getString("grand_total")),
                 res.getString("supplier.nama_supplier"),
                 res.getString("kategori.nama_kategori")
                 
                    
                    
                });
            }
            if(isSuces==false){
                model.addRow(new Object[]{
                    "Tidak ada Transaksi Pada hari Ini"
                });
            }
            table.setModel(model);
        }catch(SQLException e){
            System.out.println(e);  
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
            String fileName = "/Report/ReportLaporanPembelian.jasper";
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
    public void cariLaporanBerdasarkanTransaksi(String id_transaksi, JTable table) {
        
       boolean isSuces =false;
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No");
        model.addColumn("ID Transaksi");
        model.addColumn("Kasir");
        model.addColumn("Tanggal Transaksi");
        model.addColumn("Grand Total");
        model.addColumn("Nama Supplier");
        model.addColumn("Nama Kategori");
        table.setRowHeight(30);
        table.setForeground(new Color(90, 90, 90));
 
        String sql ="select pegawai.nama_pegawai , beli_product.id_beliProduct , supplier.nama_supplier , beli_product.tanggal_beliProduct , kategori.nama_kategori , beli_product.grand_total from supplier join beli_product on supplier.kode_supplier = beli_product.supplier join kategori on beli_product.kategori = kategori.kode_kategori join pegawai on pegawai.id_pegawai = beli_product.pegawai where beli_product.id_beliProduct like '%"+id_transaksi+"%'order by beli_product.tanggal_beliProduct asc ";
        int no=0;
        try(Connection con = dt.conectDatabase();
                Statement st = con.createStatement();
                ResultSet res = st.executeQuery(sql)){
             
            
            while(res.next()){
                 isSuces=true;
                 no++;
                 model.addRow(new Object[]{
                 no,
                 res.getString("id_beliProduct"),
                 res.getString("pegawai.nama_pegawai"),
                 res.getString("tanggal_beliProduct"),
                 ("Rp."+res.getString("grand_total")),
                 res.getString("supplier.nama_supplier"),
                 res.getString("kategori.nama_kategori")
                 
                    
                    
                });
            }
            
            if(isSuces==false){
                showLaporanToTable(table);
                                JOptionPane.showMessageDialog(null, "Gagal Menemukan Data", "Terjadi Kesalahan", JOptionPane.ERROR_MESSAGE, barang.getEroricon() );

//                 table.setModel(model);
                 showLaporanToTable(table);
            }
            table.setModel(model);
        }catch(SQLException e){
           
         
            JOptionPane.showMessageDialog(null , "Gagal Menemukan Transaksi");
          
        }  
        
    }
    
    
    
    
}
