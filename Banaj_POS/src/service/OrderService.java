/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Repository.Order;
import Repository.OrderInterface;
import View.Dashbord;
import View.KonfirmasiBayar;
import static View.KonfirmasiBayar.txt_diskon;
import static View.KonfirmasiBayar.txt_totalHarga;
import View.KonfirmasiOrder;
import View.TambahUser;
import View.TransaksiBerhasil;
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
    
    private int totalHarga;
   

    public ImageIcon getSuscesicon() {
        return suscesicon;
    }

    public void setSuscesicon(ImageIcon suscesicon) {
        this.suscesicon = suscesicon;
    }

    public ImageIcon getEroricon() {
        return eroricon;
    }

    public void setEroricon(ImageIcon eroricon) {
        this.eroricon = eroricon;
    }

    public int getTotalHarga() {
        return totalHarga;
    }

    public void setTotalHarga(int totalHarga) {
        this.totalHarga = totalHarga;
    }
    
    
    
    public boolean getBarang(String keyword ){
        
      OrderInterface order = new Order();  
      boolean isMatch =false;
    
      
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
    
  
  public void addProductToKeranjang(JTable table){
 
      OrderInterface order = new Order();  
     
      int selectedRow=Dashbord.table_cariBelanja.getSelectedRow();
      if(Dashbord.table_cariBelanja.getValueAt(selectedRow, 3).toString().equals("0")){
         JOptionPane.showMessageDialog(null, "Tidak Bisa menambahkan Product, Stok Habis !", "Product Kosong", JOptionPane.INFORMATION_MESSAGE, eroricon);
      }else{
      int count = table.getRowCount();
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
              String k_product = table.getValueAt(i, 1).toString();
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
  

  public void jop(String message){
      JOptionPane.showMessageDialog(null, message, "Terjadi Kesalahan", JOptionPane.INFORMATION_MESSAGE, eroricon);

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
  public int hitungTotalHarga(){
     
       int res_diskon=0;
       KonfirmasiBayarService bayar = new KonfirmasiBayarService();
       String sub = bayar.setSubtotal();
        int diskon = 0;
        String nilai_input_diskon = KonfirmasiBayar.txt_diskon.getText().replaceAll("[^0-9]", "");
        System.out.println("diskon ="+nilai_input_diskon);
     
        if(!nilai_input_diskon.equals("")){
            diskon = Integer.parseInt(nilai_input_diskon);
            if(diskon >100){
                jop("Diskon tidak boleh lebih 100");
                 KonfirmasiBayar.txt_diskon.setText("");
                 
                 KonfirmasiBayar.txt_totalHarga.setText(bayar.setSubtotal());
                 
            }
            int totalBelanja=Integer.parseInt(KonfirmasiBayar.txt_SubTotal.getText());
                 int diskon_new = totalBelanja*diskon/100;
                 res_diskon = totalBelanja-diskon_new;
          
        }else if(nilai_input_diskon.equals("")){
             
             KonfirmasiBayar.txt_totalHarga.setText(sub);
             System.out.println("sub"+sub);
             System.out.println("ya");
             res_diskon=Integer.parseInt(sub);
        }

        this.setTotalHarga(res_diskon);
        return this.getTotalHarga();
  }
  
  public int bayar(String bayar , KonfirmasiBayar byr){
   
      System.out.println("ba "+bayar);
      int bayarInt = Integer.parseInt(bayar);
      int kembalian=0;
      int total=Integer.parseInt(KonfirmasiBayar.txt_totalHarga.getText());
      if(bayar.equals("")){
          jop("Harap Isi Field Bayar Terlebih Dahulu");
      }else if(bayarInt < total){
          jop("Total Bayar Customer Kurang !");
      }else{
         kembalian=bayarInt-total;  
         TransaksiBerhasil transaksi = new TransaksiBerhasil();
         
         transaksi.action();
         byr.dispose();
         
      }
      return kembalian;
     
  }
  public void addTransaksi(String id , String grandTotal , String bayar , String idPegawai, String kembali){
      OrderInterface order = new Order();
    
          order.addIdTransaksi(id, grandTotal, bayar, idPegawai, kembali);
      
 
  }
  public void insertDataOrder( JTable table){
      OrderInterface order = new Order();
      
      int rowCount = table.getRowCount();
      System.out.println("row"+ rowCount);
      String id =KonfirmasiBayar.tx_idTransaksi.getText();
      
      //melakukan insert detail transaksi sebanyak barang yang dipesan
      for(int i=0; i<rowCount; i++){
          String kode =table.getValueAt(i, 1).toString();
          String subTotal=table.getValueAt(i, 6).toString();
          String qty =table.getValueAt(i, 4).toString();
          System.out.println("kode"+kode);
          order.insertDataOrder(id, kode, subTotal, qty);
      }
      
  }
  public void cetakPenjualan(String kode , String diskon , String kasir , String harga){
      OrderInterface order = new Order();
      order.cetakStruct(kode,diskon,kasir , harga);
  }
}
