/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import javax.swing.JComboBox;
import java.util.Random;

/**
 *
 * @author user
 */
public class IdBarang {
    String kode;
    
    
    public String getKodeBarang(String kategori){
        
 
        
        
        return kode;
    }
    
    public String idReturSupplier(){
        String result="TR";
        Random rand = new Random();
        int randomNomer = rand.nextInt(100000000);
        String kode_retur = result +randomNomer;
        
        
        return kode_retur;
    }
    
    public static void main(String[] args) {
        IdBarang id = new IdBarang();
        for(int i=0; i< 100; i++){
                    System.out.println(id.idReturSupplier());

        }
        
        
    }

    
}
