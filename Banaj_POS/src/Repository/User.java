/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import View.Dashbord;
import View.TambahUser;
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
    public void showUser(JTable table, String id) {
        
        DefaultTableModel model = new DefaultTableModel();
            model.addColumn("No");
            model.addColumn("Id Pegawai");
            model.addColumn("Nama Pegawai");
            model.addColumn("Username");
            model.addColumn("Role");
            model.addColumn("Status");
            model.addColumn("Password");
        
        table.setRowHeight(30);
        String sql="select id_pegawai, nama_pegawai, username, role, status, password from pegawai order by id_pegawai asc";
        int no=0;
        try(Connection con = dt.conectDatabase();
            Statement st = con.createStatement();
            ResultSet res =st.executeQuery(sql)){
            
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

    @Override
    public void showUserYangSedangLogin(String id) {
        
        String sql="select nama_pegawai , username , password , update_at from pegawai where id_pegawai ='"+id+"'";
        
        
        try(Connection con = dt.conectDatabase();
            Statement st = con.createStatement();
            ResultSet res =st.executeQuery(sql)){
            
            if(res.next()){
                System.out.println("er");
                String username = res.getString("username");
                Dashbord.txt_username.setText(username);
                Dashbord.txt_password.setText(res.getString("password"));
                String namaTmp =res.getString("nama_pegawai");
                String[] split = namaTmp.split(" ");
                if(split.length==1){
                    Dashbord.txt_namaDepan.setText(namaTmp);
                }else if(split.length==2){
                    Dashbord.txt_namaDepan.setText(split[0]);
                    Dashbord.txt_namaBelakang.setText(split[1]);
                }
                Dashbord.txt_updateAtt.setText(res.getString("update_at"));
            }else{
                System.out.println("test");
            }
            
        }catch(SQLException e){
            System.out.println(e);
        }
        
    }
    @Override
    public void EditUser(String id, String nama_pegawai, String username, String password, String role, String status,  String time){
    
        String sql = "UPDATE `pegawai` SET `nama_pegawai`= ?,`username`= ?,`create_at`= ?,`update_at`= ?,`role`= ?,`status`= ?,`password`= ? WHERE id_pegawai = ? " ;
        try(Connection con = dt.conectDatabase();
            PreparedStatement pst = con.prepareStatement(sql)){
            
            pst.setString(1, nama_pegawai);
            pst.setString(2, username);
            pst.setString(3, time);
            pst.setString(4, time);
            pst.setString(5, role);
            pst.setString(6, status);
            pst.setString(7, password);
            pst.setString(8, id);
            
            pst.execute();
            JOptionPane.showMessageDialog(null, "Berhasil Memperbarui User , ","Succes", JOptionPane.INFORMATION_MESSAGE, suscesicon);
        }catch(SQLException e){
          JOptionPane.showMessageDialog(null, "Gagal Memperbarui User"+e.getMessage(), "Terjadi Kesalahan", JOptionPane.ERROR_MESSAGE, eroricon);

        
        }
    }
    
    @Override
    public void deleteUser(String id){
        
        int resetData = JOptionPane.showOptionDialog(null, "Apakah Anda Yakin Ingin Menghapus User ?", "Informasi !", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
        if(resetData==0){
            
            String sql ="delete from pegawai where id_pegawai = ?";
            try(Connection con = dt.conectDatabase();
            PreparedStatement pst =con.prepareStatement(sql);)
            {
               pst.setString(1, id);
               pst.executeUpdate();
           
               JOptionPane.showMessageDialog(null, "User Berhasil Dihapus Silahkan Refresh !", "Sukses !", JOptionPane.INFORMATION_MESSAGE,suscesicon);
               
            }catch(SQLException e){
                System.out.println(e);
                JOptionPane.showMessageDialog(null, "User gagal di hapus Karena Sudah Melakukan Transaksi!","Terjadi Kesalahan !",JOptionPane.WARNING_MESSAGE);
            }
            
        }
    }
}
    

    
