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
        for(int i=0; i < 10 ; i++ ){
            hitungLastIndek(0, 0, 9);
        }
      
    }
    
    public static void hitungLastIndek(int a , int b , int c){
        
        
        
       
        
        if(a==0 && b ==0 && c<=9){
   
            c+=1; 
            if(c>=9){
                c=9;
                b+=1;
                if(b>=9){
                    a+=1;
                }
            }
  
        }else if(a==0 || b>=0 && c>0){
           
            b+=1;
             if(b>=9){
                b=9;
                a+=1;
                if(a>=9){
                    a=9;
                }
            
            
        }
        
       
        
    }
         System.out.println(a+""+b+""+c);
    }
        
    
    public static String getCodeBarang(String product) {
        
        char a = product.charAt(0);
        char b = product.charAt(2);
        String finalA = Character.toString(a);
        String finalB = Character.toString(b);
        
        String kodeBarang = finalA + finalB;
        char angka1 = '0';
        char angka2 = '0';
        char angka3 = '1';
        
        String result = "" + angka1 + "" + angka2 + "" + angka3;
        
        String kodeBarangFinal = kodeBarang + result;
        
        return kodeBarangFinal;
        
    }
    
}


