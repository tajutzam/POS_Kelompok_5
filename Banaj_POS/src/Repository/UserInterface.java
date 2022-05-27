/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import View.DataTambahKategori;
import View.TambahUser;
import javax.swing.JTable;
/**
 *
 * @author NORMAL USER
 */
public interface UserInterface {
    public void showUser(JTable table, String id);
    public String getPrimaryKey();
    public void addUser(String id, String nama_pegawai, String username, String password, String role, String status,  String time);
    public void EditUser(String id, String nama_pegawai, String username, String password, String role, String status,  String time);
    public void deleteUser(String id);
}
