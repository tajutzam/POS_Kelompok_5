/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class Supplier implements SupplierInterface{
    
    DatabaseInterface dt = new Database();
    DefaultTableModel model = new DefaultTableModel();
    ImageIcon suscesicon =  new ImageIcon(getClass().getResource("/picture/checked.png"));

    
    

    public String getPrimaryKey(){
        
        
        String sql_getKodeBarang="select kode_supplier from supplier order by kode_supplier desc limit 1";
        try(Connection con = dt.conectDatabase();
            PreparedStatement pst = con.prepareStatement(sql_getKodeBarang);
            ResultSet res = pst.executeQuery(sql_getKodeBarang);){
          
          
            

            String hsl = "";
            if(res.next()){
                String a = res.getString(1).replaceAll("[a-zA-Z]", "");
                String b = "";
                String c[] = a.split("(?!^)");
                String u = "";

                if("0".equals(c[0])){
                    if("0".equals(c[1])){
                        b = c[2];
                    }else{
                        b = c[1]+c[2];
                    }
                }else{
                    b = a;
                }

                int d = Integer.parseInt(b)+1;

                if(d <= 9){
                    u = "S00";
                }else if(d <= 99 ){
                    u = "S0";
                }else{
                    u = "S";
                }
                hsl = u+""+d;
            }else{
                hsl = "S001";
            }
  
            return hsl.toUpperCase();
            
        }catch(SQLException err){
            return err.getMessage();
        }

        
        
    }
  
    @Override
    public String getKodeSupplier(JComboBox box) {
        String kode ="";
        
        String sql ="select kode_supplier from supplier where nama_supplier = '"+box.getSelectedItem().toString()+"' desc limit 1";
        try(Connection con = dt.conectDatabase();
                Statement st = con.createStatement();
                ResultSet res =st.executeQuery(sql)){
            
            while (res.next()) {

                kode = res.getString("kode_supplier");
                
            }
            
        }catch(SQLException e){
            
        }
        return kode;
    }
        

    public static void main(String[] args) {
        
        
        
    }

    @Override
    public void showSuplier(JTable table) {
        table.setRowHeight(30);
        String sql="select kode_supplier, nama_supplier from supplier order by kode_supplier asc";
        int no=0;
        try(Connection con = dt.conectDatabase();
            Statement st = con.createStatement();
            ResultSet res =st.executeQuery(sql)){
            
            model.addColumn("No");
            model.addColumn("Kode Supplier");
            model.addColumn("Nama Supplier");
            
            while(res.next()){
                no++;
                model.addRow(new Object[]{
                no,
                res.getString("kode_supplier"),
                res.getString("nama_supplier")
                });
                 
            }
            table.setModel(model);
            
        }catch(SQLException e){
            
        }
        
        
        
        
    }

    @Override
    public void addSupplier(String nama_suppllier,String kode, String time) {
        
        
        String sql="insert into supplier values (? , ? , ? ,? )";
        
        try(Connection con =dt.conectDatabase();
            PreparedStatement pst = con.prepareStatement(sql)){
            
            pst.setString(1, kode);
            pst.setString(2, nama_suppllier);
            pst.setString(3, time);
            pst.setString(4, time);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Berhasil Menambahkan Supplier, "+" "+ nama_suppllier, "Success !", JOptionPane.INFORMATION_MESSAGE, suscesicon);

        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Gagal Menambahkan Supplier"+e.getMessage(), "Informasi", JOptionPane.INFORMATION_MESSAGE);
            
        }
    }
   
}
