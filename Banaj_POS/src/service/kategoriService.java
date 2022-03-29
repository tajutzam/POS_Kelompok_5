/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import javax.swing.JTable;
import Repository.*;

/**
 *
 * @author user
 */
public class kategoriService {
    
    public void showKategori(JTable table){
        
       BarangInterface br = new Barang();
       br.showBarang(table, "kategori");
        
    }
    
}
