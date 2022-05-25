/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import View.Dashbord;

/**
 *
 * @author user
 */
public class KonfirmasiBayarService {
    
    
    String subTotal;
    int totalHarga;

    public String getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(String subTotal) {
        this.subTotal = subTotal;
    }

    public int getTotalHarga() {
        return totalHarga;
    }

    public void setTotalHarga(int totalHarga) {
        this.totalHarga = totalHarga;
    }
    
    
    
    
    public String setSubtotal(){
        int sub =0;
        int indekRow = Dashbord.table_belanja.getRowCount();
        for(int i =0; i < indekRow ; i++){
            String nilaiString =Dashbord.table_belanja.getValueAt(i, 7).toString();
            int nilaiSub=Integer.parseInt(nilaiString);
            sub+=nilaiSub;
        }
        String finalSub = String.valueOf(sub);
        this.setSubTotal(finalSub);
        return this.getSubTotal();
    }
    
    
    
}
