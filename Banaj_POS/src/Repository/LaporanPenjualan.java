/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import View.TransaksiPenjualan;
import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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
    
}
