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
    
    public void showUser(){
        user.showUser(Dashbord.table_user);
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
        }else if(boxRole.getSelectedItem().toString().equals("User")){
        role = "2";
        }
        if(boxStatus.getSelectedItem().toString().equals("Aktive")){
        status = "Aktive"; 
        }else if(boxStatus.getSelectedItem().toString().equals("Tidak Aktive")){
        status = "Tidak Aktive";
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
        
        
}