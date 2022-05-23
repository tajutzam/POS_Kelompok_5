/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import Util.tanggalSaatIni;
import View.Dashbord;
import View.KonfirmasiBayar;
import View.KonfirmasiOrder;
import static View.KonfirmasiOrder.txt_qty;
import com.barcodelib.barcode.Linear;
import java.awt.Color;
import java.awt.Component;
import java.io.File;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.print.Printer;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRExporterContext;
import net.sf.jasperreports.view.JasperViewer;
import org.jfree.chart.block.CenterArrangement;



/**
 *
 * @author user
 */
public class Order implements OrderInterface {
    static public DefaultTableModel model = new DefaultTableModel();
    static public DefaultTableModel tbOrder = new DefaultTableModel();
    
    
    
    
    Object [] data = new Object[7];
      int no =0;

    
    //instansiasi Object yang dibutuhkan
    DatabaseInterface dt = new Database();
    ImageIcon suscesicon =  new ImageIcon(getClass().getResource("/picture/checked.png"));
    ImageIcon eroricon =  new ImageIcon(getClass().getResource("/picture/warning.png"));
    

  
    //this overide method in paretnt
    
  
    @Override
    public void addIdTransaksi(String id , String grandTotal , String bayar , String idPegawai, String kembali) {
       
       tanggalSaatIni tg = new tanggalSaatIni();
       String sql ="INSERT INTO `transaksi`"
                   + "(`id_transaksi`, `tanggal_transaksi`, `grand_total`, `bayar`, `id_pegawai`, `kembali`) "
                   + "VALUES (?,?,?,?,?,?)";
       
       
       try(Connection con = dt.conectDatabase();
           PreparedStatement pst = con.prepareStatement(sql)){
           
           
          
           if(bayar.equals("")){
               //throw new SQLException("Harap isi Field Terlebih dahulu");
           }else{
                 pst.setString(4, bayar);
                  pst.setString(1, id);
           pst.setTimestamp(2,Timestamp.valueOf(LocalDateTime.now()) );
           pst.setString(3,grandTotal );
              pst.setString(5, idPegawai);
           pst.setString(6, kembali);
           }
         
        
           
           pst.execute();
           System.out.println("berhasil add");
       }catch(SQLException e){
          // JOptionPane.showMessageDialog(null, "Harap Isi field Bayar Terlebih dahulu","Terjadi kesalahan !",JOptionPane.INFORMATION_MESSAGE);
       }
        

    }
   
    //saat clas pertama diload akan dijalankan dan membuat colum tborder
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
       
      
        model.addColumn("No");
        model.addColumn("Kode Barang");
        model.addColumn("Nama Barang");
        model.addColumn("Stok");
        model.addColumn("Harga Jual");
       
       Dashbord.table_cariBelanja.setModel(model);
    }

    @Override
    //this overide in method parent
    public boolean cariBarang(String keyword , JTable table , String opsi ){
        boolean isMatch =false;
       model.setRowCount(0);
        
        
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
                        ("Rp."+res.getString("harga_jual"))
                                 
                    });
                        no++;   
                        }
                   
                 
                isMatch=true;
                }else{
                  
                    model.addRow(new Object[]{
                        no,
                        res.getString("kode_product"),
                        res.getString("nama_product"),
                        res.getString("stok"),
                        ("Rp."+res.getString("harga_jual"))
                    });
                   isMatch=false;
                   throw new SQLException("");
                    
                   
                }

        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Gagal Menampilkan Data barang, barang "+e.getMessage(),"Barang Tidak Tersedia", JOptionPane.INFORMATION_MESSAGE, eroricon);
        
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
          no++;
          tbOrder.addRow(data);
        }else{
            System.out.println("Gagal Menemukan Data"); 
        }
        
        
      
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Gagal Menampilkan Product Ke keranjang", "Terjai kesalahan", JOptionPane.INFORMATION_MESSAGE, eroricon);
        }
    System.out.println(tbOrder.getRowCount());
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
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize(); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void insertOrder() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void cetakStruct(String kode , String diskon , String kasir ,String harga) {
        
       
       String sql ="select nama_toko , no_hp , alamat_toko from toko";
       String nama_toko;
       String no_hp;
       String alamat;
       try{
           Connection con = dt.conectDatabase();
           Statement st = con.createStatement();
           ResultSet res =st.executeQuery(sql);
           
           
           if(res.next()){
              nama_toko=res.getString("nama_toko");
              no_hp=res.getString("no_hp");
              alamat=res.getString("alamat_toko");
               System.out.println(nama_toko);
               
           }else{
               throw new SQLException("gagal");
           }
           
           String fileName ="/Report/ReporPenjualan.jasper";
           InputStream Report;
           Report=getClass().getResourceAsStream(fileName);
          // File namaile = newgetClass().getResourceAsStream("/View/ReporPenjualan.jasper");
           HashMap hash = new HashMap();
           
           Linear barcode = new Linear();
           barcode.setType(Linear.CODE128A);
           barcode.setData(KonfirmasiBayar.tx_idTransaksi.getText());
           barcode.setI(11.0f);
           String fname =KonfirmasiBayar.tx_idTransaksi.getText();
           barcode.renderBarcode("src/Report/"+fname+".png");
              
           hash.put("kode", kode);
           hash.put("nama_toko", nama_toko);
           hash.put("no_hp", no_hp);
           hash.put("alamat", alamat);
           hash.put("harga_total", harga);
           if(diskon.equals("")){
            hash.put("diskon", "0"+"%");
           }else{
            hash.put("diskon", diskon+"%");
           
            }
           
           hash.put("nama_kasir",kasir);
           hash.put("barcode_path","src/Report/"+fname+".png");
           
           
          
           JasperPrint print;
           print = JasperFillManager.fillReport(Report, hash, con);
          
           
           JasperPrintManager.printReport(print, false);
        
        
           File fileDelete= new File("src/Report/"+fname+".png");
           if(fileDelete.delete()){
               System.out.println("berhasil dihapus");
           }else{
               System.out.println("gagal dihapus");    
           }
       
//          

//           
           
       }catch(Exception e){
           System.out.println(e.getMessage());
       }
    }

    @Override
    public void cetakStructPembelian(String transaksi) {
        
           
       String sql ="select nama_toko , no_hp , alamat_toko from toko";
       String nama_toko;
       String no_hp;
       String alamat;
       try{
           Connection con = dt.conectDatabase();
           Statement st = con.createStatement();
           ResultSet res =st.executeQuery(sql);
           
           
           if(res.next()){
               nama_toko=res.getString("nama_toko");
               no_hp=res.getString("no_hp");
               alamat=res.getString("alamat_toko");
               System.out.println(nama_toko);
               
           }else{
               throw new SQLException("gagal");
           }
           String fileName ="/Report/ReportPembelian.jasper";
           InputStream Report;
           Report=getClass().getResourceAsStream(fileName);
          // File namaile = newgetClass().getResourceAsStream("/View/ReporPenjualan.jasper");
           HashMap hash = new HashMap();
           hash.put("nama_toko", nama_toko);
           hash.put("nohp", no_hp);
           hash.put("alamat", alamat);
           hash.put("transaksi",transaksi);
           
           JasperPrint print;
           print = JasperFillManager.fillReport(Report, hash , con);
           JasperViewer viewer = new JasperViewer(print,false);
           viewer.setVisible(true);
           
           
           
        
    }catch(SQLException e){
        
    }   
    catch (JRException ex) {
            Logger.getLogger(Order.class.getName()).log(Level.SEVERE, null, ex);
    }


    
      
 
      
    }  
}
