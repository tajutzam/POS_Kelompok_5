/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

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
             
            if(res.next()){
                isSuces=true;
            }else{
                isSuces=false;
            }
            while(res.next()){
              
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
    
    
}
