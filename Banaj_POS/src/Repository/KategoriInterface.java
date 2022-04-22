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
import javax.swing.JComboBox;
import javax.swing.JTable;

/**
 *
 * @author user
 */
public interface KategoriInterface {
    
    public String getCodeKategori(JComboBox box);
    public void showKategori(JTable table);
    public void addKategori(String nama , String kode , String time);
    public String getPrimaryKey();
    public void sendToEdit(String kode , String nama_kategori , String time);
    public String getKodeKategori(JTable table);   
    public void editKategori(String kode , String nama_kategori);
       
        
        
    
    
}
