/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import Util.Bulan;
import Util.IdBarang;
import Util.tanggalSaatIni;
import View.Dashbord;
import View.DataBarangTambah;
import com.barcodelib.barcode.Linear;
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
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author user
 */

public class Barang implements BarangInterface{
    
    Database dt = new Database();
    tanggalSaatIni tg = new tanggalSaatIni();
    
    private ImageIcon suscesicon =  new ImageIcon(getClass().getResource("/picture/checked.png"));
    private ImageIcon eroricon =  new ImageIcon(getClass().getResource("/picture/warning.png"));
    static DefaultTableModel model = new DefaultTableModel();
    Object[] data = new Object[9];
    int noTable=0;

    Bulan bulan = new Bulan();
    IdBarang id = new IdBarang();
    
    public Barang(){
       
    }

    public Bulan getBulan() {
        return bulan;
    }

    public Database getDt() {
        return dt;
    }

    public tanggalSaatIni getTg() {
        return tg;
    }

    public ImageIcon getEroricon() {
        return eroricon;
    }

    public ImageIcon getSuscesicon() {
        return suscesicon;
    }
    
    

    @Override
    public void insertTransaksiBeli(String id , String supplier , String tanggal , String kategori , int total , String bayar , String kembalian) {
        
        String sql ="INSERT INTO `beli_product`(`id_beliProduct`, `supplier`, `tanggal_beliProduct`, `"
                + "kategori` , `grand_total` , pegawai , bayar , kembalian , bulan , hari) VALUES (?,?,?,?,?,?,?,?,?,?)";
      
        try(Connection con = dt.conectDatabase();
            PreparedStatement pst = con.prepareStatement(sql)){
            
            pst.setString(1, id);
            pst.setString(2, supplier);
            pst.setString(3, tanggal);
            pst.setString(4, kategori);
            pst.setInt(5, total);
           
            pst.setString(6, Dashbord.label_idPegawai.getText());
            pst.setString(7, bayar);
            pst.setString(8, kembalian);
            pst.setInt(9,bulan.getindexBulan() );
            pst.setInt(10, bulan.getindexHari());
            pst.execute();
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
    }
    
    //static body yang akan diakses ketika class di load
    static{
        model.addColumn("No");
        model.addColumn("Kode Barang");
        model.addColumn("Nama Barang");
      
        model.addColumn("Total Stok");
      
        model.addColumn("Harga Beli");
        model.addColumn("Harga Jual");
        model.addColumn("Kategori");
       //` TambahBanyakBarang.tabel_addBanyak.setModel(model);
    }
    
    public void setModelTable(JTable table){
        table.setModel(model);
    }
    public void setModelRow(){
        model.setRowCount(0);
    }

    
    @Override
    public String getKodeKategori(JComboBox box){
        
        String sql="select kode_kategori from kategori where nama_kategori='"+box.getSelectedItem().toString()+"'";
        String kode="";
        
        try(Connection con = dt.conectDatabase();
            Statement st =con.createStatement();
            ResultSet res =st.executeQuery(sql)){            
            if(res.next()){
                kode=res.getString("kode_kategori");
            }            
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return kode;
    }
    
    @Override
    public  void showBarang(JTable table,String opsi) {
        DefaultTableModel model = new DefaultTableModel();
        int no =1;
        
            String sqlKat ="select * from kategori";
            String sqlSup ="select * from supplier";
            String sqlsh  ="select * from product";
            String sqlRet ="select * from retur_supplier";
            
            String sql = "select product.kode_product,product.nama_product, product.harga_jual,product.harga_beli,product."
                    + "stok,product.rusak , product.total_stok, supplier.nama_supplier,kategori.nama_kategori from "
                    + "product join kategori on product.kategori = kategori.kode_kategori join supplier on product.supplier = "
                    + "supplier.kode_supplier order by product.kode_product asc ";
            String sqlKategori ="select kode_kategori, nama_kategori from kategori order by kode_kategori asc";
            String sqlSupplier ="select kode_supplier, nama_supplier from supplier order by kode_supplier asc";
            String sqlReturnJoin="select product.kode_product , supplier.nama_supplier, retur_supplier.id_returSupplier,"
                    + " retur_supplier.tanggal_rtr,product.nama_product , detail_retur.jumlah_rusak from product join detail_retur"
                    + " on product.kode_product = detail_retur.product join retur_supplier on retur_supplier.id_returSupplier = "
                    + "detail_retur.id_returSupplier "
                    + "join supplier on supplier.kode_supplier = retur_supplier.kode_supplier";
            //return dihapus/visible
            String sqlReturn ="select supplier.nama_supplier, product.kode_product , tanggal_rtr , jumlah_rusak from "
                    + "retur_supplier join supplier on retur_supplier.kode_supplier = supplier.kode_supplier join product"
                    + " on retur_supplier.kode_product =product.kode_product order by retur_supplier.tanggal_rtr asc";
        //try with recource yang akan dipake sellama fungsi dijalankan saja    
        try(Connection con = dt.conectDatabase();
            Statement st =con.createStatement();
            Statement sta = con.createStatement();
            Statement stkat = con.createStatement();
            Statement stSup = con.createStatement();
            Statement stret = con.createStatement();
            ResultSet resRet =stret.executeQuery(sqlRet);
          
            ResultSet res2 = sta.executeQuery(sqlsh);
            ResultSet resK = stkat.executeQuery(sqlKat);
            ResultSet resSup = stSup.executeQuery(sqlSup);){
          //sql = "SELECT barang.kode_barang, barang.nama_barang, kategori.nama_kategori, barang.harga, barang.stok, supplier.nama_supplier FROM barang JOIN kategori ON barang.kategori = kategori.id_kategori JOIN supplier ON barang.supplier = supplier.id_supplier ORDER BY barang.nama_barang ASC"
                ResultSet res = st.executeQuery(sql);                   
                //akan menampilkan data barang                
                if(opsi.equals("barang")){     
                    res=st.executeQuery(sql);
                    model.addColumn("No");
                    model.addColumn("Kode Barang");
                    model.addColumn("Nama Barang");
                    model.addColumn("Total Stok");                
                    model.addColumn("Harga Beli");
                    model.addColumn("Harga Jual");
                    model.addColumn("Supplier");
                    model.addColumn("Kategori");                   
                    if(res2.next()){                       
                        while(res.next()){                           
                        model.addRow(new Object[]{
                        no,res.getString("kode_product"),
                        res.getString("nama_product"),
                        res.getString("stok"),                      
                        ("Rp."+res.getString("harga_beli")),
                        ("Rp."+ res.getString("harga_jual")),
                        res.getString("supplier.nama_supplier"),
                        res.getString("kategori.nama_kategori"),
                        });
                        no++; 
                        }          
                    }else{
                        //barang tidak ada di dalam database
                        JOptionPane.showMessageDialog(null, "Barang Kosong Silahkan Tambah Barang", "Information", JOptionPane.OK_OPTION);
                    }                   
                //akan menampilkan data supplier  
                }else if(opsi.equals("supplier")){
                    res=st.executeQuery(sqlSupplier);
                    model.addColumn("No");
                    model.addColumn("Kode Supplier");
                    model.addColumn("Nama Supplier");
                    if(resSup.next()){
                         while(res.next()){
                           model.addRow(new Object[]{
                           no,
                           res.getString("kode_supplier"),
                           res.getString("nama_supplier")                            
                       });
                       no++; 
                    }
                    }else{
                    //jika tidak ada supplier
                    JOptionPane.showMessageDialog(null, "Supplier Kosong Silahkan Tambah Supplier", "Information", JOptionPane.OK_OPTION);
                    }
                res.close();   
                }else if(opsi.equals("return")){                    
                 res=st.executeQuery(sqlReturnJoin);
                 model.addColumn("No");
                 model.addColumn("Id Return");
                 model.addColumn("Nama Supplier");
                 model.addColumn("Kode Barang");
                 model.addColumn("Tanggal Return");
                 model.addColumn("Jumlah Rusak");
                 if(resRet.next()){                     
                     while(res.next()){
                       model.addRow(new Object[]{
                       no,
                       res.getString("id_returSupplier"),
                       res.getString("supplier.nama_supplier"),
                       res.getString("product.kode_product"),
                       res.getString("tanggal_rtr"),
                       res.getString("detail_retur.jumlah_rusak")
                       });
                       no++;
                     }                    
                 }
                 res.close();      
                }
            table.setModel(model);
        }catch(SQLException exception){
            JOptionPane.showMessageDialog(null, exception.getMessage());
        }

    }

    @Override
    public void addComboboxItem(JComboBox box, String opsi) {  
        try{
             Connection con = dt.conectDatabase();
             Statement st =con.createStatement();
             ResultSet res;
        
             if(opsi.equals("kategori")){ 
                String sql ="select nama_kategori from kategori";
                res=st.executeQuery(sql);
                     while(res.next()){
                        box.addItem(res.getString("nama_kategori"));       
                     }
             //close statmenent
             con.close();
             st.close();
             res.close();    
        }
            else if(opsi.equals("supplier")){
                String sql ="select nama_supplier from supplier";
                res =st.executeQuery(sql);
                while(res.next()){
                    box.addItem(res.getString("nama_supplier"));
                }
             con.close();
             st.close();
             res.close();
            }
            
        }catch(SQLException e){
            
            
        }
        
    }

    
    public void addReturn(String supplier , String kode_product , String barang_rusak ){
        
       String sqlReturSupplier= "insert into retur_supplier (id_returSupplier , kode_supplier , tanggal_rtr )values (?, ? ,?)";
       String sqlDetailReturnSupplier ="insert into detail_retur (id_returSupplier , product, jumlah_rusak) values (? ,? ,?)";
       try(Connection con = dt.conectDatabase();
               
               PreparedStatement pstReturn =con.prepareStatement(sqlReturSupplier);
               PreparedStatement pstDet = con.prepareStatement(sqlDetailReturnSupplier)){
           
                   String kode =id.idReturSupplier();
                
                   pstReturn.setString(1, kode);
                   pstReturn.setString(2, supplier);
                   pstReturn.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
                   
                   pstDet.setString(1, kode);
                   pstDet.setString(2, kode_product);
                   pstDet.setString(3, barang_rusak);
                        
                   pstReturn.execute();
                   pstDet.execute();
           
       }catch(SQLException e){
           
       }
    }
    @Override
    
    public boolean addBarang(String nama_produt ,String kode_product , String harga_beli
            , String harga_jual , String totalstok , String barang_rusak  , String kategori , String supplier) {   
       boolean isSuces=false;
       //query
       String sqlInsert="Insert into product (`kode_product`, `nama_product`, `stok`, `harga_beli`, `harga_jual`, `supplier`, `kategori`, `create_at`, `update_at`, `rusak`,total_stok)"
               +         "values (? , ? , ? , ? , ? , ? , ? , ? , ? , ?,?)";
       String sqlReturSupplier= "insert into retur_supplier (id_returSupplier , kode_supplier , tanggal_rtr )values (?, ? ,?)";
       String sqlDetailReturnSupplier ="insert into detail_retur (id_returSupplier , product, jumlah_rusak) values (? ,? ,?)";
       
           try(Connection con = dt.conectDatabase();
               PreparedStatement pst =con.prepareStatement(sqlInsert);
               PreparedStatement pstReturn =con.prepareStatement(sqlReturSupplier);
               PreparedStatement pstDet = con.prepareStatement(sqlDetailReturnSupplier)){
            if(!nama_produt.equals("")&&!harga_beli.equals("")&&!harga_jual.equals("")&&!totalstok.equals("")&&!barang_rusak.equals(""))  {
                if(barang_rusak.equals("")){
                    throw  new SQLException("Data tidak Boleh kosong ");
                }

            pst.setString(1, kode_product.toUpperCase());
            pst.setString(2, nama_produt);
            int stokNew=Integer.parseInt(totalstok.replaceAll("[^a-zA-Z0-9]", "").replaceAll("[a-zA-Z]", ""));
          
            
            harga_beli.replaceAll("[^a-zA-Z0-9]", "").replaceAll("[a-zA-Z]", "");
            harga_jual.replaceAll("[^a-zA-Z0-9]", "").replaceAll("[a-zA-Z]", "");
           
//            if(harga_b >= harga_j){
//                throw new SQLException("Harga Jual tidak memungkingkan Input ulang !!");
//            }
            pst.setString(4, harga_beli);
            pst.setString(5, harga_jual);
            
            pst.setString(6, supplier);
            pst.setString(7, kategori);
            pst.setTimestamp(8, Timestamp.valueOf(LocalDateTime.now()));
            pst.setTimestamp(9,Timestamp.valueOf(LocalDateTime.now()));
            pst.setString(10, barang_rusak.replaceAll("[^a-zA-Z0-9]", "").replaceAll("[a-zA-Z]", ""));
           
            pst.setString(11, totalstok);
                        int stok_retur=   Integer.parseInt(barang_rusak.replaceAll("[^a-zA-Z0-9]", "").replaceAll("[a-zA-Z]", "")); 

            if(stok_retur==0){
                pst.setInt(3,stokNew-stok_retur);
                isSuces=true;
                pst.execute();
               // JOptionPane.showMessageDialog(null, "berhasil Menambahkan Barang dengan nama "+nama_produt+"","Susces",JOptionPane.INFORMATION_MESSAGE);
                //dta.dispose();
                
            }else{
                   pst.setInt(3,stokNew-stok_retur);
                   
                   int resetData = JOptionPane.showOptionDialog(null, "Terdapat Barang rusak sebanyak "+barang_rusak+"", "Informasi !", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
                   if(resetData==0){       
                         
                         addReturn(supplier, kode_product, barang_rusak);
                         isSuces=true;
                         pst.execute();

                        // JOptionPane.showMessageDialog(null, "berhasil Menambahkan Barang dengan nama "+nama_produt+"","Susces",JOptionPane.INFORMATION_MESSAGE);
//                         dta.dispose();
                   }
            }

            }
            
            else{
                throw new SQLException("Data tidak boleh kosong ");
            }

       }catch(SQLException e){
              JOptionPane.showMessageDialog(null, e.getMessage(), "Terjadi Kesalahan !", JOptionPane.INFORMATION_MESSAGE , getEroricon());
       }
 
           return isSuces;
           
    }
    
    
    
    
    @Override
    public void deleteBarang(){
        
        String sql="delete  from product where kode_product = ?";
   
        String sqlShowNol="select kode_product from product where total_stok =0";
        
        
        try(Connection con =dt.conectDatabase();
            
            Statement st = con.createStatement();
         
            ResultSet res = st.executeQuery(sqlShowNol)  ;
            PreparedStatement pst = con.prepareStatement(sql))
   
           {
            if(res.next()){
                String kode =res.getString("kode_product");
                System.out.println(kode);
                pst.setString(1, kode);
            }
            pst.execute();
 
        }catch(SQLException e){      
        }        
   }
     public String getIdBarang(boolean setNewKode, String kode,JComboBox box){
         String hsl = "";
         String kodeKategori="";          
         String namaKategoriTmp ;
         String namaKategoriResult;
         String hurufKategori="";
         String sqlGetKodeKat ="select kode_kategori from kategori where nama_kategori = '"+box.getSelectedItem().toString()+"'";
         try(Connection con = dt.conectDatabase();
             Statement st = con.createStatement() ;
             ResultSet res =st.executeQuery(sqlGetKodeKat)    ){
             
             if(res.next()){
                 kodeKategori=res.getString("kode_kategori");
                 
             }   
         }catch(SQLException e){
             System.out.println(e.getMessage());
         }
         
         
         
         String sqlNamaKategori="select nama_kategori from kategori where kode_kategori = '"+kodeKategori+"'";
         
         try(Connection con = dt.conectDatabase();
                 Statement st = con.createStatement();
                 ResultSet resi = st.executeQuery(sqlNamaKategori))
         {
             while(resi.next()){
                 namaKategoriTmp = resi.getString("nama_kategori"); 
                 char a =namaKategoriTmp.charAt(0);
                 char b = namaKategoriTmp.charAt(2);
                 char c = namaKategoriTmp.charAt(namaKategoriTmp.length()-1);
                 String finalA =Character.toString(a);
                 String finalB =Character.toString(b);
                 String finalC =Character.toString(c);
                 hurufKategori = finalA+finalB+finalC;
             }
         }catch(SQLException e){
             System.out.println(e.getMessage());
         }   
             
        String sql_getKodeBarang = "SELECT kode_product FROM product where kategori='"+kodeKategori+"' ORDER BY kode_product DESC LIMIT 1";
        try(Connection con = dt.conectDatabase();
            PreparedStatement pst = con.prepareStatement(sql_getKodeBarang);
            ResultSet res = pst.executeQuery(sql_getKodeBarang);){
          
            if(setNewKode==false){
                
             
            if(res.next()){
                String a = res.getString(1).replaceAll("[a-zA-Z]", "");
                String b = "";
                String c[] = a.split("(?!^)");
                String u = "";

                if("0".equals(c[0])){
                    if("0".equals(c[1])){
                        if("0".equals(c[2])){
                            b = c[3];
                        }else{
                            b = c[2]+c[3];
                        }
                    }else{
                        b = c[1]+c[2]+c[3];
                    }
                }else{
                    b = a;
                }

                int d = Integer.parseInt(b)+1;

                if(d <= 9){
                    u = "000";
                }else if(d <= 99 ){
                    u = "00";
                }else if(d <= 999){
                    u = "0";
                }else{
                    u = "";
                }
                hsl = u+""+d;
            }else{
                hsl = "0001";
            }
                
            }else if(setNewKode==true){
           
            if(res.next()){
                String a = res.getString(1).replaceAll("[a-zA-Z]", "");
                String b = "";
                String c[] = a.split("(?!^)");
                String u = "";

                if("0".equals(c[0])){
                    if("0".equals(c[1])){
                        if("0".equals(c[2])){
                            b = c[3];
                        }else{
                            b = c[2]+c[3];
                        }
                    }else{
                        b = c[1]+c[2]+c[3];
                    }
                }else{
                    b = a;
                }

                int d = Integer.parseInt(b)+1;

                if(d <= 9){
                    u = hurufKategori+"000";
                }else if(d <= 99 ){
                    u = hurufKategori+"00";
                }else if(d <= 999){
                    u = hurufKategori+"0";
                }else{
                    u = hurufKategori;
                }
                hsl = u+""+d;
            }else{
                hsl = hurufKategori+"0001";
            }
            }
           
          
            //remove space in primary key
            return hsl.toUpperCase().replaceAll(" ", "");
            
        }catch(SQLException err){
            return err.getMessage();
        }
    
      }  
     
     public String getIdEdit(boolean setNewKode, String kode,JComboBox box){
         String hsl = "";
         String kodeKategori="";
          
         String namaKategoriTmp ;
         String namaKategoriResult;
         String hurufKategori="";
         String sqlGetKodeKat ="select kode_kategori from kategori where nama_kategori = '"+box.getSelectedItem().toString()+"'";
         try(Connection con = dt.conectDatabase();
             Statement st = con.createStatement() ;
             ResultSet res =st.executeQuery(sqlGetKodeKat)    ){
             
             if(res.next()){
                 kodeKategori=res.getString("kode_kategori");
                 
             }
             
             
         }catch(SQLException e){
             System.out.println(e.getMessage());
         }
         
         
         
         String sqlNamaKategori="select nama_kategori from kategori where kode_kategori = '"+kodeKategori+"'";
         
         try(Connection con = dt.conectDatabase();
                 Statement st = con.createStatement();
                 ResultSet resi = st.executeQuery(sqlNamaKategori))
         {
             while(resi.next()){
                 namaKategoriTmp = resi.getString("nama_kategori"); 
                 char a =namaKategoriTmp.charAt(0);
                 char b = namaKategoriTmp.charAt(2);
                 char c = namaKategoriTmp.charAt(namaKategoriTmp.length()-1);
                 String finalA =Character.toString(a);
                 String finalB =Character.toString(b);
                 String finalC =Character.toString(c);
                 hurufKategori = finalA+finalB+finalC;
             }
         }catch(SQLException e){
             System.out.println(e.getMessage());
         }   
             
        String sql_getKodeBarang = "SELECT kode_product FROM product where kategori='"+kodeKategori+"' ORDER BY kode_product DESC LIMIT 1";
        try(Connection con = dt.conectDatabase();
            PreparedStatement pst = con.prepareStatement(sql_getKodeBarang);
            ResultSet res = pst.executeQuery(sql_getKodeBarang);){
          
            if(setNewKode==false){
                
             
            if(res.next()){
                String a = res.getString(1).replaceAll("[a-zA-Z]", "");
                String b = "";
                String c[] = a.split("(?!^)");
                String u = "";

                if("0".equals(c[0])){
                    if("0".equals(c[1])){
                        if("0".equals(c[2])){
                            b = c[3];
                        }else{
                            b = c[2]+c[3];
                        }
                    }else{
                        b = c[1]+c[2]+c[3];
                    }
                }else{
                    b = a;
                }

                int d = Integer.parseInt(b)+1;

                if(d <= 9){
                    u = "000";
                }else if(d <= 99 ){
                    u = "00";
                }else if(d <= 999){
                    u = "0";
                }else{
                    u = "";
                }
                hsl = u+""+d;
            }else{
                hsl = "0001";
            }
                
            }else if(setNewKode==true){
           
            if(res.next()){
                String a = res.getString(1).replaceAll("[a-zA-Z]", "");
                String b = "";
                String c[] = a.split("(?!^)");
                String u = "";

                if("0".equals(c[0])){
                    if("0".equals(c[1])){
                        if("0".equals(c[2])){
                            b = c[3];
                        }else{
                            b = c[2]+c[3];
                        }
                    }else{
                        b = c[1]+c[2]+c[3];
                    }
                }else{
                    b = a;
                }

                int d = Integer.parseInt(b)+1;

                if(d <= 9){
                    u = hurufKategori+"000";
                }else if(d <= 99 ){
                    u = hurufKategori+"00";
                }else if(d <= 999){
                    u = hurufKategori+"0";
                }else{
                    u = hurufKategori;
                }
                hsl = u+""+d;
            }else{
                hsl = hurufKategori+"0001";
            }
            }
           
          
            //remove space in primary key
            return hsl.toUpperCase().replaceAll(" ", "");
            
        }catch(SQLException err){
            return err.getMessage();
        }
    
      }  
     
    @Override
     public void editBarang(String kode_brg, String nama_product , int stok , int harga_beli , int harga_jual,   int rusak , 
        JComboBox kat , JComboBox sup, DataBarangTambah dta,String kode_baru){
        String kode_kategori=""; 
        String kode_supplier ="";
        tanggalSaatIni tg = new tanggalSaatIni();
        // query untuk menampilkan kode product dan supplier
        String sqlShowProduct="select * from product where kode_product ='"+kode_brg+"'";
        // sql untuk update product
        String sql ="update product set nama_product =? ,stok =? , " 
                +"harga_beli = ? , harga_jual=?, supplier=?, "        
                +"kategori =?, update_at =? , rusak =?, kode_product=?, total_stok=? where kode_product ='"+kode_brg+"'";
        String sqlRet ="update detail_retur set jumlah_rusak =? where product =?";
        String sqlShow ="select kode_kategori from kategori where nama_kategori ='"+kat.getSelectedItem().toString()+"'";
        String sqlShowSup ="select kode_supplier from supplier where nama_supplier ='"+sup.getSelectedItem().toString()+"'";
        try (Connection con = dt.conectDatabase();   
            Statement stShow =con.createStatement(); 
            Statement stSup = con.createStatement();
            Statement stKat = con.createStatement();      
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet resKat = stKat.executeQuery(sqlShow);
            ResultSet rsShowProduct =stShow.executeQuery(sqlShowProduct);
            ResultSet resSup = stSup.executeQuery(sqlShowSup);   
            PreparedStatement pstRet = con.prepareStatement(sqlRet);
            ){
            while(rsShowProduct.next()){
                if(resKat.next()){
                     kode_kategori =resKat.getString("kode_kategori");  
                }
                if(resSup.next()){
                      kode_supplier=resSup.getString("kode_supplier");
                }
           
            }
            pst.setString(1, nama_product);
            pst.setInt(2, stok);
            pst.setInt(3, harga_beli);
            pst.setInt(4, harga_jual);
        
            pst.setString(5, kode_supplier);
            pst.setString(6, kode_kategori);
            pst.setTimestamp(7, new Timestamp(System.currentTimeMillis()));
            String rusak_new = String.valueOf(rusak);
            pst.setInt(8, rusak);
            pst.setString(9, kode_baru);
            pst.setInt(10, stok+rusak);
            pstRet.setInt(1, rusak);
            pstRet.setString(2, kode_brg);
            pst.execute(); 
            pstRet.execute();
            JOptionPane.showMessageDialog(null, "Data Product Berhasil Diperbarui, Silakan Refresh Kembali !", "Success !", JOptionPane.INFORMATION_MESSAGE, suscesicon);
            dta.dispose();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        
    }

    @Override
    public void deleteBarang(String kode, DataBarangTambah dta) {

        int resetData = JOptionPane.showOptionDialog(null, "Apakah Anda Yakin Ingin Menghapus product ?", "Informasi !", 
                JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
        if(resetData==0){
            String sql ="delete from product where kode_product = ?";
            try(Connection con = dt.conectDatabase();
            PreparedStatement pst =con.prepareStatement(sql);)
            {
               pst.setString(1, kode);
               pst.executeUpdate();
           
               JOptionPane.showMessageDialog(null, "Product Berhasil Dihapus Silahkan Refresh !", "Sukses !", 
                       JOptionPane.INFORMATION_MESSAGE,suscesicon);
                showBarang(Dashbord.table_barang, "barang");
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Product gagal di hapus !","Eror !",JOptionPane.WARNING_MESSAGE);
            }
            
        }
    }
    @Override
     public String ambilStringKodeBarang(JComboBox box){
        
         String kodeKategori="";
          
         String namaKategoriTmp ;
 
         String hurufKategori="";
         String sqlGetKodeKat ="select kode_kategori from kategori where nama_kategori = '"+box.getSelectedItem().toString()+"'";
         try(Connection con = dt.conectDatabase();
             Statement st = con.createStatement() ;
             ResultSet res =st.executeQuery(sqlGetKodeKat)    ){
             
             if(res.next()){
                 kodeKategori=res.getString("kode_kategori");
             }
             
         }catch(SQLException e){
             System.out.println(e.getMessage());
         }
       
         String sqlNamaKategori="select nama_kategori from kategori where kode_kategori = '"+kodeKategori+"'";
         
         try(Connection con = dt.conectDatabase();
                 Statement st = con.createStatement();
                 ResultSet resi = st.executeQuery(sqlNamaKategori))
         {
             while(resi.next()){
                 namaKategoriTmp = resi.getString("nama_kategori"); 
                 char a =namaKategoriTmp.charAt(0);
                 char b = namaKategoriTmp.charAt(2);
                 char c = namaKategoriTmp.charAt(namaKategoriTmp.length()-1);
                 String finalA =Character.toString(a);
                 String finalB =Character.toString(b);
                 String finalC =Character.toString(c);
                 hurufKategori = finalA+finalB+finalC;
             }
         }catch(SQLException e){
             System.out.println(e.getMessage());
         }   
        return hurufKategori.toUpperCase();
        
    }
     public void deleteReturn(){

         String sql="select product from detail_retur where jumlah_rusak =0";
         String sqlDel="delete from detail_retur where kode_product =?";
         try(Connection con = dt.conectDatabase();
             Statement st = con.createStatement();
             ResultSet res = st.executeQuery(sql);
             PreparedStatement pst =con.prepareStatement(sqlDel)
              ){
                 while(res.next()){
                 pst.setString(1, res.getString("product"));
             }
             pst.execute();
             System.out.println("Berhasil");
             
         }catch(SQLException e){
             JOptionPane.showMessageDialog(null, e.getMessage(), "eror", JOptionPane.ERROR_MESSAGE);
         }
         
     }

    /**
     *
     * @return
     */
    @Override
     public String hitungTotalBarang(){
         
         String sql ="select COUNT(*) as jml from product";
         String total="";
         try(Connection con = dt.conectDatabase();
             Statement st = con.createStatement();
             ResultSet res = st.executeQuery(sql)){
             if(res.next()){
                 total=res.getString("jml");
             }
         }catch(SQLException e){
             JOptionPane.showMessageDialog(null, e.getMessage(), "eror", JOptionPane.ERROR_MESSAGE);

         }
         return total;
     }

    @Override
    public boolean cariBarang(String keyword ) {

        boolean isSuces=false;
          DefaultTableModel model = new DefaultTableModel();
                  model.addColumn("No");
                  model.addColumn("Kode Barang");
                  model.addColumn("Nama Barang");
                 
                  model.addColumn("Total Stok");
              
                  model.addColumn("Harga Beli");
                  model.addColumn("Harga Jual");
                  model.addColumn("Supplier");
                  model.addColumn("Kategori");
         
          String sql="select product.kode_product,product.nama_product, product.harga_jual,product.harga_beli,product.stok,product.rusak , product.total_stok, supplier.nama_supplier,kategori.nama_kategori from product join kategori on product.kategori = kategori.kode_kategori join supplier on product.supplier = supplier.kode_supplier where   product.kode_product like '%"+keyword+"%' or product.nama_product like '%"+keyword+"%'  order by product.kode_product asc ";
       
          try(Connection con = dt.conectDatabase();
              PreparedStatement pst = con.prepareStatement(sql);
              ResultSet res =pst.executeQuery(sql);
               )
            {
      
                 int no=1;
                 while(res.next()){
                      isSuces=true;
                     System.out.println("temu");
           
                    model.addRow(new Object[]{
                     
                     no,
                     res.getString("kode_product"),
                        res.getString("nama_product"),
                        res.getString("stok"),
                       
                      
                        ("Rp."+res.getString("harga_beli")),
                        ("Rp."+res.getString("harga_jual")),
                        res.getString("supplier.nama_supplier"),
                        res.getString("kategori.nama_kategori"),
                    }
                    );
                                         no++;

                }
                  Dashbord.table_barang.setModel(model);
                

          }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Gagal Menemukan Data Barang " , "Terjadi Kesalahan !" , JOptionPane.INFORMATION_MESSAGE , eroricon);
          }
        return isSuces;
          }

    @Override
    public String getIdSupplier(String kode) {
        
        
        String result="";
        String sql ="select kode_supplier from supplier where nama_supplier='"+kode+"'";
        
        try(Connection con = dt.conectDatabase();
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(sql)){
            
            if(res.next()){
                result=res.getString("kode_supplier");
            }
        }catch(SQLException e){
           JOptionPane.showMessageDialog(null, "Gagal Mendapatkan Id Supplier", "Terjadi Kesalahan!", JOptionPane.INFORMATION_MESSAGE, eroricon);  
        }
        return result;
           
        
    }

    @Override
    public void TambahBarangBanyak(String kode , String nama , String stok , String harga_beli , String harga_jual ,  String kategori) {
       
        String kode_kategori="";
       
        
        String sql ="select kode_kategori from kategori where nama_kategori='"+kategori+"'";
        try(Connection con = dt.conectDatabase();
            Statement st = con.createStatement();
            ResultSet res =st.executeQuery(sql)){
            if(res.next()){
                            kode_kategori=res.getString("kode_kategori");

            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        int totalStok =Integer.parseInt(stok);
      
        
        
        int stokTersedia=totalStok;
        int no =model.getRowCount()+1;
        data[0]=no;
        data[1]=kode;
        data[2]=nama;
       
        data[3]=stok;
       
        data[4]=harga_beli;
        data[5]=harga_jual;
        data[6]=kategori;
        
        
        model.addRow(data);
        
    }

    @Override
    public void insertDataTambahBanyakProduct(String id , String jumlah , String product) {
        String sql ="INSERT INTO `detail_beli_product`(`id_beliProduct`, `jumlahBeli`, `product`) VALUES (?,?,?)";       
        try(Connection con = dt.conectDatabase();
            PreparedStatement pst =con.prepareStatement(sql)){       
            pst.setString(1, id);
            pst.setString(2, jumlah);
            pst.setString(3, product);
            pst.execute();
            showBarang(Dashbord.table_barang, "barang");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        } 
    }
    
    @Override
    public String getIdBarangTambahBanyak(boolean setNewKode , JComboBox box ,JTable table) {
        
         String hsl = "";
      
          
         String namaKategoriTmp ;
        
         String hurufKategori="";
         
                 namaKategoriTmp = box.getSelectedItem().toString(); 
                 char ab =namaKategoriTmp.charAt(0);
                 char bc = namaKategoriTmp.charAt(2);
                 char cc = namaKategoriTmp.charAt(namaKategoriTmp.length()-1);
                 String finalA =Character.toString(ab);
                 String finalB =Character.toString(bc);
                 String finalC =Character.toString(cc);
                 hurufKategori = finalA+finalB+finalC;
           
             
      //  String sql_getKodeBarang = "SELECT kode_product FROM product where kategori='"+kodeKategori+"' ORDER BY kode_product DESC LIMIT 1";
            
           
            
            if(setNewKode==false){
            int row=table.getRowCount()-1;
                String kode =table.getValueAt(row, 1).toString();
                String a = kode.replaceAll("[a-zA-Z]", "");
                String b = "";
                String c[] = a.split("(?!^)");
                String u = "";
                if("0".equals(c[0])){
                    if("0".equals(c[1])){
                        if("0".equals(c[2])){
                            b = c[3];
                        }else{
                            b = c[2]+c[3];
                        }
                    }else{
                        b = c[1]+c[2]+c[3];
                    }
                }else{
                    b = a;
                }

                int d = Integer.parseInt(b)+1;

                if(d <= 9){
                    u = hurufKategori+"000";
                }else if(d <= 99 ){
                    u = hurufKategori+"00";
                }else if(d <= 999){
                    u = hurufKategori+"0";
                }else{
                    u = hurufKategori;
                }
                hsl = u+""+d;
            }
                
          
            //remove space in primary key
            return hsl.toUpperCase().replaceAll(" ", "");
            

    }

    @Override
    public boolean addBarangBanyak(String nama_produt ,String kode_product , String harga_beli
            , String harga_jual , String totalstok , String barang_rusak  , String kategori , String supplier , DataBarangTambah dta) {
        boolean isSucses=false;
         String sqlInsert="Insert into product (`kode_product`, `nama_product`, `stok`, `harga_beli`, `harga_jual`, `supplier`, `kategori`, `create_at`, `update_at`, `rusak`,total_stok)"
               + " values (? , ? , ? , ? , ? , ? , ? , ? , ? , ?,?)";
       String sqlReturSupplier= "insert into retur_supplier (id_returSupplier , kode_supplier , tanggal_rtr )values (?, ? ,?)";
       String sqlDetailReturnSupplier ="insert into detail_retur (id_returSupplier , product, jumlah_rusak) values (? ,? ,?)";
       
           try(Connection con = dt.conectDatabase();
               PreparedStatement pst =con.prepareStatement(sqlInsert);
               PreparedStatement pstReturn =con.prepareStatement(sqlReturSupplier);
               PreparedStatement pstDet = con.prepareStatement(sqlDetailReturnSupplier)){
            int stok_retur=   Integer.parseInt(barang_rusak.replaceAll("[^a-zA-Z0-9]", "").replaceAll("[a-zA-Z]", "")); 
            if(!nama_produt.equals("")&&!harga_beli.equals("")&&!harga_jual.equals("")&&!totalstok.equals("")&&!barang_rusak.equals(""))  {
                if(barang_rusak.equals("")){
                    throw  new SQLException("Data tidak Boleh kosong ");
                }
    
            pst.setString(1, kode_product.toUpperCase());
            pst.setString(2, nama_produt);
            int stokNew=Integer.parseInt(totalstok.replaceAll("[^a-zA-Z0-9]", "").replaceAll("[a-zA-Z]", ""));
          
            
            harga_beli.replaceAll("[^a-zA-Z0-9]", "").replaceAll("[a-zA-Z]", "");
            harga_jual.replaceAll("[^a-zA-Z0-9]", "").replaceAll("[a-zA-Z]", "");
            int harga_b =Integer.parseInt(harga_beli);
            int harga_j =Integer.parseInt(harga_jual);
            
            if(harga_b >= harga_j){
                throw new SQLException("Harga Jual tidak memungkingkan Input ulang !!");
            }
            pst.setString(4, harga_beli);
            pst.setString(5, harga_jual);
            
            pst.setString(6, supplier);
            pst.setString(7, kategori);
            pst.setTimestamp(8, Timestamp.valueOf(LocalDateTime.now()));
            pst.setTimestamp(9,Timestamp.valueOf(LocalDateTime.now()));
            pst.setString(10, barang_rusak.replaceAll("[^a-zA-Z0-9]", "").replaceAll("[a-zA-Z]", ""));
           
            pst.setString(11, totalstok);
            if(stok_retur==0){
                pst.setInt(3,stokNew-stok_retur);
                isSucses=true;
                pst.execute();
                dta.dispose();
     
            }else{
                   pst.setInt(3,stokNew-stok_retur);
                   
//                   int resetData = JOptionPane.showOptionDialog(null, "Terdapat Barang rusak sebanyak "+barang_rusak+"", "Informasi !", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
//                   if(resetData==0){       
                         
                         addReturn(supplier, kode_product, barang_rusak);
                         pst.execute();
                         isSucses=true;
                         dta.dispose();
//                   }
            }

            }  
            else{
                throw new SQLException("Data tidak boleh kosong ");
            }
            

       }catch(SQLException e){
              JOptionPane.showMessageDialog(null, e.getMessage(), "Terjadi Kesalahan !", JOptionPane.INFORMATION_MESSAGE);
       }
   
    
    return isSucses;
      
}

    @Override
    public void showBarangCombo(JComboBox box) {
        
        
        String sql="select nama_product from product";
        try(Connection con = dt.conectDatabase();
            Statement st =con.createStatement();
            ResultSet res =st.executeQuery(sql)){
            
            while(res.next()){
              box.addItem(res.getString("nama_product"));
            }   
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Gagal Menampilkan Nama Product", "Terjadi Kesalahan", JOptionPane.ERROR_MESSAGE, eroricon);
        }
       
    }
    @Override
    public String getIdProductBarcode(String nama) {
        String kode="";
        String sql="select kode_product from product where nama_product ='"+nama+"'";
        try(Connection con = dt.conectDatabase();
            Statement st = con.createStatement();
            ResultSet res =st.executeQuery(sql)){
            if(res.next()){
                kode=res.getString("kode_product");
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Gagal Mendapatkan Kode Barcode ","Terjadi Keslahan " , JOptionPane.ERROR_MESSAGE , eroricon);
        }
        return kode;
    }

    @Override
    public void cetakBarcode(String name) {  
       String sql ="select kode_product , nama_product , harga_jual from product where nama_product='"+name+"'";
       String kode="";
       String nama_pro="";
       String harga="";
       try{
           Connection con = dt.conectDatabase();
           Statement st = con.createStatement();
           ResultSet res =st.executeQuery(sql);
       
           if(res.next()){
             kode=res.getString("kode_product"); 
             nama_pro=res.getString("nama_product");
             harga=res.getString("harga_jual");
           }else{
               throw new SQLException("gagal");
           }
           
           String fileName ="/Report/Barcode.jasper";
           InputStream Report;
           Report=getClass().getResourceAsStream(fileName);
          // File namaile = newgetClass().getResourceAsStream("/View/ReporPenjualan.jasper");
           HashMap hash = new HashMap();
           
           Linear barcode = new Linear();
           barcode.setType(Linear.CODE128B);
           barcode.setData(kode);
           barcode.setI(11.0f);
           String fname =kode;
           barcode.renderBarcode("src/Report/"+fname+".png");
              
           hash.put("Barcode", name);
           hash.put("Nama_barang",nama_pro);
           hash.put("Harga","Rp."+harga);
           hash.put("barcode_path","src/Report/"+fname+".png");
    
           JasperPrint print;
           print = JasperFillManager.fillReport(Report, hash, con);
        
           File fileDelete= new File("src/Report/"+fname+".png");
           fileDelete.delete();           
        //  JasperPrintManager.printReport(print, false);  
           JasperViewer viewer=new JasperViewer(print,false);        
//           viewer.setZoomRatio(Component.CENTER_ALIGNMENT);
//          
           viewer.setVisible(true);
//           viewer.setExtendedState(viewer.MAXIMIZED_BOTH);
           
           
       }catch(Exception e){
           System.out.println(e.getMessage());
       }
        
    }


//  try (Connection con = dt.conectDatabase()){
//      String kode=getIdProductBarcode(name);
//      String fileName="/Report/Barcode.jasper";
//      InputStream report;
//      report = getClass().getResourceAsStream(fileName);
//      HashMap hash = new HashMap();
//      
//    Linear barcode = new Linear();
//  barcode.setType(Linear.CODE128A);
//  barcode.setData(KonfirmasiBayar.tx_idTransaksi.getText());
//  barcode.setI(11.0f);
//  String fname =KonfirmasiBayar.tx_idTransaksi.getText();
//  barcode.renderBarcode("src/Report/"+kode+".png");
//  hash.put("Barcode", name);
//    
//  JasperPrint print =JasperFillManager.fillReport(report, hash , con);
//  JasperViewer viewer=new JasperViewer(print,false);
//  viewer.setZoomRatio(Component.CENTER_ALIGNMENT);
//          
//  viewer.setVisible(true);
//  viewer.setExtendedState(viewer.MAXIMIZED_BOTH);
//  
//  }catch(Exception e){
//      JOptionPane.showMessageDialog(null, e.getMessage());
//  }
//  
    
//

    @Override
    public void cariBarangBerdasarkanKategori(String keyword) {
        DefaultTableModel model = new DefaultTableModel();
                  model.addColumn("No");
                  model.addColumn("Kode Barang");
                  model.addColumn("Nama Barang");
                  model.addColumn("Total Stok");
                  model.addColumn("Harga Beli");
                  model.addColumn("Harga Jual");
                  model.addColumn("Supplier");
                  model.addColumn("Kategori");
        
          String sqlKategori="select kode_kategori from kategori where nama_kategori='"+keyword+"'";
          String kodeKategori ="";
          
          try(Connection con = dt.conectDatabase();
              Statement st = con.createStatement();
               ResultSet res = st.executeQuery(sqlKategori)){    
               if(res.next()){
                 kodeKategori=res.getString("kode_kategori");
               }
          }catch(SQLException e){
              
          }
          
         
          String sql="select product.kode_product,product.nama_product, product.harga_jual,product.harga_beli,product.stok,product.rusak , product.total_stok, supplier.nama_supplier,kategori.nama_kategori from product join kategori on product.kategori = kategori.kode_kategori join supplier on product.supplier = supplier.kode_supplier where  kode_kategori like '%"+kodeKategori+"%' order by product.kode_product asc";
       
          try(Connection con = dt.conectDatabase();
              Statement st = con.createStatement();
              ResultSet res =st.executeQuery(sql);
               )
            {
                 int no=1;
                 while(res.next()){
                    model.addRow(new Object[]{                   
                     no,
                     res.getString("kode_product"),
                        res.getString("nama_product"),
                        res.getString("stok"),                   
                        ("Rp."+res.getString("harga_beli")),
                        ("Rp."+res.getString("harga_jual")),
                        res.getString("supplier.nama_supplier"),
                        res.getString("kategori.nama_kategori"),
                        
                    });
                    no++;
                }
                Dashbord.table_barang.setModel(model);
            }catch(SQLException e){
              System.out.println(e);
                JOptionPane.showMessageDialog(null, "Tidak ada Product dengan kategori ini", "Terjadi Kesalahan !", JOptionPane.ERROR, eroricon);

          }
        
    }

    @Override
    public void cetakBeliBarang(String id) {
        
        
        
    }

    @Override
    public String getStok(String nama_product) {
        
        String sql ="select stok from product where nama_product='"+nama_product+"'";
        String stok="";
        try(Connection con = dt.conectDatabase();
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(sql)){

            if(res.next()){
                stok=res.getString("stok");
            }
            
        }catch(SQLException e){
            
        }
        return stok;
    }

    @Override
    public String getKodeBarang(JComboBox box) {
        
        String kode="";
        String sql="select kode_product from product where nama_product='"+box.getSelectedItem().toString()+"'";
        
        try(Connection con = dt.conectDatabase();
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(sql)){
            
            if(res.next()){
                kode=res.getString("kode_product");
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return kode;
    }
    
    @Override
    public String getHargaBeli(String kode){
        String harga="";
        
        String sql="select harga_beli from product where kode_product ='"+kode+"'";
        
        try(Connection con = dt.conectDatabase();
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(sql)){
            
            
            if(res.next()){
                harga=res.getString("harga_beli");
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        
        return harga;
        
    }

    @Override
    public String getKodeSuppp(String nama) {
        
        String kode="";
        
        String sql ="select supplier from product where kode_product ='"+nama+"'";
        try(Connection con = dt.conectDatabase();
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(sql)){
            
            if(res.next()){
                kode=res.getString("supplier");
            }
        }catch(SQLException e){
            
        }
        return kode;
        
    }

    @Override
    public String getKodeKategori(String kode) {
         String kategori="";
        
        String sql ="select kategori from product where kode_product ='"+kode+"'";
        try(Connection con = dt.conectDatabase();
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(sql)){
            
            if(res.next()){
                kategori=res.getString("kategori");
            }
        }catch(SQLException e){
            
        }
        return kategori;
    }

    @Override
    public boolean updateStok(String kode , int stok) {
        
        String sqlStok ="select total_stok from product where kode_product ='"+kode+"'";
        int stokTmp=0;
        try(Connection con = dt.conectDatabase();
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(sqlStok)){
            
            if(res.next()){
                stokTmp=res.getInt("total_stok");
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        
        
        String sqlStokTersedia="select stok from product where kode_product='"+kode+"'";
          int stokTersedia=0;
        try(Connection con = dt.conectDatabase();
            Statement st = con.createStatement();
            ResultSet res =st.executeQuery(sqlStokTersedia)){
          
            if(res.next()){
                stokTersedia=res.getInt("stok");
            }
        }catch(SQLException e){
            
        }
        
        String sql ="update product set stok =?,  total_stok =? where kode_product =?";
        
        boolean isSuses=false;
        
        try(Connection con = dt.conectDatabase();
            PreparedStatement pst = con.prepareStatement(sql)){
            pst.setInt(1, stok+stokTersedia);
            System.out.println(stokTmp);
            pst.setInt(2, stok+stokTmp);
            pst.setString(3, kode);
            pst.execute();
            showBarang(Dashbord.table_barang, "barang");
            isSuses=true;
        }catch(SQLException e){
            isSuses=false;
            System.out.println(e);
            
        }
        return isSuses;
    }

    @Override
    public String getNamaBarang(String kode) {
        String nama="";
        String sql="select nama_product from product where kode_product='"+kode+"'";
        
        try(Connection con = dt.conectDatabase();
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(sql)){
            
            if(res.next()){
                nama=res.getString("nama_product");
            }
            
        }catch(SQLException e){
            System.out.println(e);
        }
        return nama;
    }

    @Override
    public int getBarangRusak(String kode) {
        
        int stok=0;
        
        String sql ="select rusak from product where kode_product='"+kode+"'";
        
        try(Connection con = dt.conectDatabase();
            Statement st =con.createStatement();
            ResultSet res = st.executeQuery(sql)){
            
            if(res.next()){
                stok=res.getInt("rusak");
            }
            
        }catch(SQLException e){
            
        }
        return stok;
    }

    @Override
    public void updateReturnAndBarang(String kode , String jumlahRusak , String opsi , String rusakNew) {
        
        String sqlDetRetur="update detail_retur set jumlah_rusak=? where product=?";
        String sqlProduct ="update product set rusak=? , stok = stok+rusak , rusak=total_stok -stok where kode_product=?";
        String sqlProductKurang ="update product set rusak=? , stok = stok-rusak where kode_product=?";
        
        try(Connection con = dt.conectDatabase();
            PreparedStatement pst = con.prepareStatement(sqlDetRetur);
            Connection cone = dt.conectDatabase() ;
            PreparedStatement pstPro = cone.prepareStatement(sqlProduct);
            Connection coneq = dt.conectDatabase();
            PreparedStatement pstMin = coneq.prepareCall(sqlProductKurang)){
            
            pst.setString(1, jumlahRusak);
             pst.setString(2, kode);
            pst.execute();
           
            if(opsi.equals("besar-rusak")){
                pstMin.setString(1, rusakNew);
                pstMin.setString(2, kode);
                pstMin.execute();
            }else if(opsi.equals("kecil-rusak")){
                   pstPro.setString(1, rusakNew);
            pstPro.setString(2, kode);
              pstPro.execute();
            
            }
         
           
          
            JOptionPane.showMessageDialog(null, "Berhasil update");
        }catch(SQLException e){
            System.out.println(e);
        }
        
        
    }
    
    
    
    
    
    
  
}

