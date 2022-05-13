/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import javax.swing.JTable;
/**
 *
 * @author NORMAL USER
 */
public interface UserInterface {
    public void showUser(JTable table);
    public String getPrimaryKey();
    public void addUser(String id, String nama_pegawai, String username, String password, String role, String status,  String time);
    public void sendToEdit(String id , String nama_pegawai , String username, String Role, String Status,  String time );
}
