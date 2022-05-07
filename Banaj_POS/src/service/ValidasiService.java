/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Repository.Validasi;
import Repository.ValidasiUser;
import View.Dashbord;
import View.Login;

/**
 *
 * @author user
 */
public class ValidasiService {
    
    ValidasiUser validasi = new Validasi();
   
    public boolean login(String username , String pasword){
      
      
        
        boolean login=false;
        if(validasi.login(username, pasword)==true){
             String role= this.getId(username , pasword);
             String nama = this.getNamaUser(username, pasword);
             String id = this.getIdPegawai(username, pasword);
             
             Dashbord dh = new Dashbord(role);
             dh.setNamaUserLogin(nama);
             dh.setIdPegawai(id);
             dh.setVisible(true);
             
             login =true;
        }else{
             login=false;
        }
        
       return login; 
       
    }
    public String getId(String username , String passsword){
       String id= validasi.getId(username , passsword);
       return id;
    }
    public String getNamaUser(String username , String password){
        String nama = validasi.getNamaUserLogin(username , password);
        return nama;
    }
     public String getIdPegawai(String username , String paswrod){
        String id = validasi.getIdPegawai(username , paswrod);
        return id;
    }
     public void bayar(String bayar){
         
         
         
     }
    
    
}
