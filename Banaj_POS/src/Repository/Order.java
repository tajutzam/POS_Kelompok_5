/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import Util.tanggalSaatIni;
import View.Dashbord;
import View.KonfirmasiOrder;
import static View.KonfirmasiOrder.txt_qty;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class Order implements OrderInterface {
    DefaultTableModel model = new DefaultTableModel();
    static public DefaultTableModel tbOrder = new DefaultTableModel();
    
    
    
    
    Object [] data = new Object[7];
      int no =0;

    
    //instansiasi Object yang dibutuhkan
    DatabaseInterface dt = new Database();
    ImageIcon suscesicon =  new ImageIcon(getClass().getResource("/picture/checked.png"));
    ImageIcon eroricon =  new ImageIcon(getClass().getResource("/picture/warning.png"));
    

    @Override
    //this overide method in paretnt
    public void addIdTransaksi(String id , String grandTotal , String bayar , String idPegawai, String kembali) {
       
       tanggalSaatIni tg = new tanggalSaatIni();
       String sql ="INSERT INTO `transaksi`"
                   + "(`id_transaksi`, `tanggal_transaksi`, `grand_total`, `bayar`, `id_pegawai`, `kembali`) "
                   + "VALUES (?,?,?,?,?,?)";
       
       
       try(Connection con = dt.conectDatabase();
           PreparedStatement pst = con.prepareStatement(sql)){
           
           
           pst.setString(1, id);
           pst.setTimestamp(2,Timestamp.valueOf(LocalDateTime.now()) );
           pst.setString(3,grandTotal );
           pst.setString(4, bayar);
           pst.setString(5, idPegawai);
           pst.setString(6, kembali);
           
           pst.execute();
           System.out.println("berhasil add");
       }catch(SQLException e){
           System.out.println(e.getMessage());
       }
        

    }
   
    static{
     
       tbOrder.addColumn("No");
       tbOrder.addColumn("Kode Barang");
       tbOrder.addColumn("Nama Barang");
       tbOrder.addColumn("Stok");
       tbOrder.addColumn("Qty");
       tbOrder.addColumn("Harga Jual");
       tbOrder.addColumn("Sub total");
       Dashbord.table_belanja.setRowHeight(30);
       Dashbord.table_belanja.setForeground(new Color(90, 90, 90));
       
       Dashbord.table_belanja.setModel(tbOrder); 
    }

   
  
    @Override
    //this overide in method parent
    public boolean cariBarang(String keyword , JTable table , String opsi ){
        boolean isMatch =false;
        model.addColumn("No");
        model.addColumn("Kode Barang");
        model.addColumn("Nama Barang");
        model.addColumn("Stok");
        model.addColumn("Harga Jual");
        
        table.setModel(model);
      
        //"SELECT * FROM kategori WHERE nama_kategori LIKE '%"+Keyword+"%' ORDER BY id_kategori ASC"
        String sql ="SELECT kode_product , nama_product , stok , harga_jual FROM product WHERE nama_product LIKE '%"+keyword+"%' or  kode_product like '%"+keyword+"%' AND stok !=0  Order by kode_product ASC ";
        String sqlStok = "select kode_product from product where stok !=0";
        int no=1;
        
        if(opsi.equals("match")){
            
        
            try(Connection con = dt.conectDatabase();
                
                
                Statement stat = con.createStatement();
                ResultSet res = stat.executeQuery(sql);
                Statement statement = con.createStatement();
                ResultSet resStok = statement.executeQuery(sqlStok)
                ){
                
//                pst.setString(1, keyword);
//                pst.execute();
             
                    
                
                if(resStok.next()){
                    while(res.next()){
                         model.addRow(new Object[]{
                        no,
                        res.getString("kode_product"),
                        res.getString("nama_product"),
                        res.getString("stok"),
                        res.getString("harga_jual")
                    });
                    no++;
                    }
                isMatch=true;
                }else{
                   isMatch=false;
                    model.addRow(new Object[]{
                        no,
                        res.getString("kode_product"),
                        res.getString("nama_product"),
                        res.getString("stok"),
                        res.getString("harga_jual")
                    });
                   throw new SQLException();
                   
                }
                
                
               
 
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Gagal Menampilkan Data barang","Barang Tidak Tersedia", JOptionPane.INFORMATION_MESSAGE, eroricon);
        
        }}else if(opsi.equals("reset")){
            {
            model.addRow(new Object[]{   
            });
        }
       
           
    }else if(opsi.equals("resetBelanja")){
                tbOrder.addRow(new Object[]{
                    
                });
                }
    return isMatch;
    
}
    
    
    @Override
    public String selectToOrder(String kode ){
        String namaBarang="";
        String sql ="select nama_product from product where kode_product='"+kode+"'";
        try(Connection con = dt.conectDatabase();
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(sql)){
            if(res.next()){
                   namaBarang=res.getString("nama_product");
                   System.out.println(namaBarang);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Gagal Menampilkan Product Order", "Terjai kesalahan", JOptionPane.INFORMATION_MESSAGE, eroricon);
        }
        return namaBarang;
    }
    
    @Override
    
    
    public void addProductToKeranjang(String kode){  
  
        String sql ="select  nama_product , stok , harga_jual from product where kode_product ='"+kode+"'";
        try(Connection con = dt.conectDatabase();
            Statement sta = con.createStatement();
            ResultSet res = sta.executeQuery(sql)){
            
        int no=Dashbord.table_belanja.getRowCount();
    
        data[0]= no+1;
        data [1]=KonfirmasiOrder.txt_kodeProduct.getText().toString();
      
        if(res.next()){
          
          
            data [2]= res.getString("nama_product");
            data [3]=res.getInt("stok"); 
            data[4]=KonfirmasiOrder.txt_qty.getText().toString().replaceAll("[a-zA-Z]","");
            data [5]= res.getString("harga_jual");
            int harga_jual = Integer.parseInt(data[5].toString());
            int qty = Integer.parseInt(data[4].toString());
            data[6]=harga_jual*qty;

       int i = model.getRowCount();
       System.out.println(i);
     
       tbOrder.addRow(data);
          no++;
        
        }else{
            System.out.println("Gagal Menemukan Data"); 
        }
      
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Gagal Menampilkan Product Ke keranjang", "Terjai kesalahan", JOptionPane.INFORMATION_MESSAGE, eroricon);
        }
   
}
      public void resetTableOrder(){
       tbOrder.setRowCount(0);
       model.setRowCount(0);
    }

    @Override
    public void insertDataOrder(String id , String kode , String subTotal ,String qty) {
        
        
        String sql="INSERT INTO `detail_transaksi`(`id_transaksi`, `kode_product`, `sub_total`, `qty`) VALUES (?,?,?,?)";
        
        try(Connection con = dt.conectDatabase();
            PreparedStatement pst = con.prepareStatement(sql)){
            
            pst.setString(1, id);
            pst.setString(2, kode);
            pst.setString(3, subTotal);
            pst.setString(4, qty);
            
            pst.execute();
            System.out.println("oke");
            
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void insertOrder() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


      
      
      
    
}
