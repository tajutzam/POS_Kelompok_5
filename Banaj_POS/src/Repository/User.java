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
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author NORMAL USER
 */
public class User implements UserInterface{
    DatabaseInterface dt = new Database();
    DefaultTableModel model = new DefaultTableModel();
    ImageIcon suscesicon =  new ImageIcon(getClass().getResource("/picture/checked.png"));
    ImageIcon eroricon =  new ImageIcon(getClass().getResource("/picture/warning.png"));
    
    @Override
    public void showUser(JTable table) {
        table.setRowHeight(30);
        String sql="select id_pegawai, nama_pegawai, username, role, status, password from pegawai order by id_pegawai asc";
        int no=0;
        try(Connection con = dt.conectDatabase();
            Statement st = con.createStatement();
            ResultSet res =st.executeQuery(sql)){
            
            model.addColumn("No");
            model.addColumn("Id Pegawai");
            model.addColumn("Nama Pegawai");
            model.addColumn("Username");
            model.addColumn("Role");
            model.addColumn("Status");
            model.addColumn("Password");
            
            while(res.next()){
                no++;
                model.addRow(new Object[]{
                no,
                res.getString("id_pegawai"),
                res.getString("nama_pegawai"),
                res.getString("username"),
                res.getString("role"),
                res.getString("status"),
                res.getString("password")        
                });     
            }
            table.setModel(model);
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }    
    }

    @Override
    public String getPrimaryKey() {
        String sql_getIdPegawai="select id_pegawai from pegawai order by id_pegawai desc limit 1";
        try(Connection con = dt.conectDatabase();
            PreparedStatement pst = con.prepareStatement(sql_getIdPegawai);
            ResultSet res = pst.executeQuery(sql_getIdPegawai);){
          
          
            

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
                    u = "PGW00";
                }else if(d <= 99 ){
                    u = "PGW0";
                }else{
                    u = "PGW";
                }
                hsl = u+""+d;
            }else{
                hsl = "PGW001";
            }
  
            return hsl.toUpperCase();
            
        }catch(SQLException err){
            return err.getMessage();
        }
    }

    @Override
    public void addUser(String id, String nama_pegawai, String username, String password, String role, String status, String time) {
        String sql="insert into pegawai values (? , ? , ? , ? , ? , ? , ? , ?)";
        
        try(Connection con =dt.conectDatabase();
            PreparedStatement pst = con.prepareStatement(sql)){
            
            pst.setString(1, id);
            pst.setString(2, nama_pegawai);
            pst.setString(3, username);
            pst.setString(4, time);
            pst.setString(5, time);
            pst.setString(6, role);
            pst.setString(7, status);
            pst.setString(8, password);

            pst.execute();
            JOptionPane.showMessageDialog(null, "Berhasil Menambahkan User, "+" "+ nama_pegawai, "Success !", JOptionPane.INFORMATION_MESSAGE, suscesicon);

        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Gagal Menambahkan User"+e.getMessage(), "Informasi", JOptionPane.INFORMATION_MESSAGE);
            
        }
    }
}
    