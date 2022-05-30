/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Repository.Toko;
import Repository.Tokointerface;
import View.Dashbord;

/**
 *
 * @author user
 */
public class tokoService {
    
    Tokointerface toko = new Toko();
    
    public void showDataToko(){
        toko.showDataToko();
    }
    public String setNamaToko(){
        return toko.getNamaToko();
    }
    public void editToko(String nama_toko , String alamat , String no_hp ){
        toko.editDataToko(nama_toko, alamat, no_hp);
    }
}
