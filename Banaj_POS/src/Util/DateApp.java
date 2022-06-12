/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author user
 */
public class DateApp {
    
    private String tanggalSaatIni;
    private String tanggalSeminggu;

    public String getTanggalSaatIni() {
        return tanggalSaatIni;
    }

    public void setTanggalSaatIni(String tanggalSaatIni) {
        this.tanggalSaatIni = tanggalSaatIni;
    }

    public String getTanggalSeminggu() {
        return tanggalSeminggu;
    }

    public void setTanggalSeminggu(String tanggalSeminggu) {
        this.tanggalSeminggu = tanggalSeminggu;
    }
    
    
    
    public String  getTanggal(){
        
           SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
           
           Calendar calendar = Calendar.getInstance();
           Date dt = calendar.getTime();
           String result = format.format(dt);
           this.setTanggalSaatIni(result);
           return this.getTanggalSaatIni();

    }
    
    public String getTanggalMinggu(){
          SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
           
           Calendar calendar = Calendar.getInstance();
           calendar.add(Calendar.DATE, -7);
           Date dt = calendar.getTime();
           String result = format.format(dt);
           this.setTanggalSeminggu(result);
           return this.getTanggalSeminggu();
        
    }
    public static void main(String[] args) {
        
        DateApp dt = new DateApp();
        System.out.println(dt.getTanggal());
        System.out.println(dt.getTanggalMinggu());
    }
    
}
