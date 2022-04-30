/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Repository.Order;
import Repository.OrderInterface;
import View.Dashbord;
import View.KonfirmasiOrder;
import View.TambahUser;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class OrderService extends barangService {
    ImageIcon suscesicon =  new ImageIcon(getClass().getResource("/picture/checked.png"));
    ImageIcon eroricon =  new ImageIcon(getClass().getResource("/picture/warning.png"));
    
    
    public boolean getBarang(String keyword ){
        
        
      boolean isMatch =false;
      OrderInterface order = new Order();
      
          if(order.cariBarang(keyword, Dashbord.table_cariBelanja , "match")==true){
              isMatch=true;
          }else{
              isMatch=false;
          }
        return isMatch;
    }
    public void resetKeranjang(){
       
        Order order = new Order();

        order.resetTableOrder();

       
        
    }
    
    public String selectBarang(String kode  ){
        
        OrderInterface order = new Order();
      
        String nama=order.selectToOrder(kode);
        return nama;
  
    }
    
  
  public void addProductToKeranjang(){
      
      
    
         
      OrderInterface order = new Order();
      int selectedRow=Dashbord.table_cariBelanja.getSelectedRow();
      if(Dashbord.table_cariBelanja.getValueAt(selectedRow, 3).toString().equals("0")){
         JOptionPane.showMessageDialog(null, "Tidak Bisa menambahkan Product, Stok Habis !", "Product Kosong", JOptionPane.INFORMATION_MESSAGE, eroricon);
      }else{
      int count = Dashbord.table_belanja.getRowCount();
      System.out.println("count "+count);
      boolean dataDoble = false;
      int stok = Integer.parseInt(Dashbord.table_cariBelanja.getValueAt(selectedRow, 3).toString());
      int qty = Integer.parseInt(KonfirmasiOrder.txt_qty.getText().toString().replaceAll("[a-zA-Z]",""));
      if(count==0){
          if(qty > stok){
            JOptionPane.showMessageDialog(null, "Stok Tidak mencukupi", "Terjadi Kesalahan", JOptionPane.INFORMATION_MESSAGE, eroricon);
          }else{
               order.addProductToKeranjang(KonfirmasiOrder.txt_kodeProduct.getText().toString());  
          dataDoble=false;
          }
   
      }else if(count>0){
          for(int i =0; i< count; i++){
              String k_product = Dashbord.table_belanja.getValueAt(i, 1).toString();
              if(k_product.equals(Dashbord.table_cariBelanja.getValueAt(selectedRow, 1).toString())){
                 JOptionPane.showMessageDialog(null, "Product Sudah Ada Pada keranjang", "Product Duplikat", JOptionPane.INFORMATION_MESSAGE, eroricon);
                 dataDoble=true;
              }
          }     
          if(!dataDoble){
            if(qty > stok){
            JOptionPane.showMessageDialog(null, "Stok Tidak mencukupi", "Terjadi Kesalahan", JOptionPane.INFORMATION_MESSAGE, eroricon);
            }else{
            order.addProductToKeranjang(KonfirmasiOrder.txt_kodeProduct.getText().toString());  
            dataDoble=false;
          }
          }
          
      }
      }
      
      
         
  }  
  
  public static void pushDataOrderToMain(String[] data ,  JTable table_order){
      DefaultTableModel model = new DefaultTableModel();
        if(model.getRowCount() == 1 && model.getValueAt(0, 0).equals("")){
        model.setRowCount(0);
        }
        if(data.length != 0){
           int jumlah_data_order = table_order.getRowCount();
           if(jumlah_data_order != 0){

                String nilai = "";
                int r_count = 0;
                boolean data_duplikat = false;
                for(int count = 0; count < jumlah_data_order; count++){
                    String k_brg = model.getValueAt(count, 1).toString();
                    if(k_brg.equals(data[0])){
                        nilai = model.getValueAt(count, 5).toString();
                        r_count = count;
                        data_duplikat = true;
                    }
                }

                if(!data_duplikat){
                    model.addRow(new Object[]{
                        jumlah_data_order+1, data[0], data[1], data[2], data[3], "1", "0"
                    });
                }else{
                    int r_nilai = Integer.parseInt(nilai);
                    r_nilai++;
                    model.setValueAt(r_nilai, r_count, 5);
                }

            }else{
                model.addRow(new Object[]{
                    jumlah_data_order+1, data[0], data[1], data[2], data[3], "1", "0"
                });
            }
        }
        
    
    }
}
