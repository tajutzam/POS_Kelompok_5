/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import Util.Bulan;
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
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Calendar;
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

    Object[] data = new Object[8];
    int no = 0;
    Bulan bulan = new Bulan();
    //instansiasi Object yang dibutuhkan
    DatabaseInterface dt = new Database();
    ImageIcon suscesicon = new ImageIcon(getClass().getResource("/picture/checked.png"));
    ImageIcon eroricon = new ImageIcon(getClass().getResource("/picture/warning.png"));

    //this overide method in paretnt
    @Override
    public void addIdTransaksi(String id, String grandTotal, String bayar, String idPegawai, String kembali, String grand_modal) {

        tanggalSaatIni tg = new tanggalSaatIni();
        String sql = "INSERT INTO `transaksi`"
                + "(`id_transaksi`, `tanggal_transaksi`, `grand_total`, `bayar`, `id_pegawai`, `kembali`,bulan , grand_modal , hari) "
                + "VALUES (?,?,?,?,?,?,?,?,?)";

        try (Connection con = dt.conectDatabase();
                PreparedStatement pst = con.prepareStatement(sql)) {

            if (bayar.equals("")) {
                //throw new SQLException("Harap isi Field Terlebih dahulu");
            } else {
                pst.setString(4, bayar);
                pst.setString(1, id);
                pst.setTimestamp(2, Timestamp.valueOf(LocalDateTime.now()));
                pst.setString(3, grandTotal);
                pst.setString(5, idPegawai);
                pst.setString(6, kembali);
                Calendar calendar = Calendar.getInstance();
                java.util.Date dt = calendar.getTime();
                int month = calendar.get(Calendar.MONTH) + 1;
                pst.setString(7, String.valueOf(month));
                pst.setString(8, grand_modal);
                pst.setInt(9, bulan.getindexHari());
            }

            pst.execute();
          
        } catch (SQLException e) {
            // JOptionPane.showMessageDialog(null, "Harap Isi field Bayar Terlebih dahulu","Terjadi kesalahan !",JOptionPane.INFORMATION_MESSAGE);
        }

    }

    //saat clas pertama diload akan dijalankan dan membuat colum tborder
    static {

        tbOrder.addColumn("No");
        tbOrder.addColumn("Kode Barang");
        tbOrder.addColumn("Nama Barang");
        tbOrder.addColumn("Stok");
        tbOrder.addColumn("Qty");
        tbOrder.addColumn("Harga Jual");
        tbOrder.addColumn("Harga Beli");
        tbOrder.addColumn("Sub total");

        Dashbord.table_belanja.setRowHeight(30);
        Dashbord.table_belanja.setForeground(new Color(90, 90, 90));
        Dashbord.table_belanja.setModel(tbOrder);

        model.addColumn("No");
        model.addColumn("Kode Barang");
        model.addColumn("Nama Barang");
        model.addColumn("Stok");
        model.addColumn("Harga Jual");
        model.addColumn("Harga Beli");

        Dashbord.table_cariBelanja.setModel(model);
    }

    @Override
    //this overide in method parent
    public boolean cariBarang(String keyword, JTable table, String opsi) {
        boolean isMatch = false;
        model.setRowCount(0);

        //"SELECT * FROM kategori WHERE nama_kategori LIKE '%"+Keyword+"%' ORDER BY id_kategori ASC"
        String sql = "SELECT kode_product ,harga_beli , nama_product , stok , harga_jual FROM product WHERE nama_product LIKE '%" + keyword + "%' or  kode_product like '%" + keyword + "%' AND stok !=0  Order by kode_product ASC ";
        String sqlStok = "select kode_product from product where stok !=0";
        int no = 1;

        if (opsi.equals("match")) {

            try (Connection con = dt.conectDatabase();
                    Statement stat = con.createStatement();
                    ResultSet res = stat.executeQuery(sql);
                    Statement statement = con.createStatement();
                    ResultSet resStok = statement.executeQuery(sqlStok)) {

//                pst.setString(1, keyword);
//                pst.execute();
                if (resStok.next()) {

                    while (res.next()) {

                        isMatch = true;
                        model.addRow(new Object[]{
                            no,
                            res.getString("kode_product"),
                            res.getString("nama_product"),
                            res.getString("stok"),
                            ("Rp." + res.getString("harga_jual")),
                            ("Rp." + res.getString("harga_beli"))

                        });
                        no++;
                    }

                } else {

                    model.addRow(new Object[]{
                        no,
                        res.getString("kode_product"),
                        res.getString("nama_product"),
                        res.getString("stok"),
                        ("Rp." + res.getString("harga_jual")),
                        ("Rp." + res.getString("harga_beli"))
                    });
                    isMatch = false;
                    throw new SQLException("");

                }

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Gagal Menampilkan Data barang, barang " + e.getMessage(), "Barang Tidak Tersedia", JOptionPane.INFORMATION_MESSAGE, eroricon);

            }
        } else if (opsi.equals("reset")) {
            {
                model.addRow(new Object[]{});
            }
        } else if (opsi.equals("resetBelanja")) {
            tbOrder.addRow(new Object[]{});
        }
        return isMatch;

    }

    @Override
    public String selectToOrder(String kode) {
        String namaBarang = "";
        String sql = "select nama_product from product where kode_product='" + kode + "'";
        try (Connection con = dt.conectDatabase();
                Statement st = con.createStatement();
                ResultSet res = st.executeQuery(sql)) {
            if (res.next()) {
                namaBarang = res.getString("nama_product");
              
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal Menampilkan Product Order", "Terjai kesalahan", JOptionPane.INFORMATION_MESSAGE, eroricon);
        }
        return namaBarang;
    }

    @Override

    public void addProductToKeranjang(String kode) {

        String sql = "select  nama_product , stok , harga_jual ,harga_beli from product where kode_product ='" + kode + "'";
        try (Connection con = dt.conectDatabase();
                Statement sta = con.createStatement();
                ResultSet res = sta.executeQuery(sql)) {

            int no = Dashbord.table_belanja.getRowCount();

            data[0] = no + 1;
            data[1] = KonfirmasiOrder.txt_kodeProduct.getText().toString();

            if (res.next()) {
                data[2] = res.getString("nama_product");
                data[3] = res.getInt("stok");
                data[4] = KonfirmasiOrder.txt_qty.getText().toString().replaceAll("[a-zA-Z]", "");
                data[5] = res.getString("harga_jual");
                int harga_jual = Integer.parseInt(data[5].toString());
                int qty = Integer.parseInt(data[4].toString());
                int harga_beli = Integer.parseInt(res.getString("harga_beli"));

                data[6] = qty * harga_beli;
                data[7] = harga_jual * qty;

                int i = model.getRowCount();
               
                no++;
                tbOrder.addRow(data);
            } else {
                System.out.println("Gagal Menemukan Data");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal Menampilkan Product Ke keranjang", "Terjai kesalahan", JOptionPane.INFORMATION_MESSAGE, eroricon);
        }
       
    }

    public void resetTableOrder() {
        tbOrder.setRowCount(0);
        model.setRowCount(0);
    }

    @Override
    public void insertDataOrder(String id, String kode, String subTotal, String qty, String subPembelian) {
        String sql = "INSERT INTO `detail_transaksi`(`id_transaksi`, `kode_product`, `sub_total`, `qty` ,sub_pembelian) VALUES (?,?,?,?,?)";
        try (Connection con = dt.conectDatabase();
                PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, id);
            pst.setString(2, kode);
            pst.setString(3, subTotal);
            pst.setString(4, qty);
            pst.setString(5, subPembelian);
            pst.execute();
        } catch (SQLException e) {
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
    public void cetakStruct(String kode, String diskon, String harga) {

        String sql = "select nama_toko , no_hp , alamat_toko from toko";
        String nama_toko;
        String no_hp;
        String alamat;
        try {
            Connection con = dt.conectDatabase();
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(sql);

            if (res.next()) {
                nama_toko = res.getString("nama_toko");
                no_hp = res.getString("no_hp");
                alamat = res.getString("alamat_toko");
                System.out.println(nama_toko);

            } else {
                throw new SQLException("gagal");
            }

            String fileName = "/Report/ReporPenjualan.jasper";
            InputStream Report;
            Report = getClass().getResourceAsStream(fileName);
            // File namaile = newgetClass().getResourceAsStream("/View/ReporPenjualan.jasper");
            HashMap hash = new HashMap();

            Linear barcode = new Linear();
            barcode.setType(Linear.CODE128A);
            barcode.setData(kode);
            barcode.setI(11.0f);
            String fname = kode;
            barcode.renderBarcode("src/Report/" + fname + ".png");

            hash.put("kode", kode);
            hash.put("nama_toko", nama_toko);
            hash.put("no_hp", no_hp);
            hash.put("alamat", alamat);
            hash.put("harga_total", harga);
            if (diskon.equals("")) {
                hash.put("diskon", "0" + "%");
            } else {
                hash.put("diskon", diskon + "%");

            }

            hash.put("barcode_path", "src/Report/" + fname + ".png");

            JasperPrint print;
            print = JasperFillManager.fillReport(Report, hash, con);

            JasperPrintManager.printReport(print, false);
            
            File fileDelete = new File("src/Report/" + fname + ".png");
            fileDelete.delete();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void cetakStructPembelian(String transaksi) {

        String sql = "select nama_toko , no_hp , alamat_toko from toko";
        String nama_toko;
        String no_hp;
        String alamat;
        try {
            Connection con = dt.conectDatabase();
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(sql);

            if (res.next()) {
                nama_toko = res.getString("nama_toko");
                no_hp = res.getString("no_hp");
                alamat = res.getString("alamat_toko");
                System.out.println(nama_toko);

            } else {
                throw new SQLException("gagal");
            }
            String fileName = "/Report/ReportPembelian.jasper";
            InputStream Report;
            Report = getClass().getResourceAsStream(fileName);
            // File namaile = newgetClass().getResourceAsStream("/View/ReporPenjualan.jasper");
            HashMap hash = new HashMap();
            hash.put("nama_toko", nama_toko);
            hash.put("nohp", no_hp);
            hash.put("alamat", alamat);
            hash.put("transaksi", transaksi);

            JasperPrint print;
            print = JasperFillManager.fillReport(Report, hash, con);
            JasperPrintManager.printReport(print, false);

        } catch (SQLException e) {

        } catch (JRException ex) {
            Logger.getLogger(Order.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public String showPenjualan(int indek) {
        String show = "";
        String sql = "SELECT SUM(grand_total) as penghasilan from transaksi where bulan ="+indek+"";
        try (Connection con = dt.conectDatabase();
                Statement st = con.createStatement();
                ResultSet res = st.executeQuery(sql)) {

            if (res.next()) {
                show = res.getString("penghasilan");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return show;
    }

    @Override
    public String getUntung() {
        String untung="";
        Bulan bulan  = new Bulan();
        int indexBulan = bulan.getindexBulan();
     
       // System.out.println(indexBulan);
        String sql="SELECT sum(transaksi.grand_total - transaksi.grand_modal) as untung from transaksi where bulan = "+indexBulan+"";
        try(Connection con = dt.conectDatabase();
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(sql)){
            
           
            if(res.next()){
              untung=res.getString("untung");
               
            }else{
              untung="0";
            }
        }catch(SQLException e){
            System.out.println(e);
        }
    return untung;

}

    @Override
    public String getPengeluaran() {
        Bulan bulan = new Bulan();
        int indek = bulan.getindexBulan();
        
        String pengeluaran="";
        String sql="SELECT sum(beli_product.grand_total) as pengeluaran from beli_product where bulan ="+indek+"";
        
        try(Connection con = dt.conectDatabase();
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(sql)){
            
            if(res.next()){
                pengeluaran=res.getString("pengeluaran");
            }
            
        }catch(SQLException e){
            System.out.println(e);
        }
        return pengeluaran;
    }
    
    
    
     public int showPenjualanint(int indek) {
        int show=0;
       
       // System.out.println(indexBulan);
        String sql="SELECT sum(transaksi.grand_total - transaksi.grand_modal) as untung from transaksi where bulan = "+indek+"";
        try(Connection con = dt.conectDatabase();
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(sql)){
            
           
            if(res.next()){
              show+=res.getInt("untung");  
            }else{
              show=0;
            }
        }catch(SQLException e){
            System.out.println(e);
        }
    return show;
    }

    @Override
    public   void barangPalingBanyakDiminati(JTable table) {
        int no=0;
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No");
        model.addColumn("Nama Barang");
        model.addColumn("Jumlah Terjual");
        table.setRowHeight(30);
        
        
        String sql="select product.nama_product ,count(detail_transaksi.kode_product) as populer from detail_transaksi join product on product.kode_product = detail_transaksi.kode_product GROUP by product.nama_product order by populer DESC limit 5";
        
        try(Connection con = dt.conectDatabase();
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(sql)){
            
            while(res.next()){
                no++;
                model.addRow(new Object[]{
                    no,
                    res.getString("product.nama_product"),
                    res.getString("populer")
                    
                    
                });
           
            }
            table.setModel(model);
            
        }catch(SQLException e){
            System.out.println(e);
        }
        
        
        
        
    }
  
}
