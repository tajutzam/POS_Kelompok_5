/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import View.TransaksiPembelian1;
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
public class LaporanPembelian implements  ReportInterfce{
 
    DatabaseInterface dt = new Database();
    
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
    
    
}