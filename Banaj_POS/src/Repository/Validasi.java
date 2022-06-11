/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import View.Dashbord;
import View.Login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import service.OrderService;

/**
 *
 * @author user
 */
public class Validasi implements ValidasiUser{
    
    
    ImageIcon suscesicon =  new ImageIcon(getClass().getResource("/picture/checked.png"));
    ImageIcon eroricon =  new ImageIcon(getClass().getResource("/picture/warning.png"));
    
    private String idPegawaiBaru;
    private String role;
    private String nama;
    Login login = new Login();

    public String getIdPegawaiBaru() {
        return idPegawaiBaru;
    }

    public void setIdPegawaiBaru(String idPegawaiBaru) {
        this.idPegawaiBaru = idPegawaiBaru;
    }
    
     

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
    
    
    
    static{
        
        DatabaseInterface database = new Database();
        database.conectDatabase();
   
    }
    
     OrderService order=new OrderService();
   

     DatabaseInterface dt = new Database();

    
      
   
    Dashbord dh = new Dashbord("");
   
    @Override
    public boolean login(String username , String password) {

      //Sql Validasi 
      String sqlLogin = "SELECT * FROM pegawai WHERE username ='"+username+"' AND password ='"+password+"'";
      boolean isLogin=false;
       
        try(Connection con = dt.conectDatabase();
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(sqlLogin);
            ){ 
            if(!username.equals("")&&!password.equals("")){
            //jika data ada maka masuk control statment
            if(res.next()){
                
                String status =res.getString("status");
                String role = res.getString("role");
                
                Dashbord.label_role.setText(role);
                String id = res.getString("id_pegawai");
                String nama=res.getString("nama_pegawai");
                    //jika user aktif maka bisa login
                    if(status.equals("Aktif")){
                    JOptionPane.showMessageDialog(login, "Berhasil Login ", "Sukses", JOptionPane.INFORMATION_MESSAGE, suscesicon);
                    isLogin =true;
                    //jika tidak maka tidak bisa login
                }else{
                    JOptionPane.showMessageDialog(login, "Tidak Bisa Login, Akun Anda Non Aktif!", "Terjasi Kesalahan", JOptionPane.INFORMATION_MESSAGE, eroricon);
                    isLogin=false;
                }
                //Jika data tidak ada maka muncul pop up
                }else{
                    JOptionPane.showMessageDialog(login, "Username dan Password salah!", "Terjasi Kesalahan", JOptionPane.INFORMATION_MESSAGE, eroricon);
                    isLogin=false;
                }
            //jika field kosong
            }else{
                JOptionPane.showMessageDialog(login, "Harap Isi Field Terlebih Dahulu!", "Terjasi Kesalahan", JOptionPane.INFORMATION_MESSAGE, eroricon);
                isLogin=false;
            }
        //exeption pada sql
        }catch(SQLException e){
                     JOptionPane.showMessageDialog(login, e.getMessage(), "Terjadi Kesalahan!", JOptionPane.WARNING_MESSAGE);
        }
        
       return isLogin; 
    }

    public Validasi() {
        
        DatabaseInterface database = new Database();
        database.conectDatabase();
   
    }

    @Override
    public String getId(String username , String password) {
        Login login =new Login();
       
        String sql = "SELECT role FROM pegawai WHERE username ='"+username+"' AND password ='"+password+"'";

       
        String id ="";
        
        try(Connection con = dt.conectDatabase();
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(sql))
        {
          if(res.next()){
              id = res.getString("role");
              Dashbord.label_role.setText(id);
            
          }else{
              throw new SQLException();
          }
        }catch(SQLException e){
             JOptionPane.showMessageDialog(login, e.getMessage(), "Terjadi Kesalahan!", JOptionPane.WARNING_MESSAGE);

        }
        return id;
    }
    
    public void setNamaUserLogin(String nama){
        
        
        
    }
    
    public String getNamaUserLogin(String username , String password){
        String sql = "SELECT nama_pegawai FROM pegawai WHERE username ='"+username+"' AND password ='"+password+"'";
        
        try(Connection con = dt.conectDatabase();
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(sql)){
            
            if(res.next()){
                this.setNama(res.getString("nama_pegawai"));
            }
        }catch(SQLException e){
            
        }
    return this.getNama();
    }
    
    

    @Override
    public String getIdPegawai(String username , String password) {
        
       String sql = "SELECT id_pegawai FROM pegawai WHERE username ='"+username+"' AND password ='"+password+"'";
        
        try(Connection con = dt.conectDatabase();
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(sql)){
            
            if(res.next()){
                this.setIdPegawaiBaru(res.getString("id_pegawai"));
            }
        }catch(SQLException e){
            
        }
    return this.getIdPegawaiBaru(); 
    }
    
    
    
    
    
    
    
}
