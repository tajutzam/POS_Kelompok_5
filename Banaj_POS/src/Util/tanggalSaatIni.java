/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;


import java.util.Calendar;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 *
 * @author user
 */
public class tanggalSaatIni {
    
   public String getCurrentTimeStamp(){
        
         final SimpleDateFormat waktu = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
         Timestamp timestamp = new Timestamp(System.currentTimeMillis());
         System.out.println(waktu);
         return waktu.format(timestamp);
         
    }
    public String getTime(){
        java.util.Date date = new java.util.Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYYY");
        String dateTime = sdf.format(date);
        System.out.println(dateTime);
        return dateTime;
    }
    
    public static void main(String[] args) {
      
        tanggalSaatIni tg = new tanggalSaatIni();
        tg.getCurrentTimeStamp();
        tg.getTime();
    }
    
   
    
}
