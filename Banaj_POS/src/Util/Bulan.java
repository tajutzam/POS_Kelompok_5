/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.sql.Date;
import java.util.Calendar;

/**
 *
 * @author user
 */
public class Bulan {

    public String getBulan() {
        String result = "";

        Calendar calendar = Calendar.getInstance();
        java.util.Date dt = calendar.getTime();
        int month = calendar.get(Calendar.MONTH)+1;
     
        if (month == 1) {
            result = "Januari";
        } else if (month == 2) {
            result = "Februari";
        } else if (month == 3) {
            result = "Maret";
        } else if (month == 4) {
            result = "April";
        } else if (month == 5) {
            result = "Mei";
        } else if (month == 6) {
            result = "Juni";
        } else if (month == 7) {
            result = "Juli";
        } else if (month == 8) {
            result = "Agustus";
        } else if (month == 9) {
            result = "September";
        } else if (month == 10) {
            result = "Oktober";
        } else if (month == 11) {
            result = "November";
        } else {
            result = "Desember";
        }
        return result;
    }

    public static void main(String[] args) {
     
      
    }
    public int getindexBulan(){
         Calendar calendar = Calendar.getInstance();
        java.util.Date date = calendar.getTime();
        int month = calendar.get(Calendar.MONTH)+1;
        int day =calendar.get(Calendar.DATE);  
        return month;
    }
    
     public String getBulan(int month) {
        String result = "";

     
     
        if (month == 1) {
            result = "Januari";
        } else if (month == 2) {
            result = "Februari";
        } else if (month == 3) {
            result = "Maret";
        } else if (month == 4) {
            result = "April";
        } else if (month == 5) {
            result = "Mei";
        } else if (month == 6) {
            result = "Juni";
        } else if (month == 7) {
            result = "Juli";
        } else if (month == 8) {
            result = "Agustus";
        } else if (month == 9) {
            result = "September";
        } else if (month == 10) {
            result = "Oktober";
        } else if (month == 11) {
            result = "November";
        } else if(month==12){
            result = "Desember";
        }
        return result;
    }
}
