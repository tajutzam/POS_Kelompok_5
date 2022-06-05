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
public interface ReturInterface {
    
    public void insertReturCode(String kode_suplier , String kode_product , int jumlahRusak);
    public void showRetur();
}
