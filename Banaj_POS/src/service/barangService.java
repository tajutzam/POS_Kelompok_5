/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Repository.Barang;
import Repository.BarangInterface;
import javax.swing.JTable;

/**
 *
 * @author user
 */
public class barangService {
    
    
    
    public static void showBarang(JTable table){
        BarangInterface br = new Barang();
        br.showBarang(table, "barang");
    }
    
    
}
