/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

/**
 *
 * @author user
 */
public interface ValidasiUser {
    
    public boolean login(String a ,String b);
    public String getId(String a , String b);
    public String getNamaUserLogin(String a , String b);
    public String getIdPegawai(String a, String b);
   
}
