/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Repository.User;
import Repository.UserInterface;
import View.Dashbord;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class UserService {
    UserInterface user = new User();  
    
    public void showUser(JTable table){
       user.showUser(table,Dashbord.label_idPegawai.getText());
    }
       public String getId(){
        String kode =user.getPrimaryKey();
        return kode;
    }
    public boolean addUser(String id, String nama_pegawai , String username, String password, JComboBox boxRole, JComboBox boxStatus,  String time){
        String role ="";
        String status ="";
        boolean isadd = false;
        if(boxRole.getSelectedItem().toString().equals("Admin")){
        role = "1"; 
        }else if(boxRole.getSelectedItem().toString().equals("Kasir")){
        role = "2";
        }
        if(boxStatus.getSelectedItem().toString().equals("Aktive")){
        status = "Aktif"; 
        }else if(boxStatus.getSelectedItem().toString().equals("Tidak Aktive")){
        status = "Tidak Aktif";
        }
        if(nama_pegawai.equals("")||username.equals("")||password.equals("")){
           JOptionPane.showMessageDialog(null, "Harap Isi From dengan benar", "Information", JOptionPane.INFORMATION_MESSAGE);
           isadd=false;
        }else{
            
        UserInterface user = new User();
        isadd = true;
        user.addUser(id, nama_pegawai, username, password, role, status, time);
       } 
        return isadd;
    }
    public void showUserYangSedangLogin(String id){
        UserInterface user = new User();
        user.showUserYangSedangLogin(id);
    }
    public boolean EditUser(String id, String nama_pegawai , String username, String password, String konfirmasi_password, String role, String status,  String time){
         
         boolean isSucses=false;
         
         if(!nama_pegawai.equals("")&& !username.equals("")&& !role.equals("")&& !status.equals("")){
             isSucses=true;
         }else if(!password.equals(konfirmasi_password)){
             JOptionPane.showMessageDialog(null, "Password Yang Anda Masukkan Tidak Sama", "Information", JOptionPane.INFORMATION_MESSAGE);
             isSucses = false;
         }
         if(isSucses==true){
             user.EditUser(id, nama_pegawai, username, password, role, status, time);
         }
         return isSucses;
     }
    public void editUseryangsedangLogin(String id , String nama_pegawai , String username , String password , String role , String status ,String time){
        user.EditUser(id, nama_pegawai, username, password, role, status, time);
    }
     public void deleteUser(String id){
         
         UserInterface us = new User();
         us.deleteUser(id);
     }
     public void getStatusRole(String id){
         user.getRoleStatus(id);
     }
     
     public void cariBerdasarkanKodeDanNama(String keyword){
         user.cariBerdasarkanNamadanKode(keyword, Dashbord.table_user);
     }
     public void showBerdasrkanStatus(JComboBox box){
         user.showBerdasarkanJcomboBox(box);
     }
     public String getTotalUser(){
        return user.getTotalUser();
     }

}