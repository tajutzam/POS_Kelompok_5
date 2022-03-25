/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

/**
 *
 * @author user
 */
public class Id_barang {
    
    public static void main(String[] args) {
        System.out.println(  getCodeBarang("sampo"));
        System.out.println(getCodeBarang("parfum"));
        System.out.println(getCodeBarang("Mouse"));
    }
    
    public static String getCodeBarang(String product){
        
        char a =product.charAt(0);
        char b =product.charAt(2);
        String finalA=Character.toString(a);
        String finalB=Character.toString(b);
        
        String kodeBarang=finalA+finalB;
        char angka1 ='0';
        char angka2='0';
        char angka3 ='1';
        
      
        String result =""+angka1+""+angka2+""+angka3;
        
        String kodeBarangFinal= kodeBarang+result;
        
        
        
       return kodeBarangFinal;
       
        
    }
    
}
