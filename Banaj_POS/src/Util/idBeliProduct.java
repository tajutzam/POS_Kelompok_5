/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author user
 */
public class idBeliProduct {
    
    
    public  String getIdBeli(){
        
        String word ="TRB";
        
        Random rand  = new Random(1000);
         
        Date date =new Date();//jam saat ini
        //menggunakan date menggunakan miliesecond
        System.out.println(date);
        
        Calendar kalender = Calendar.getInstance();//waktu saat ini
        Date dt = kalender.getTime();
        System.out.println(dt);
        //1 minggu
        kalender.add(Calendar.DATE, 6);
        Date result = kalender.getTime();
        String hasil =String.valueOf(result);
        
        
        return hasil;
        
    }
    public static String idBeliProduct(){
        String result="TRB";
        Random rand = new Random();
        int randomNomer = rand.nextInt(100000);
        String kode_retur = result +randomNomer;
        
        
        return kode_retur;
    }
    public static void main(String[] args) {
       
    }
}
