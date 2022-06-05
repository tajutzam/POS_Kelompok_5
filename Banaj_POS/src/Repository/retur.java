/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import Util.Id;
import Util.IdBarang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class retur implements ReturInterface {
    
    DatabaseInterface dt = new Database();
    

    @Override
    public void insertReturCode(String kode_supplier , String kode_product , int jumlahRusak) {
        
       String sqlReturSupplier= "insert into retur_supplier (id_returSupplier , kode_supplier , tanggal_rtr )values (?, ? ,?)";
       String sqlDetailReturnSupplier ="insert into detail_retur (id_returSupplier , product, jumlah_rusak) values (? ,? ,?)";
       
       String id = new IdBarang().idReturSupplier();
       try(Connection con = dt.conectDatabase();
           Connection conDt = dt.conectDatabase();
               PreparedStatement pst = con.prepareStatement(sqlReturSupplier);
               PreparedStatement pstRet = conDt.prepareStatement(sqlDetailReturnSupplier)){
           
           pst.setString(1, id);
           pst.setString(2, kode_supplier);
           pst.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now().toString()));
           
           pstRet.setString(1, id);
           pstRet.setString(2, kode_product);
           pstRet.setInt(3, jumlahRusak);
           
           pst.execute();
           pstRet.execute();
           
           
       }catch(SQLException e){
           System.out.println(e);
       }
    }

    @Override
    public void showRetur() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No");
        model.addColumn("Id Retur");
        model.addColumn("Nama Supplier");
        model.addColumn("Nama Barang");
        model.addColumn("Tanggal Retur");
        model.addColumn("Jumlah Rusak");
        
        
    }
    
    
    
}
