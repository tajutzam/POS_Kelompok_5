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
public class LaporanPenjualan implements ReportInterfce{
    
    
    DatabaseInterface dt = new Database();
   

    

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
            
            if(res.next()){
                isSuces=true;
            }else{
                isSuces=false;
            }
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
 
    
}
