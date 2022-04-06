/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Repository.Barang;
import Repository.BarangInterface;
import javax.swing.JComboBox;
import javax.swing.JTable;


/**
 *
 * @author user
 */
public class supplierService {
    
    public void showSupplier(JTable table){
        BarangInterface br = new Barang();
        br.showBarang(table, "supplier");
    }
    public void addItemSupplier(JComboBox box){
        
        BarangInterface br = new Barang();
        br.addComboboxItem(box, "supplier");
        
    }
    
}
