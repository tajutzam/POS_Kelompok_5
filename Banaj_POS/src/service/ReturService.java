/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Repository.ReturInterface;
import Repository.retur;

/**
 *
 * @author user
 */
public class ReturService {
    
    ReturInterface returObj = new retur();
    
    public void addretur(String kode_supplier , String kode_product , int jumlah_rusak){
        returObj.insertReturCode(kode_supplier, kode_product,jumlah_rusak);
    }
    
    
}
