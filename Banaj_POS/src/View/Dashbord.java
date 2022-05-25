/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Repository.Order;
import Repository.User;
import Util.Id;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.geom.RoundRectangle2D;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.data.category.DefaultCategoryDataset;
import service.KonfirmasiBayarService;
import service.OrderService;
import service.UserService;

import service.barangService;
import service.kategoriService;
import service.supplierService;


/**
 *
 * @author user
 */
public class Dashbord extends javax.swing.JFrame {

    /**
     * Creates new form Dashbord
     */
    String kode_lama;
    String kode_kategori;
    String nama_kategori;
    String time_update;
    String kode_supplier;
    String id_pegawai;
    
    Dimension dimAx = Toolkit.getDefaultToolkit().getScreenSize();
    Dimension dimIn = Toolkit.getDefaultToolkit().getBestCursorSize(1366, 768);
    ImageIcon suscesicon =  new ImageIcon(getClass().getResource("/picture/checked.png"));
        ImageIcon eroricon =  new ImageIcon(getClass().getResource("/picture/warning.png"));

 
   
    
    public Dashbord(String role) {
        
        initComponents();
        this.setSize(1366,768);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setMaximumSize(dimAx);
        this.setMinimumSize(dimIn);
        this.setBackground(new Color(255,255,255));
        
        //set tinggi tabel
        table_barang.setRowHeight(30);
        tabel_kategori.setRowHeight(30);
        table_supplier.setRowHeight(30);
        table_return.setRowHeight(30);
        
        //meletakan pada tengah
        this.setLocationRelativeTo(null);
        //visibilitas icon
        
        panel_iconProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/parfume.png")));
        icon_kasir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/cart (1).png")));
        icon_dashbord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/airplayPurple.png")));
        panel_iconSetting.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/settingWhite.png")));
        panel_iconLaporan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/pulse (1).png")));
        panel_iconManager.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/managerWhite.png")));
        
        //mengisi value pada combo box kategori
        ConntainerPanel.removeAll();
        ConntainerPanel.add(panel_contenDashbord);
        ConntainerPanel.repaint();
        ConntainerPanel.revalidate();
        showChart();
        barangService br = new barangService();
        br.addItemInCombobox(comboBox_showBarang);
        
        //setting height in table
        tabel_kategori.setRowHeight(30);
        table_barang.setRowHeight(30);
        table_supplier.setRowHeight(30);
        table_return.setRowHeight(30);
        table_user.setRowHeight(30);
        table_belanja.setRowHeight(30);
        table_cariBelanja.setRowHeight(30);
        
        //setting color text table
        tabel_kategori.setForeground(new Color(90, 90, 90));
        table_barang.setForeground(new Color(90, 90, 90));
        table_supplier.setForeground(new Color(90, 90, 90));
        table_return.setForeground(new Color(90, 90, 90));
        table_user.setForeground(new Color(90, 90, 90));
        //set table cant editable
        table_belanja.setDefaultEditor(Object.class, null);
        table_cariBelanja.setDefaultEditor(Object.class, null);
        //setVisibilitas idpegawai login
        label_idPegawai.setVisible(true);
        label_namaPegawai.setVisible(true);
        
        //visibilitas hak akses user login
        if(role.equals("2")){
          panel_product.setVisible(false);
          panel_iconLaporan.setVisible(false);
          panel_iconManager.setVisible(false);
          panel_iconProduct.setVisible(false);
          
          panel_laporan.setVisible(false);
          panel_manager.setVisible(false);
          
        
    }
    }
  
    
    public void setNamaUserLogin(String nama){
       label_namaPegawai.setText(nama);
    }
    public void setIdPegawai(String id){
       label_idPegawai.setText(id);
    }
    
    
   public String getKode(){
       return kode_lama;
        
   }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        frame_logo_toko = new javax.swing.JPanel();
        navigasi_panel = new javax.swing.JPanel();
        panel_dashbord = new javax.swing.JPanel();
        icon_dashbord = new javax.swing.JLabel();
        panel_product = new javax.swing.JPanel();
        panel_iconProduct = new javax.swing.JLabel();
        panel_kasir = new javax.swing.JPanel();
        icon_kasir = new javax.swing.JLabel();
        panel_manager = new javax.swing.JPanel();
        panel_iconManager = new javax.swing.JLabel();
        panel_laporan = new javax.swing.JPanel();
        panel_iconLaporan = new javax.swing.JLabel();
        panel_setting = new javax.swing.JPanel();
        panel_iconSetting = new javax.swing.JLabel();
        ConntainerPanel = new javax.swing.JPanel();
        panel_contenBarang = new javax.swing.JPanel();
        panel_navigasiBarang = new RoundedPanel(8, new Color(255, 255, 255));
        label_navigasi_barang = new javax.swing.JLabel();
        label_navigasi_Kategori = new javax.swing.JLabel();
        label_navigasi_supplier = new javax.swing.JLabel();
        label_navigasi_return = new javax.swing.JLabel();
        conten_manajemen = new javax.swing.JPanel();
        contenBarang = new javax.swing.JPanel();
        panel_totalBarang = new RoundedPanel(8, new Color(255, 255, 255));
        label_totalBarang = new javax.swing.JLabel();
        txt_totalBrg = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        comboBox_showBarang = new javax.swing.JComboBox<>();
        panel_cariBarang = new RoundedPanel(8, new Color(255, 255, 255));
        txt_cariBrng = new javax.swing.JTextField();
        icon_cariBarang = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        table_barang = new javax.swing.JTable();
        btn_TambahBarang = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        Barcode = new javax.swing.JButton();
        contenKategori = new javax.swing.JPanel();
        panel_cariKategori = new RoundedPanel(8, new Color(255, 255, 255));
        txt_cariKategori = new javax.swing.JTextField();
        icon_cariKategori = new javax.swing.JLabel();
        btn_TambahBarang1 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabel_kategori = new javax.swing.JTable();
        panel_totalKategori = new RoundedPanel(8, new Color(255, 255, 255));
        label_totalKategori = new javax.swing.JLabel();
        txt_totalKategori = new javax.swing.JLabel();
        icon_kategori = new javax.swing.JLabel();
        contenReturn = new javax.swing.JPanel();
        btn_tambahReturn = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        table_return = new javax.swing.JTable();
        panel_totalReturn = new RoundedPanel(8, new Color(255, 255, 255));
        label_totalReturn = new javax.swing.JLabel();
        txt_totalReturn = new javax.swing.JLabel();
        icon_return = new javax.swing.JLabel();
        panel_cariReturn = new RoundedPanel(8, new Color(255, 255, 255));
        txt_cariSupplier1 = new javax.swing.JTextField();
        icon_cariSupplier1 = new javax.swing.JLabel();
        contenSupplier = new javax.swing.JPanel();
        panel_cariSupplier = new RoundedPanel(8, new Color(255, 255, 255));
        txt_cariSupplier = new javax.swing.JTextField();
        icon_cariSupplier = new javax.swing.JLabel();
        panel_totalSupplier = new RoundedPanel(8, new Color(255, 255, 255));
        label_totalBarang4 = new javax.swing.JLabel();
        txt_totalSupplier = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        table_supplier = new javax.swing.JTable();
        btn_tambahSupplier = new javax.swing.JButton();
        panel_info = new RoundedPanel(8, new Color(255, 255, 255));
        jLabel12 = new javax.swing.JLabel();
        panel_contenKasir = new javax.swing.JPanel();
        panel_cariKasir = new RoundedPanel(8, new Color(255, 255, 255));
        jLabel22 = new javax.swing.JLabel();
        txt_cariDataOrder = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        panel_hasilCari = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        table_cariBelanja = new javax.swing.JTable();
        panel_infoHarga = new RoundedPanel(8, new Color(255, 255, 255));
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        btn_Bayar = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        table_belanja = new javax.swing.JTable();
        btn_resetKeranjang = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        panel_contenSetting = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        label_setToko = new javax.swing.JLabel();
        label_setProfile = new javax.swing.JLabel();
        panel_contenManageUser = new javax.swing.JPanel();
        panel_totalUser = new RoundedPanel(8, new Color(255, 255, 255));
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        panel_TxtField = new RoundedPanel(8, new Color(255, 255, 255));
        TXT_cariUser = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        table_user = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        panel_contenLaporan = new javax.swing.JPanel();
        panel_navigasiLaporan = new RoundedPanel(8, Color.white);
        label_laporan_penjualan = new javax.swing.JLabel();
        label_laporanPemebelian = new javax.swing.JLabel();
        panel_containerLaporan = new javax.swing.JPanel();
        container_laporanPenjualan = new RoundedPanel(8, new Color(255, 255, 255));
        jScrollPane1 = new javax.swing.JScrollPane();
        table_laporanPenjualan = new javax.swing.JTable();
        show_laporanPenjualan = new javax.swing.JLabel();
        combo_boxPenjualan = new javax.swing.JComboBox<>();
        btn_exportPenjualan = new javax.swing.JButton();
        container_laporanPembelian = new RoundedPanel(8, new Color(255, 255, 255));
        jScrollPane2 = new javax.swing.JScrollPane();
        table_laporanPembelian = new javax.swing.JTable();
        show_laporanPembelian = new javax.swing.JLabel();
        combo_boxPembelian = new javax.swing.JComboBox<>();
        btn_exportPembelian = new javax.swing.JButton();
        panel_contenDashbord = new javax.swing.JPanel();
        icon_penghasilanSebulan = new RoundedPanel(8, new Color(255, 255, 255));
        jLabel2 = new javax.swing.JLabel();
        icon_pengSebulan = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new RoundedPanel(8, new Color(255, 255, 255));
        jLabel19 = new javax.swing.JLabel();
        icon_totalReturn = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        panel_chart = new javax.swing.JPanel();
        jPanel6 = new RoundedPanel(8, new Color(255, 255, 255));
        jScrollPane10 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jPanel7 = new RoundedPanel(8, new Color(255, 255, 255));
        total_PenjSebulan = new javax.swing.JLabel();
        icon_penjualanSebulan = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        header_panel = new RoundedPanel(0, new Color(111, 59, 160));
        label_page = new javax.swing.JLabel();
        label_namatoko = new javax.swing.JLabel();
        icon_user = new javax.swing.JLabel();
        label_tanggal = new javax.swing.JLabel();
        label_namaPegawai = new javax.swing.JLabel();
        label_role = new javax.swing.JLabel();
        label_idPegawai = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(239, 240, 245));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        frame_logo_toko.setBackground(new java.awt.Color(255, 255, 255));
        frame_logo_toko.setPreferredSize(new java.awt.Dimension(66, 66));

        javax.swing.GroupLayout frame_logo_tokoLayout = new javax.swing.GroupLayout(frame_logo_toko);
        frame_logo_toko.setLayout(frame_logo_tokoLayout);
        frame_logo_tokoLayout.setHorizontalGroup(
            frame_logo_tokoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        frame_logo_tokoLayout.setVerticalGroup(
            frame_logo_tokoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 66, Short.MAX_VALUE)
        );

        navigasi_panel.setBackground(new java.awt.Color(255, 255, 255));

        panel_dashbord.setBackground(new java.awt.Color(255, 255, 255));
        panel_dashbord.setPreferredSize(new java.awt.Dimension(66, 60));
        panel_dashbord.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panel_dashbordMouseClicked(evt);
            }
        });

        icon_dashbord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/airplay (1).png"))); // NOI18N
        icon_dashbord.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        icon_dashbord.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                icon_dashbordMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panel_dashbordLayout = new javax.swing.GroupLayout(panel_dashbord);
        panel_dashbord.setLayout(panel_dashbordLayout);
        panel_dashbordLayout.setHorizontalGroup(
            panel_dashbordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_dashbordLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(icon_dashbord)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        panel_dashbordLayout.setVerticalGroup(
            panel_dashbordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_dashbordLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(icon_dashbord)
                .addGap(19, 19, 19))
        );

        panel_product.setBackground(new java.awt.Color(255, 255, 255));
        panel_product.setPreferredSize(new java.awt.Dimension(66, 60));
        panel_product.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panel_productMouseClicked(evt);
            }
        });

        panel_iconProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/parfume.png"))); // NOI18N
        panel_iconProduct.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panel_iconProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panel_iconProductMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panel_productLayout = new javax.swing.GroupLayout(panel_product);
        panel_product.setLayout(panel_productLayout);
        panel_productLayout.setHorizontalGroup(
            panel_productLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_productLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(panel_iconProduct)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel_productLayout.setVerticalGroup(
            panel_productLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_productLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(panel_iconProduct)
                .addGap(19, 19, 19))
        );

        panel_kasir.setBackground(new java.awt.Color(255, 255, 255));
        panel_kasir.setPreferredSize(new java.awt.Dimension(66, 60));
        panel_kasir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panel_kasirMouseClicked(evt);
            }
        });

        icon_kasir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/cart (1).png"))); // NOI18N
        icon_kasir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        icon_kasir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                icon_kasirMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panel_kasirLayout = new javax.swing.GroupLayout(panel_kasir);
        panel_kasir.setLayout(panel_kasirLayout);
        panel_kasirLayout.setHorizontalGroup(
            panel_kasirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_kasirLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(icon_kasir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel_kasirLayout.setVerticalGroup(
            panel_kasirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_kasirLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(icon_kasir)
                .addGap(19, 19, 19))
        );

        panel_manager.setBackground(new java.awt.Color(255, 255, 255));
        panel_manager.setPreferredSize(new java.awt.Dimension(66, 60));
        panel_manager.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panel_managerMouseClicked(evt);
            }
        });

        panel_iconManager.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/managerWhite.png"))); // NOI18N
        panel_iconManager.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panel_iconManager.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panel_iconManagerMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panel_iconManagerMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout panel_managerLayout = new javax.swing.GroupLayout(panel_manager);
        panel_manager.setLayout(panel_managerLayout);
        panel_managerLayout.setHorizontalGroup(
            panel_managerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_managerLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(panel_iconManager)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        panel_managerLayout.setVerticalGroup(
            panel_managerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_managerLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(panel_iconManager)
                .addGap(19, 19, 19))
        );

        panel_laporan.setBackground(new java.awt.Color(255, 255, 255));
        panel_laporan.setPreferredSize(new java.awt.Dimension(66, 60));
        panel_laporan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panel_laporanMouseClicked(evt);
            }
        });

        panel_iconLaporan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/pulse (1).png"))); // NOI18N
        panel_iconLaporan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panel_iconLaporan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panel_iconLaporanMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panel_laporanLayout = new javax.swing.GroupLayout(panel_laporan);
        panel_laporan.setLayout(panel_laporanLayout);
        panel_laporanLayout.setHorizontalGroup(
            panel_laporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_laporanLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(panel_iconLaporan)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        panel_laporanLayout.setVerticalGroup(
            panel_laporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_laporanLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(panel_iconLaporan)
                .addGap(19, 19, 19))
        );

        panel_setting.setBackground(new java.awt.Color(255, 255, 255));
        panel_setting.setPreferredSize(new java.awt.Dimension(66, 60));
        panel_setting.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panel_settingMouseClicked(evt);
            }
        });

        panel_iconSetting.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/settingWhite.png"))); // NOI18N
        panel_iconSetting.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panel_iconSetting.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panel_iconSettingMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panel_settingLayout = new javax.swing.GroupLayout(panel_setting);
        panel_setting.setLayout(panel_settingLayout);
        panel_settingLayout.setHorizontalGroup(
            panel_settingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_settingLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(panel_iconSetting)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        panel_settingLayout.setVerticalGroup(
            panel_settingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_settingLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(panel_iconSetting)
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout navigasi_panelLayout = new javax.swing.GroupLayout(navigasi_panel);
        navigasi_panel.setLayout(navigasi_panelLayout);
        navigasi_panelLayout.setHorizontalGroup(
            navigasi_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_kasir, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
            .addComponent(panel_product, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
            .addComponent(panel_dashbord, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(panel_manager, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(panel_laporan, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(panel_setting, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        navigasi_panelLayout.setVerticalGroup(
            navigasi_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navigasi_panelLayout.createSequentialGroup()
                .addComponent(panel_dashbord, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(panel_kasir, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(panel_product, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(panel_manager, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(panel_laporan, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(panel_setting, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ConntainerPanel.setBackground(new java.awt.Color(239, 240, 245));
        ConntainerPanel.setLayout(new java.awt.CardLayout());

        panel_contenBarang.setBackground(new java.awt.Color(239, 240, 245));
        panel_contenBarang.setForeground(new java.awt.Color(255, 255, 255));

        label_navigasi_barang.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        label_navigasi_barang.setForeground(new java.awt.Color(90, 90, 90));
        label_navigasi_barang.setText("Barang");
        label_navigasi_barang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        label_navigasi_barang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_navigasi_barangMouseClicked(evt);
            }
        });

        label_navigasi_Kategori.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        label_navigasi_Kategori.setForeground(new java.awt.Color(90, 90, 90));
        label_navigasi_Kategori.setText("Kategori");
        label_navigasi_Kategori.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        label_navigasi_Kategori.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_navigasi_KategoriMouseClicked(evt);
            }
        });

        label_navigasi_supplier.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        label_navigasi_supplier.setForeground(new java.awt.Color(90, 90, 90));
        label_navigasi_supplier.setText("Supplier");
        label_navigasi_supplier.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        label_navigasi_supplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_navigasi_supplierMouseClicked(evt);
            }
        });

        label_navigasi_return.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        label_navigasi_return.setForeground(new java.awt.Color(90, 90, 90));
        label_navigasi_return.setText("Return");
        label_navigasi_return.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        label_navigasi_return.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_navigasi_returnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panel_navigasiBarangLayout = new javax.swing.GroupLayout(panel_navigasiBarang);
        panel_navigasiBarang.setLayout(panel_navigasiBarangLayout);
        panel_navigasiBarangLayout.setHorizontalGroup(
            panel_navigasiBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_navigasiBarangLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(label_navigasi_barang)
                .addGap(29, 29, 29)
                .addComponent(label_navigasi_Kategori)
                .addGap(18, 18, 18)
                .addComponent(label_navigasi_supplier)
                .addGap(18, 18, 18)
                .addComponent(label_navigasi_return)
                .addContainerGap(38, Short.MAX_VALUE))
        );
        panel_navigasiBarangLayout.setVerticalGroup(
            panel_navigasiBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_navigasiBarangLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(panel_navigasiBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_navigasi_barang)
                    .addComponent(label_navigasi_Kategori)
                    .addComponent(label_navigasi_supplier)
                    .addComponent(label_navigasi_return))
                .addGap(0, 7, Short.MAX_VALUE))
        );

        conten_manajemen.setBackground(new java.awt.Color(239, 240, 245));
        conten_manajemen.setPreferredSize(new java.awt.Dimension(1200, 358));
        conten_manajemen.setLayout(new java.awt.CardLayout());

        contenBarang.setBackground(new java.awt.Color(239, 240, 245));

        label_totalBarang.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        label_totalBarang.setForeground(new java.awt.Color(90, 90, 90));
        label_totalBarang.setText("Total Barang");

        txt_totalBrg.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        txt_totalBrg.setForeground(new java.awt.Color(90, 90, 90));
        txt_totalBrg.setText("0");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/parfumePurple.png"))); // NOI18N

        javax.swing.GroupLayout panel_totalBarangLayout = new javax.swing.GroupLayout(panel_totalBarang);
        panel_totalBarang.setLayout(panel_totalBarangLayout);
        panel_totalBarangLayout.setHorizontalGroup(
            panel_totalBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_totalBarangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_totalBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_totalBarangLayout.createSequentialGroup()
                        .addComponent(label_totalBarang)
                        .addContainerGap(58, Short.MAX_VALUE))
                    .addGroup(panel_totalBarangLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_totalBrg)
                        .addGap(24, 24, 24))))
        );
        panel_totalBarangLayout.setVerticalGroup(
            panel_totalBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_totalBarangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_totalBarang)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(panel_totalBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_totalBrg)
                    .addComponent(jLabel1))
                .addContainerGap())
        );

        comboBox_showBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBox_showBarangActionPerformed(evt);
            }
        });

        icon_cariBarang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/magnifying-glass.png"))); // NOI18N

        javax.swing.GroupLayout panel_cariBarangLayout = new javax.swing.GroupLayout(panel_cariBarang);
        panel_cariBarang.setLayout(panel_cariBarangLayout);
        panel_cariBarangLayout.setHorizontalGroup(
            panel_cariBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_cariBarangLayout.createSequentialGroup()
                .addComponent(txt_cariBrng, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(icon_cariBarang)
                .addGap(0, 10, Short.MAX_VALUE))
        );
        panel_cariBarangLayout.setVerticalGroup(
            panel_cariBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_cariBrng)
            .addComponent(icon_cariBarang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        txt_cariBrng.setBorder(javax.swing.BorderFactory.createEmptyBorder());

        jScrollPane3.setBackground(new java.awt.Color(239, 240, 245));

        table_barang.setBackground(new java.awt.Color(239, 240, 245));
        table_barang.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        table_barang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table_barang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_barangMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(table_barang);

        btn_TambahBarang.setBackground(new java.awt.Color(111, 59, 160));
        btn_TambahBarang.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        btn_TambahBarang.setForeground(new java.awt.Color(255, 255, 255));
        btn_TambahBarang.setText("Tambah");
        btn_TambahBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_TambahBarangMouseClicked(evt);
            }
        });
        btn_TambahBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TambahBarangActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(51, 45, 45));
        jButton6.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Refresh");
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton6MouseClicked(evt);
            }
        });
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        Barcode.setBackground(new java.awt.Color(51, 45, 45));
        Barcode.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Barcode.setForeground(new java.awt.Color(255, 255, 255));
        Barcode.setText("Barcode");

        javax.swing.GroupLayout contenBarangLayout = new javax.swing.GroupLayout(contenBarang);
        contenBarang.setLayout(contenBarangLayout);
        contenBarangLayout.setHorizontalGroup(
            contenBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenBarangLayout.createSequentialGroup()
                .addComponent(panel_cariBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboBox_showBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 472, Short.MAX_VALUE)
                .addComponent(Barcode, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_TambahBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2))
            .addGroup(contenBarangLayout.createSequentialGroup()
                .addComponent(panel_totalBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jScrollPane3)
        );
        contenBarangLayout.setVerticalGroup(
            contenBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenBarangLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(panel_totalBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(contenBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contenBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, contenBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_TambahBarang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Barcode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(comboBox_showBarang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
                    .addComponent(panel_cariBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE))
        );

        conten_manajemen.add(contenBarang, "card9");

        contenKategori.setBackground(new java.awt.Color(239, 240, 245));

        icon_cariKategori.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/magnifying-glass.png"))); // NOI18N

        javax.swing.GroupLayout panel_cariKategoriLayout = new javax.swing.GroupLayout(panel_cariKategori);
        panel_cariKategori.setLayout(panel_cariKategoriLayout);
        panel_cariKategoriLayout.setHorizontalGroup(
            panel_cariKategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_cariKategoriLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(txt_cariKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(icon_cariKategori)
                .addGap(0, 10, Short.MAX_VALUE))
        );
        panel_cariKategoriLayout.setVerticalGroup(
            panel_cariKategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_cariKategori)
            .addGroup(panel_cariKategoriLayout.createSequentialGroup()
                .addComponent(icon_cariKategori)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        txt_cariKategori.setBorder(javax.swing.BorderFactory.createEmptyBorder());

        btn_TambahBarang1.setBackground(new java.awt.Color(111, 59, 160));
        btn_TambahBarang1.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        btn_TambahBarang1.setForeground(new java.awt.Color(255, 255, 255));
        btn_TambahBarang1.setText("Tambah");
        btn_TambahBarang1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_TambahBarang1MouseClicked(evt);
            }
        });
        btn_TambahBarang1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TambahBarang1ActionPerformed(evt);
            }
        });

        jScrollPane4.setBackground(new java.awt.Color(239, 240, 245));
        jScrollPane4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane4MouseClicked(evt);
            }
        });

        tabel_kategori.setBackground(new java.awt.Color(239, 240, 245));
        tabel_kategori.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        tabel_kategori.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabel_kategori.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_kategoriMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tabel_kategori);

        label_totalKategori.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        label_totalKategori.setForeground(new java.awt.Color(90, 90, 90));
        label_totalKategori.setText("Total Kategori");

        txt_totalKategori.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        txt_totalKategori.setForeground(new java.awt.Color(90, 90, 90));
        txt_totalKategori.setText("0");

        icon_kategori.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/categories.png"))); // NOI18N

        javax.swing.GroupLayout panel_totalKategoriLayout = new javax.swing.GroupLayout(panel_totalKategori);
        panel_totalKategori.setLayout(panel_totalKategoriLayout);
        panel_totalKategoriLayout.setHorizontalGroup(
            panel_totalKategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_totalKategoriLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_totalKategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_totalKategoriLayout.createSequentialGroup()
                        .addComponent(label_totalKategori)
                        .addContainerGap(47, Short.MAX_VALUE))
                    .addGroup(panel_totalKategoriLayout.createSequentialGroup()
                        .addComponent(icon_kategori)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_totalKategori)
                        .addGap(24, 24, 24))))
        );
        panel_totalKategoriLayout.setVerticalGroup(
            panel_totalKategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_totalKategoriLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_totalKategori)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(panel_totalKategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_totalKategori)
                    .addComponent(icon_kategori))
                .addContainerGap())
        );

        javax.swing.GroupLayout contenKategoriLayout = new javax.swing.GroupLayout(contenKategori);
        contenKategori.setLayout(contenKategoriLayout);
        contenKategoriLayout.setHorizontalGroup(
            contenKategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenKategoriLayout.createSequentialGroup()
                .addComponent(panel_cariKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_TambahBarang1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 1253, Short.MAX_VALUE)
            .addGroup(contenKategoriLayout.createSequentialGroup()
                .addComponent(panel_totalKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        contenKategoriLayout.setVerticalGroup(
            contenKategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenKategoriLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(panel_totalKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(contenKategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panel_cariKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_TambahBarang1))
                .addGap(11, 11, 11)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE))
        );

        conten_manajemen.add(contenKategori, "card3");

        contenReturn.setBackground(new java.awt.Color(239, 240, 245));

        btn_tambahReturn.setBackground(new java.awt.Color(111, 59, 160));
        btn_tambahReturn.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        btn_tambahReturn.setForeground(new java.awt.Color(255, 255, 255));
        btn_tambahReturn.setText("Tambah");
        btn_tambahReturn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_tambahReturnMouseClicked(evt);
            }
        });
        btn_tambahReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambahReturnActionPerformed(evt);
            }
        });

        jScrollPane6.setBackground(new java.awt.Color(239, 240, 245));
        jScrollPane6.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N

        table_return.setBackground(new java.awt.Color(239, 240, 245));
        table_return.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        table_return.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table_return.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_returnMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(table_return);

        label_totalReturn.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        label_totalReturn.setForeground(new java.awt.Color(90, 90, 90));
        label_totalReturn.setText("Total Return");

        txt_totalReturn.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        txt_totalReturn.setForeground(new java.awt.Color(90, 90, 90));
        txt_totalReturn.setText("1020");

        icon_return.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/delivery-status.png"))); // NOI18N

        javax.swing.GroupLayout panel_totalReturnLayout = new javax.swing.GroupLayout(panel_totalReturn);
        panel_totalReturn.setLayout(panel_totalReturnLayout);
        panel_totalReturnLayout.setHorizontalGroup(
            panel_totalReturnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_totalReturnLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_totalReturnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_totalReturnLayout.createSequentialGroup()
                        .addComponent(label_totalReturn)
                        .addContainerGap(60, Short.MAX_VALUE))
                    .addGroup(panel_totalReturnLayout.createSequentialGroup()
                        .addComponent(icon_return)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_totalReturn)
                        .addGap(24, 24, 24))))
        );
        panel_totalReturnLayout.setVerticalGroup(
            panel_totalReturnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_totalReturnLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_totalReturn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(panel_totalReturnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_totalReturn)
                    .addComponent(icon_return))
                .addContainerGap())
        );

        txt_cariSupplier1.setBorder(null);

        icon_cariSupplier1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/magnifying-glass.png"))); // NOI18N

        javax.swing.GroupLayout panel_cariReturnLayout = new javax.swing.GroupLayout(panel_cariReturn);
        panel_cariReturn.setLayout(panel_cariReturnLayout);
        panel_cariReturnLayout.setHorizontalGroup(
            panel_cariReturnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_cariReturnLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(txt_cariSupplier1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(icon_cariSupplier1)
                .addGap(0, 10, Short.MAX_VALUE))
        );
        panel_cariReturnLayout.setVerticalGroup(
            panel_cariReturnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_cariReturnLayout.createSequentialGroup()
                .addGroup(panel_cariReturnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txt_cariSupplier1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(icon_cariSupplier1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        txt_cariSupplier.setBorder(javax.swing.BorderFactory.createEmptyBorder());

        javax.swing.GroupLayout contenReturnLayout = new javax.swing.GroupLayout(contenReturn);
        contenReturn.setLayout(contenReturnLayout);
        contenReturnLayout.setHorizontalGroup(
            contenReturnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenReturnLayout.createSequentialGroup()
                .addComponent(panel_totalReturn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1010, 1010, 1010))
            .addGroup(contenReturnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 1253, Short.MAX_VALUE)
                .addGroup(contenReturnLayout.createSequentialGroup()
                    .addComponent(panel_cariReturn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_tambahReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        contenReturnLayout.setVerticalGroup(
            contenReturnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenReturnLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(panel_totalReturn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(contenReturnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panel_cariReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_tambahReturn))
                .addGap(11, 11, 11)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        conten_manajemen.add(contenReturn, "card4");

        contenSupplier.setBackground(new java.awt.Color(239, 240, 245));

        txt_cariSupplier.setBorder(null);

        icon_cariSupplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/magnifying-glass.png"))); // NOI18N

        javax.swing.GroupLayout panel_cariSupplierLayout = new javax.swing.GroupLayout(panel_cariSupplier);
        panel_cariSupplier.setLayout(panel_cariSupplierLayout);
        panel_cariSupplierLayout.setHorizontalGroup(
            panel_cariSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_cariSupplierLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(txt_cariSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(icon_cariSupplier)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panel_cariSupplierLayout.setVerticalGroup(
            panel_cariSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_cariSupplierLayout.createSequentialGroup()
                .addGroup(panel_cariSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txt_cariSupplier, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(icon_cariSupplier, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        txt_cariSupplier.setBorder(javax.swing.BorderFactory.createEmptyBorder());

        label_totalBarang4.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        label_totalBarang4.setForeground(new java.awt.Color(90, 90, 90));
        label_totalBarang4.setText("Total Supplier");

        txt_totalSupplier.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        txt_totalSupplier.setForeground(new java.awt.Color(90, 90, 90));
        txt_totalSupplier.setText("0");

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/agreement.png"))); // NOI18N

        javax.swing.GroupLayout panel_totalSupplierLayout = new javax.swing.GroupLayout(panel_totalSupplier);
        panel_totalSupplier.setLayout(panel_totalSupplierLayout);
        panel_totalSupplierLayout.setHorizontalGroup(
            panel_totalSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_totalSupplierLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_totalSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_totalSupplierLayout.createSequentialGroup()
                        .addComponent(label_totalBarang4)
                        .addContainerGap(50, Short.MAX_VALUE))
                    .addGroup(panel_totalSupplierLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_totalSupplier)
                        .addGap(24, 24, 24))))
        );
        panel_totalSupplierLayout.setVerticalGroup(
            panel_totalSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_totalSupplierLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_totalBarang4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(panel_totalSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_totalSupplier)
                    .addComponent(jLabel7))
                .addContainerGap())
        );

        jScrollPane5.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N

        table_supplier.setBackground(new java.awt.Color(239, 240, 245));
        table_supplier.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        table_supplier.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table_supplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_supplierMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(table_supplier);

        btn_tambahSupplier.setBackground(new java.awt.Color(111, 59, 160));
        btn_tambahSupplier.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        btn_tambahSupplier.setForeground(new java.awt.Color(255, 255, 255));
        btn_tambahSupplier.setText("Tambah");
        btn_tambahSupplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_tambahSupplierMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout contenSupplierLayout = new javax.swing.GroupLayout(contenSupplier);
        contenSupplier.setLayout(contenSupplierLayout);
        contenSupplierLayout.setHorizontalGroup(
            contenSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 1253, Short.MAX_VALUE)
            .addGroup(contenSupplierLayout.createSequentialGroup()
                .addComponent(panel_cariSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_tambahSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(contenSupplierLayout.createSequentialGroup()
                .addComponent(panel_totalSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        contenSupplierLayout.setVerticalGroup(
            contenSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenSupplierLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(panel_totalSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(contenSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel_cariSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_tambahSupplier, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE))
        );

        conten_manajemen.add(contenSupplier, "card4");

        jLabel12.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(90, 90, 90));
        jLabel12.setText("Klik Pada Tabel Untuk Mengedit ");

        javax.swing.GroupLayout panel_infoLayout = new javax.swing.GroupLayout(panel_info);
        panel_info.setLayout(panel_infoLayout);
        panel_infoLayout.setHorizontalGroup(
            panel_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_infoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel_infoLayout.setVerticalGroup(
            panel_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_infoLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout panel_contenBarangLayout = new javax.swing.GroupLayout(panel_contenBarang);
        panel_contenBarang.setLayout(panel_contenBarangLayout);
        panel_contenBarangLayout.setHorizontalGroup(
            panel_contenBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_contenBarangLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(panel_contenBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel_info, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(conten_manajemen, javax.swing.GroupLayout.DEFAULT_SIZE, 1253, Short.MAX_VALUE)
                    .addComponent(panel_navigasiBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        panel_contenBarangLayout.setVerticalGroup(
            panel_contenBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_contenBarangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel_navigasiBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(conten_manajemen, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_info, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(32, 32, 32))
        );

        ConntainerPanel.add(panel_contenBarang, "card8");

        panel_contenKasir.setBackground(new java.awt.Color(239, 240, 245));
        panel_contenKasir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                panel_contenKasirKeyPressed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(90, 90, 90));
        jLabel22.setText("Cari Barang");

        txt_cariDataOrder.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        txt_cariDataOrder.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_cariDataOrderKeyPressed(evt);
            }
        });

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/magnifying-glass.png"))); // NOI18N
        jLabel23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel23MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panel_cariKasirLayout = new javax.swing.GroupLayout(panel_cariKasir);
        panel_cariKasir.setLayout(panel_cariKasirLayout);
        panel_cariKasirLayout.setHorizontalGroup(
            panel_cariKasirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_cariKasirLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(panel_cariKasirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_cariKasirLayout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addContainerGap(362, Short.MAX_VALUE))
                    .addGroup(panel_cariKasirLayout.createSequentialGroup()
                        .addComponent(txt_cariDataOrder)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel23)
                        .addGap(28, 28, 28))))
        );
        panel_cariKasirLayout.setVerticalGroup(
            panel_cariKasirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_cariKasirLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel22)
                .addGap(28, 28, 28)
                .addGroup(panel_cariKasirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addComponent(txt_cariDataOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(65, Short.MAX_VALUE))
        );

        panel_hasilCari.setBackground(new java.awt.Color(255, 255, 255));

        jLabel24.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(90, 90, 90));
        jLabel24.setText("Hasil Pencarian");

        jScrollPane9.setBackground(new java.awt.Color(239, 240, 245));

        table_cariBelanja.setBackground(new java.awt.Color(239, 240, 245));
        table_cariBelanja.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Kode Barang", "Nama Barang", "Stok", "Harga Jual"
            }
        ));
        table_cariBelanja.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_cariBelanjaMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(table_cariBelanja);

        javax.swing.GroupLayout panel_hasilCariLayout = new javax.swing.GroupLayout(panel_hasilCari);
        panel_hasilCari.setLayout(panel_hasilCariLayout);
        panel_hasilCariLayout.setHorizontalGroup(
            panel_hasilCariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_hasilCariLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panel_hasilCariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_hasilCariLayout.createSequentialGroup()
                        .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                        .addGap(518, 518, 518))
                    .addComponent(jScrollPane9))
                .addGap(20, 20, 20))
        );
        panel_hasilCariLayout.setVerticalGroup(
            panel_hasilCariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_hasilCariLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel24)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jLabel25.setText("Klik Table lalu enter    = BAYAR");

        jLabel26.setText("Klik Item lalu F5          =  HAPUS ITEM");

        btn_Bayar.setBackground(new java.awt.Color(111, 59, 160));
        btn_Bayar.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        btn_Bayar.setForeground(new java.awt.Color(255, 255, 255));
        btn_Bayar.setText("BAYAR");
        btn_Bayar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_BayarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panel_infoHargaLayout = new javax.swing.GroupLayout(panel_infoHarga);
        panel_infoHarga.setLayout(panel_infoHargaLayout);
        panel_infoHargaLayout.setHorizontalGroup(
            panel_infoHargaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_infoHargaLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(panel_infoHargaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 806, Short.MAX_VALUE)
                .addComponent(btn_Bayar, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        panel_infoHargaLayout.setVerticalGroup(
            panel_infoHargaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_infoHargaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_infoHargaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_infoHargaLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(9, 9, 9))
                    .addComponent(btn_Bayar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jScrollPane7.setBackground(new java.awt.Color(239, 240, 245));

        table_belanja.setBackground(new java.awt.Color(239, 240, 245));
        table_belanja.setModel(Order.tbOrder);
        table_belanja.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_belanjaMouseClicked(evt);
            }
        });
        table_belanja.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                table_belanjaKeyPressed(evt);
            }
        });
        jScrollPane7.setViewportView(table_belanja);

        btn_resetKeranjang.setBackground(new java.awt.Color(111, 59, 160));
        btn_resetKeranjang.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        btn_resetKeranjang.setForeground(new java.awt.Color(255, 255, 255));
        btn_resetKeranjang.setText("Reset Keranjang");
        btn_resetKeranjang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_resetKeranjangMouseClicked(evt);
            }
        });
        btn_resetKeranjang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resetKeranjangActionPerformed(evt);
            }
        });

        jButton3.setText("Return Customer");

        javax.swing.GroupLayout panel_contenKasirLayout = new javax.swing.GroupLayout(panel_contenKasir);
        panel_contenKasir.setLayout(panel_contenKasirLayout);
        panel_contenKasirLayout.setHorizontalGroup(
            panel_contenKasirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_contenKasirLayout.createSequentialGroup()
                .addGroup(panel_contenKasirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panel_contenKasirLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_resetKeranjang, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_contenKasirLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(panel_contenKasirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane7)
                            .addComponent(panel_infoHarga, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panel_contenKasirLayout.createSequentialGroup()
                                .addComponent(panel_cariKasir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(panel_hasilCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        panel_contenKasirLayout.setVerticalGroup(
            panel_contenKasirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_contenKasirLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(panel_contenKasirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel_cariKasir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel_hasilCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel_contenKasirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_resetKeranjang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panel_infoHarga, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(50, 50, 50))
        );

        ConntainerPanel.add(panel_contenKasir, "card9");

        panel_contenSetting.setBackground(new java.awt.Color(239, 240, 245));

        jPanel2.setBackground(new java.awt.Color(247, 246, 242));

        label_setToko.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        label_setToko.setForeground(new java.awt.Color(90, 90, 90));
        label_setToko.setText("Toko");
        label_setToko.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_setTokoMouseClicked(evt);
            }
        });

        label_setProfile.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        label_setProfile.setForeground(new java.awt.Color(90, 90, 90));
        label_setProfile.setText("Profile");
        label_setProfile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_setProfileMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(label_setProfile)
                    .addComponent(label_setToko))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_setToko)
                .addGap(41, 41, 41)
                .addComponent(label_setProfile)
                .addContainerGap(598, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panel_contenSettingLayout = new javax.swing.GroupLayout(panel_contenSetting);
        panel_contenSetting.setLayout(panel_contenSettingLayout);
        panel_contenSettingLayout.setHorizontalGroup(
            panel_contenSettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_contenSettingLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1159, Short.MAX_VALUE))
        );
        panel_contenSettingLayout.setVerticalGroup(
            panel_contenSettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_contenSettingLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ConntainerPanel.add(panel_contenSetting, "card10");

        panel_contenManageUser.setBackground(new java.awt.Color(239, 240, 245));

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(90, 90, 90));
        jLabel6.setText("Total User");

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/managerPurple.png"))); // NOI18N
        jLabel8.setToolTipText("");

        jLabel9.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(90, 90, 90));
        jLabel9.setText("1024");

        javax.swing.GroupLayout panel_totalUserLayout = new javax.swing.GroupLayout(panel_totalUser);
        panel_totalUser.setLayout(panel_totalUserLayout);
        panel_totalUserLayout.setHorizontalGroup(
            panel_totalUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_totalUserLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_totalUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_totalUserLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panel_totalUserLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                        .addComponent(jLabel9)
                        .addGap(42, 42, 42))))
        );
        panel_totalUserLayout.setVerticalGroup(
            panel_totalUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_totalUserLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(panel_totalUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8))
                .addContainerGap())
        );

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/magnifying-glass.png"))); // NOI18N

        javax.swing.GroupLayout panel_TxtFieldLayout = new javax.swing.GroupLayout(panel_TxtField);
        panel_TxtField.setLayout(panel_TxtFieldLayout);
        panel_TxtFieldLayout.setHorizontalGroup(
            panel_TxtFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_TxtFieldLayout.createSequentialGroup()
                .addComponent(TXT_cariUser, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel10)
                .addGap(0, 0, 0))
        );
        panel_TxtFieldLayout.setVerticalGroup(
            panel_TxtFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_TxtFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(TXT_cariUser, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addComponent(jLabel10))
        );

        TXT_cariUser.setBorder(javax.swing.BorderFactory.createEmptyBorder());

        table_user.setBackground(new java.awt.Color(239, 240, 245));
        table_user.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_userMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(table_user);

        jButton1.setBackground(new java.awt.Color(111, 59, 160));
        jButton1.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Tambah");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aktif","Tidak Aktif"}));

        javax.swing.GroupLayout panel_contenManageUserLayout = new javax.swing.GroupLayout(panel_contenManageUser);
        panel_contenManageUser.setLayout(panel_contenManageUserLayout);
        panel_contenManageUserLayout.setHorizontalGroup(
            panel_contenManageUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_contenManageUserLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(panel_contenManageUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 1253, Short.MAX_VALUE)
                    .addGroup(panel_contenManageUserLayout.createSequentialGroup()
                        .addComponent(panel_totalUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panel_contenManageUserLayout.createSequentialGroup()
                        .addComponent(panel_TxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel_contenManageUserLayout.setVerticalGroup(
            panel_contenManageUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_contenManageUserLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(panel_totalUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panel_contenManageUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBox1)
                    .addComponent(panel_TxtField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE)
                .addGap(29, 29, 29))
        );

        ConntainerPanel.add(panel_contenManageUser, "card11");

        panel_contenLaporan.setBackground(new java.awt.Color(239, 240, 245));
        panel_contenLaporan.setPreferredSize(new java.awt.Dimension(1281, 663));

        panel_navigasiLaporan.setPreferredSize(new java.awt.Dimension(470, 100));

        label_laporan_penjualan.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        label_laporan_penjualan.setText("Laporan Penjualan");
        label_laporan_penjualan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_laporan_penjualanMouseClicked(evt);
            }
        });

        label_laporanPemebelian.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        label_laporanPemebelian.setText("Laporan Pembelian");
        label_laporanPemebelian.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_laporanPemebelianMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                label_laporanPemebelianMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout panel_navigasiLaporanLayout = new javax.swing.GroupLayout(panel_navigasiLaporan);
        panel_navigasiLaporan.setLayout(panel_navigasiLaporanLayout);
        panel_navigasiLaporanLayout.setHorizontalGroup(
            panel_navigasiLaporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_navigasiLaporanLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(label_laporan_penjualan)
                .addGap(18, 18, 18)
                .addComponent(label_laporanPemebelian)
                .addGap(10, 10, 10))
        );
        panel_navigasiLaporanLayout.setVerticalGroup(
            panel_navigasiLaporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_navigasiLaporanLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(panel_navigasiLaporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_laporan_penjualan)
                    .addComponent(label_laporanPemebelian))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panel_containerLaporan.setBackground(new java.awt.Color(255, 102, 204));
        panel_containerLaporan.setLayout(new java.awt.CardLayout());

        table_laporanPenjualan.setBackground(new java.awt.Color(239, 240, 245));
        table_laporanPenjualan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "No", "Id Transaksi", "Nama Kasir", "Tanggal Transaksi", "Grand Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_laporanPenjualan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_laporanPenjualanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_laporanPenjualan);

        show_laporanPenjualan.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        show_laporanPenjualan.setForeground(new java.awt.Color(90, 90, 90));
        show_laporanPenjualan.setText("Show");

        combo_boxPenjualan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btn_exportPenjualan.setBackground(new java.awt.Color(111, 59, 160));
        btn_exportPenjualan.setForeground(new java.awt.Color(255, 255, 255));
        btn_exportPenjualan.setText("Export");
        btn_exportPenjualan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exportPenjualanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout container_laporanPenjualanLayout = new javax.swing.GroupLayout(container_laporanPenjualan);
        container_laporanPenjualan.setLayout(container_laporanPenjualanLayout);
        container_laporanPenjualanLayout.setHorizontalGroup(
            container_laporanPenjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1253, Short.MAX_VALUE)
            .addGroup(container_laporanPenjualanLayout.createSequentialGroup()
                .addComponent(show_laporanPenjualan)
                .addGap(18, 18, 18)
                .addComponent(combo_boxPenjualan, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_exportPenjualan, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        container_laporanPenjualanLayout.setVerticalGroup(
            container_laporanPenjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, container_laporanPenjualanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(container_laporanPenjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(show_laporanPenjualan)
                    .addComponent(combo_boxPenjualan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_exportPenjualan, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 567, Short.MAX_VALUE))
        );

        panel_containerLaporan.add(container_laporanPenjualan, "card2");

        table_laporanPembelian.setBackground(new java.awt.Color(239, 240, 245));
        table_laporanPembelian.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        table_laporanPembelian.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "No", "Id Transaksi", "Supplier", "Tangal Beli Product", "Total Belanja", "Status Barang"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_laporanPembelian.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_laporanPembelianMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table_laporanPembelian);

        show_laporanPembelian.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        show_laporanPembelian.setForeground(new java.awt.Color(90, 90, 90));
        show_laporanPembelian.setText("Show");

        combo_boxPembelian.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btn_exportPembelian.setBackground(new java.awt.Color(111, 59, 160));
        btn_exportPembelian.setForeground(new java.awt.Color(255, 255, 255));
        btn_exportPembelian.setText("Export");

        javax.swing.GroupLayout container_laporanPembelianLayout = new javax.swing.GroupLayout(container_laporanPembelian);
        container_laporanPembelian.setLayout(container_laporanPembelianLayout);
        container_laporanPembelianLayout.setHorizontalGroup(
            container_laporanPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1253, Short.MAX_VALUE)
            .addGroup(container_laporanPembelianLayout.createSequentialGroup()
                .addComponent(show_laporanPembelian)
                .addGap(18, 18, 18)
                .addComponent(combo_boxPembelian, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_exportPembelian, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        container_laporanPembelianLayout.setVerticalGroup(
            container_laporanPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, container_laporanPembelianLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(container_laporanPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(show_laporanPembelian)
                    .addComponent(combo_boxPembelian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_exportPembelian, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 567, Short.MAX_VALUE))
        );

        panel_containerLaporan.add(container_laporanPembelian, "card3");

        javax.swing.GroupLayout panel_contenLaporanLayout = new javax.swing.GroupLayout(panel_contenLaporan);
        panel_contenLaporan.setLayout(panel_contenLaporanLayout);
        panel_contenLaporanLayout.setHorizontalGroup(
            panel_contenLaporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_contenLaporanLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(panel_contenLaporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel_containerLaporan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel_navigasiLaporan, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel_contenLaporanLayout.setVerticalGroup(
            panel_contenLaporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_contenLaporanLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(panel_navigasiLaporan, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_containerLaporan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        ConntainerPanel.add(panel_contenLaporan, "card12");

        panel_contenDashbord.setBackground(new java.awt.Color(239, 240, 245));

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(90, 90, 90));
        jLabel2.setText("Penghasilan Sebulan");

        icon_pengSebulan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/clipboard.png"))); // NOI18N

        jLabel4.setText("Rp . 1004");

        javax.swing.GroupLayout icon_penghasilanSebulanLayout = new javax.swing.GroupLayout(icon_penghasilanSebulan);
        icon_penghasilanSebulan.setLayout(icon_penghasilanSebulanLayout);
        icon_penghasilanSebulanLayout.setHorizontalGroup(
            icon_penghasilanSebulanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(icon_penghasilanSebulanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(icon_penghasilanSebulanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addGroup(icon_penghasilanSebulanLayout.createSequentialGroup()
                        .addComponent(icon_pengSebulan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        icon_penghasilanSebulanLayout.setVerticalGroup(
            icon_penghasilanSebulanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(icon_penghasilanSebulanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(icon_penghasilanSebulanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(icon_pengSebulan)
                    .addComponent(jLabel4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel19.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(90, 90, 90));
        jLabel19.setText("Total Barang Return");

        icon_totalReturn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/returns.png"))); // NOI18N

        jLabel11.setText("10000");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addContainerGap(31, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(icon_totalReturn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11)
                        .addGap(43, 43, 43))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(icon_totalReturn)
                    .addComponent(jLabel11))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        panel_chart = new RoundedPanel(8, new Color(255, 255, 255));
        panel_chart.setBackground(new java.awt.Color(239, 240, 245));
        panel_chart.setLayout(new java.awt.CardLayout());

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "No", "Kode Product", "Nama Product"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane10.setViewportView(jTable4);

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(90, 90, 90));
        jLabel3.setText("Barang Paling Banyak diminati");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
                .addGap(41, 41, 41))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE))
        );

        total_PenjSebulan.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        total_PenjSebulan.setForeground(new java.awt.Color(90, 90, 90));
        total_PenjSebulan.setText("Penjualan Sebulan");

        icon_penjualanSebulan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/clipboard pb.png"))); // NOI18N

        jLabel5.setText("10000");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(total_PenjSebulan)
                        .addContainerGap(42, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(icon_penjualanSebulan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addGap(52, 52, 52))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(total_PenjSebulan)
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(icon_penjualanSebulan)
                    .addComponent(jLabel5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panel_contenDashbordLayout = new javax.swing.GroupLayout(panel_contenDashbord);
        panel_contenDashbord.setLayout(panel_contenDashbordLayout);
        panel_contenDashbordLayout.setHorizontalGroup(
            panel_contenDashbordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_contenDashbordLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(panel_contenDashbordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_contenDashbordLayout.createSequentialGroup()
                        .addComponent(icon_penghasilanSebulan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(panel_chart, javax.swing.GroupLayout.DEFAULT_SIZE, 806, Short.MAX_VALUE))
                .addGap(43, 43, 43)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(36, Short.MAX_VALUE))
        );
        panel_contenDashbordLayout.setVerticalGroup(
            panel_contenDashbordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_contenDashbordLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(panel_contenDashbordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(icon_penghasilanSebulan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(32, 32, 32)
                .addGroup(panel_contenDashbordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel_chart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );

        ConntainerPanel.add(panel_contenDashbord, "card13");

        header_panel.setPreferredSize(new java.awt.Dimension(1500, 86));

        label_page.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        label_page.setForeground(new java.awt.Color(255, 255, 255));
        label_page.setText("Dashbord");

        label_namatoko.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        label_namatoko.setForeground(new java.awt.Color(255, 255, 255));
        label_namatoko.setText("BANAJ MOSLEM FRAGRANCE");

        icon_user.setText("Icon");

        label_tanggal.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        label_tanggal.setForeground(new java.awt.Color(255, 255, 255));
        label_tanggal.setText("20-Agustus-2020");

        javax.swing.GroupLayout header_panelLayout = new javax.swing.GroupLayout(header_panel);
        header_panel.setLayout(header_panelLayout);
        header_panelLayout.setHorizontalGroup(
            header_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, header_panelLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(header_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(header_panelLayout.createSequentialGroup()
                        .addComponent(label_page)
                        .addGap(667, 667, 667)
                        .addComponent(label_idPegawai)
                        .addGap(132, 132, 132)
                        .addComponent(label_role)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(icon_user, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(label_namaPegawai, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(header_panelLayout.createSequentialGroup()
                        .addComponent(label_namatoko)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(label_tanggal)))
                .addContainerGap())
        );
        header_panelLayout.setVerticalGroup(
            header_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(header_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_page)
                .addGap(10, 10, 10)
                .addComponent(label_namatoko)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, header_panelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(header_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(icon_user, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(label_namaPegawai, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(header_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(label_role)
                        .addComponent(label_idPegawai)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label_tanggal)
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(navigasi_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(frame_logo_toko, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ConntainerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(header_panel, javax.swing.GroupLayout.DEFAULT_SIZE, 1281, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(header_panel, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(ConntainerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(frame_logo_toko, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(navigasi_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void icon_dashbordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icon_dashbordMouseClicked
        // TODO add your handling code here:
        
        ConntainerPanel.removeAll();
        ConntainerPanel.add(panel_contenDashbord);
        ConntainerPanel.repaint();
        ConntainerPanel.revalidate();
        
        //visibilitas
        panel_iconProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/parfume.png")));
        icon_kasir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/cart (1).png")));
        icon_dashbord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/airplayPurple.png")));
        panel_iconSetting.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/settingWhite.png")));
        panel_iconLaporan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/pulse (1).png")));
        panel_iconManager.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/managerWhite.png")));
        
        //set Label Page
        label_page.setText("Dashbord");
        showChart();
        OrderService order = new OrderService();
        order.resetKeranjang();
        
        
        
    }//GEN-LAST:event_icon_dashbordMouseClicked

    private void panel_iconProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_iconProductMouseClicked
          // TODO add your handling code here:
        ConntainerPanel.removeAll();
        ConntainerPanel.add(panel_contenBarang);
        ConntainerPanel.repaint();
        ConntainerPanel.revalidate();
        conten_manajemen.removeAll();
        conten_manajemen.add(contenBarang);
        conten_manajemen.repaint();
        conten_manajemen.revalidate();
        
        
        //visibilitas icon
        panel_iconProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/parfumePurple.png")));
        icon_kasir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/cart (1).png")));
        icon_dashbord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/airplay (1).png")));
        panel_iconSetting.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/settingWhite.png")));
        panel_iconLaporan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/pulse (1).png")));
        panel_iconManager.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/managerWhite.png")));
        //visibilitas label navigasi
        label_navigasi_barang.setForeground(new Color(111, 59, 160));
        label_navigasi_Kategori.setForeground(new Color(90, 90, 90));
        label_navigasi_supplier.setForeground(new Color(90, 90, 90));
        label_navigasi_return.setForeground(new Color(90, 90, 90));
        
        //set Text labelPage
        label_page.setText("Manajemen Product");
        barangService br = new barangService();
        kategoriService kate = new kategoriService();
        supplierService sup = new supplierService();
        kate.showKategori(tabel_kategori);
        sup.showSupplier(table_supplier);
       
        br.showBarang(table_barang);
        br.deleteBarangWhenStokHabis();
        OrderService order = new OrderService();
        order.resetKeranjang();
        
        
        
       
//        
//      
        
    }//GEN-LAST:event_panel_iconProductMouseClicked

    private void panel_iconManagerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_iconManagerMouseClicked
         // TODO add your handling code here:
        ConntainerPanel.removeAll();
        ConntainerPanel.add(panel_contenManageUser);
        ConntainerPanel.repaint();
        ConntainerPanel.revalidate();
        //visibilitas icon
        icon_kasir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/cart (1).png")));
        icon_dashbord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/airplay (1).png")));
        panel_iconLaporan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/pulse (1).png")));
        panel_iconManager.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/managerPurple.png")));
        panel_iconSetting.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/settingWhite.png")));
        panel_iconProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/parfume.png")));
        
          
        //set Text labelPage
        label_page.setText("User Management");
        UserService user = new UserService();
        user.showUser(table_user);
        OrderService order = new OrderService();
        order.resetKeranjang();
        
    }//GEN-LAST:event_panel_iconManagerMouseClicked

    private void panel_iconLaporanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_iconLaporanMouseClicked
         // TODO add your handling code here:
        ConntainerPanel.removeAll();
        ConntainerPanel.add(panel_contenLaporan);
        ConntainerPanel.repaint();
        ConntainerPanel.revalidate();
        
        //visibilitas icon
        icon_kasir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/cart (1).png")));
        icon_dashbord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/airplay (1).png")));
        panel_iconLaporan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/pulsePurple.png")));
        panel_iconManager.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/managerWhite.png")));
        panel_iconSetting.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/settingWhite.png")));
        panel_iconProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/parfume.png")));
        
          
        //set Text labelPage
        label_page.setText("Laporan Transaksi");
        label_laporan_penjualan.setForeground(new Color(111, 59, 160));
        label_laporanPemebelian.setForeground(new Color(90, 90, 90));
        //
        panel_containerLaporan.removeAll();
        panel_containerLaporan.add(container_laporanPenjualan);
        panel_containerLaporan.repaint();
        panel_containerLaporan.revalidate();
        
        OrderService order = new OrderService();
        order.resetKeranjang();
        
    }//GEN-LAST:event_panel_iconLaporanMouseClicked

    private void icon_kasirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icon_kasirMouseClicked
         // TODO add your handling code here:
       
        
        ConntainerPanel.removeAll();
        ConntainerPanel.add(panel_contenKasir);
        ConntainerPanel.repaint();
        ConntainerPanel.revalidate();
       
        
        
        
        //visibilitas icon
        icon_kasir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/cartPurple.png")));
        icon_dashbord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/airplay (1).png")));
        panel_iconLaporan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/pulse (1).png")));
        panel_iconManager.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/managerWhite.png")));
        panel_iconSetting.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/settingWhite.png")));
        panel_iconProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/parfume.png")));
        
        //set label Page
        label_page.setText("Kasir");
        
        
        //
       
        
        
    }//GEN-LAST:event_icon_kasirMouseClicked

    private void panel_iconSettingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_iconSettingMouseClicked
  
         // TODO add your handling code here:\
        
        ConntainerPanel.removeAll();
        ConntainerPanel.add(panel_contenSetting);
        ConntainerPanel.repaint();
        ConntainerPanel.revalidate();
        
       
         panel_iconProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/parfume.png")));
        icon_kasir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/cart (1).png")));
        icon_dashbord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/airplay (1).png")));
        panel_iconSetting.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/settingsPurple.png")));
        panel_iconLaporan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/pulse (1).png")));
        panel_iconManager.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/managerWhite.png")));

           
        //set Text labelPage
        label_page.setText("Setting's");
//        MainConten.removeAll();
//        MainConten.add(contenToko);
//        MainConten.repaint(); 
//        MainConten.revalidate();
        
          label_setToko.setForeground(new Color(111, 59, 160));
         label_setProfile.setForeground(new Color(90, 90, 90));
        
         
        OrderService order = new OrderService();
        order.resetKeranjang();
        

    }//GEN-LAST:event_panel_iconSettingMouseClicked

    private void panel_managerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_managerMouseClicked
        // TODO add your handling code here:
        
        ConntainerPanel.removeAll();
        ConntainerPanel.add(panel_contenManageUser);
        ConntainerPanel.repaint();
        ConntainerPanel.revalidate();
        
        
        
        icon_kasir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/cart (1).png")));
        icon_dashbord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/airplay (1).png")));
        panel_iconLaporan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/pulse (1).png")));
        panel_iconManager.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/managerPurple.png")));
        panel_iconSetting.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/settingWhite.png")));
        panel_iconProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/parfume.png")));
        
    }//GEN-LAST:event_panel_managerMouseClicked

    private void panel_dashbordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_dashbordMouseClicked
        // TODO add your handling code here:
        
        ConntainerPanel.removeAll();
        ConntainerPanel.add(panel_contenDashbord);
        ConntainerPanel.repaint();
        ConntainerPanel.revalidate();
        
        panel_iconProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/parfume.png")));
        icon_kasir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/cart (1).png")));
        icon_dashbord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/airplayPurple.png")));
        panel_iconSetting.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/settingWhite.png")));
        panel_iconLaporan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/pulse (1).png")));
        panel_iconManager.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/managerWhite.png")));
    }//GEN-LAST:event_panel_dashbordMouseClicked

    private void panel_kasirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_kasirMouseClicked
        // TODO add your handling code here:
        ConntainerPanel.removeAll();
        ConntainerPanel.add(panel_contenKasir);
        ConntainerPanel.repaint();
        ConntainerPanel.revalidate();
        
        icon_kasir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/cartPurple.png")));
        icon_dashbord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/airplay (1).png")));
        panel_iconLaporan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/pulse (1).png")));
        panel_iconManager.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/managerWhite.png")));
        panel_iconSetting.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/settingWhite.png")));
        panel_iconProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/parfume.png")));
        
    }//GEN-LAST:event_panel_kasirMouseClicked

    private void panel_productMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_productMouseClicked
        // TODO add your handling code here:
        ConntainerPanel.removeAll();
        ConntainerPanel.add(panel_contenBarang);
        ConntainerPanel.repaint();
        ConntainerPanel.revalidate();
         //visibilitas icon
        panel_iconProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/parfumePurple.png")));
        icon_kasir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/cart (1).png")));
        icon_dashbord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/airplay (1).png")));
        panel_iconSetting.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/settingWhite.png")));
        panel_iconLaporan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/pulse (1).png")));
        panel_iconManager.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/managerWhite.png")));
    }//GEN-LAST:event_panel_productMouseClicked

    private void panel_laporanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_laporanMouseClicked
        // TODO add your handling code here:   
          ConntainerPanel.removeAll();
        ConntainerPanel.add(panel_contenLaporan);
        ConntainerPanel.repaint();
        ConntainerPanel.revalidate();
        
          icon_kasir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/cart (1).png")));
        icon_dashbord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/airplay (1).png")));
        panel_iconLaporan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/pulsePurple.png")));
        panel_iconManager.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/managerWhite.png")));
        panel_iconSetting.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/settingWhite.png")));
        panel_iconProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/parfume.png")));
        
        
        
    }//GEN-LAST:event_panel_laporanMouseClicked

    private void panel_settingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_settingMouseClicked
        // TODO add your handling code here:
        
        ConntainerPanel.removeAll();
        ConntainerPanel.add(panel_contenSetting);
        ConntainerPanel.repaint();
        ConntainerPanel.revalidate();
        
        panel_iconProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/parfume.png")));
        icon_kasir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/cart (1).png")));
        icon_dashbord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/airplay (1).png")));
        panel_iconSetting.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/settingsPurple.png")));
        panel_iconLaporan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/pulse (1).png")));
        panel_iconManager.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/managerWhite.png")));
    }//GEN-LAST:event_panel_settingMouseClicked

    private void panel_iconManagerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_iconManagerMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_panel_iconManagerMouseEntered

    private void label_navigasi_barangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_navigasi_barangMouseClicked
          // TODO add your handling code here:
          
          label_navigasi_barang.setForeground(new Color(111, 59, 160));
          label_navigasi_Kategori.setForeground(new Color(90, 90, 90));
          label_navigasi_supplier.setForeground(new Color(90, 90, 90));
          label_navigasi_return.setForeground(new Color(90, 90, 90));
          
          conten_manajemen.removeAll();
          conten_manajemen.add(contenBarang);
          conten_manajemen.repaint();
          conten_manajemen.revalidate();
          
          barangService barang = new barangService();
          barang.showBarang(table_barang);
          
          String total = barang.hitungTotal();
          txt_totalBrg.setText(total);
         
         
    }//GEN-LAST:event_label_navigasi_barangMouseClicked

    private void label_navigasi_KategoriMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_navigasi_KategoriMouseClicked
          // TODO add your handling code here:
         //visibiliras label navigasi
          label_navigasi_barang.setForeground(new Color(90, 90, 90));
          label_navigasi_Kategori.setForeground(new Color(111, 59, 160));
          label_navigasi_supplier.setForeground(new Color(90, 90, 90));
          label_navigasi_return.setForeground(new Color(90, 90, 90));
          
          conten_manajemen.removeAll();
          conten_manajemen.add(contenKategori);
          conten_manajemen.repaint();
          conten_manajemen.revalidate();
          
          kategoriService kt = new kategoriService();
          kt.showKategori(tabel_kategori);
    }//GEN-LAST:event_label_navigasi_KategoriMouseClicked

    private void label_navigasi_supplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_navigasi_supplierMouseClicked
         // TODO add your handling code here:
         
          label_navigasi_barang.setForeground(new Color(90, 90, 90));
          label_navigasi_Kategori.setForeground(new Color(90, 90, 90));
          label_navigasi_supplier.setForeground(new Color(111, 59, 160));
          label_navigasi_return.setForeground(new Color(90, 90, 90));
          
          conten_manajemen.removeAll();
          conten_manajemen.add(contenSupplier);
          conten_manajemen.repaint();
          conten_manajemen.revalidate();
          
          supplierService su = new supplierService();
          su.showSupplier(table_supplier);
    }//GEN-LAST:event_label_navigasi_supplierMouseClicked

    private void label_navigasi_returnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_navigasi_returnMouseClicked
          // TODO add your handling code here:
         
          label_navigasi_barang.setForeground(new Color(90, 90, 90));
          label_navigasi_Kategori.setForeground(new Color(90, 90, 90));
          label_navigasi_supplier.setForeground(new Color(90, 90, 90));
          label_navigasi_return.setForeground(new Color(111, 59, 160));
          
          conten_manajemen.removeAll();
          conten_manajemen.add(contenReturn);
          conten_manajemen.repaint();
          conten_manajemen.revalidate();
          
          barangService br = new barangService();
          br.showReturSupplier(table_return);
    }//GEN-LAST:event_label_navigasi_returnMouseClicked

    private void comboBox_showBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBox_showBarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBox_showBarangActionPerformed

    private void btn_TambahBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_TambahBarangMouseClicked
        // TODO add your handling code here:
      DataBarangTambah dt = new DataBarangTambah();
      if(txt_totalKategori.getText().toString().equals("0")||txt_totalSupplier.getText().toString().equals("0")){
            JOptionPane.showMessageDialog(null, "Kategori atau Supplier 0 tidak bisa menambahkan Product", "Terjadi Kesalahan", JOptionPane.INFORMATION_MESSAGE, eroricon);

      }else{
           dt.Action("add");


      }
     
      
      
      
   
    }//GEN-LAST:event_btn_TambahBarangMouseClicked

    private void btn_TambahBarang1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_TambahBarang1MouseClicked
        // TODO add your handling code here:
        
      DataTambahKategori dt = new DataTambahKategori();
      dt.Action("add");
    }//GEN-LAST:event_btn_TambahBarang1MouseClicked

    private void btn_TambahBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TambahBarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_TambahBarangActionPerformed

    private void label_laporan_penjualanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_laporan_penjualanMouseClicked
          // TODO add your handling code here:
          label_laporan_penjualan.setForeground(new Color(111, 59, 160));
          label_laporanPemebelian.setForeground(new Color(90, 90, 90));
          
          panel_containerLaporan.removeAll();
          panel_containerLaporan.add(container_laporanPenjualan);
          panel_containerLaporan.repaint();
          panel_containerLaporan.revalidate();
          
          

    }//GEN-LAST:event_label_laporan_penjualanMouseClicked

    private void label_laporanPemebelianMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_laporanPemebelianMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_label_laporanPemebelianMouseEntered

    private void label_laporanPemebelianMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_laporanPemebelianMouseClicked
          // TODO add your handling code here:
         label_laporanPemebelian.setForeground(new Color(111, 59, 160));
         label_laporan_penjualan.setForeground(new Color(90,90, 90));
         
          panel_containerLaporan.removeAll();
          panel_containerLaporan.add(container_laporanPembelian);
          panel_containerLaporan.repaint();
          panel_containerLaporan.revalidate();
         

    }//GEN-LAST:event_label_laporanPemebelianMouseClicked

    private void btn_TambahBarang1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TambahBarang1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_TambahBarang1ActionPerformed

    private void btn_tambahReturnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_tambahReturnMouseClicked
         // TODO add your handling code here:
        dataTambahReturn dt = new dataTambahReturn();
        dt.Action("add");
      
    }//GEN-LAST:event_btn_tambahReturnMouseClicked

    private void btn_tambahReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahReturnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_tambahReturnActionPerformed

    private void table_supplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_supplierMouseClicked
          // TODO add your handling code here:
        
         DataTambahSupplier suplier = new DataTambahSupplier();
         suplier.Action("edit");
         
         supplierService supService = new supplierService();
         String kode_sup= supService.setKodeSupplierEdit(kode_supplier, table_supplier);
         suplier.tampilkanDataKeForm("edit", kode_sup);
         
         
         
        
     
         
    }//GEN-LAST:event_table_supplierMouseClicked

   
    private void tabel_kategoriMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_kategoriMouseClicked
         // TODO add your handling code here:
        
         System.out.println(kode_kategori);
         DataTambahKategori dt = new DataTambahKategori();
         kategoriService kategori = new kategoriService();
         kode_kategori =kategori.setKodeLamaKategoriEdit(kode_kategori, tabel_kategori);
        
         dt.setKodeKategoriLama(kode_kategori);
         System.out.println(kode_kategori);
         dt.editKategori("edit", kode_kategori);
         dt.Action("edit");
         
    }//GEN-LAST:event_tabel_kategoriMouseClicked

     public String getKodeLama(){
         
        return kode_kategori;
        
    }
     
  
    private void table_returnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_returnMouseClicked
         // TODO add your handling code here:
        dataTambahReturn dt = new dataTambahReturn();
        dt.Action("edit");
    }//GEN-LAST:event_table_returnMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
         // TODO add your handling code here:
         TambahUser dt = new TambahUser();
         dt.Action("add");
         
         UserService user = new UserService();
         TambahUser.TXT_Add_IdUser.setText(user.getId());
    }//GEN-LAST:event_jButton1MouseClicked

    private void table_userMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_userMouseClicked
         // TODO add your handling code here:
         TambahUser dt = new TambahUser();
         
         table_user.getSelectedRow();
         int row = table_user.getSelectedRow();
         String id = table_user.getValueAt(row, 1).toString();
         System.out.println(id);
         TambahUser.label_idLama.setText(id);
         dt.sendDataEdit("edit", TambahUser.label_idLama.getText());
         dt.Action("edit");
    }//GEN-LAST:event_table_userMouseClicked

    private void table_laporanPenjualanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_laporanPenjualanMouseClicked
         // TODO add your handling code here:
         TransaksiPenjualan tr = new TransaksiPenjualan();
         tr.showJf();
         
    }//GEN-LAST:event_table_laporanPenjualanMouseClicked

    private void table_laporanPembelianMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_laporanPembelianMouseClicked
         // TODO add your handling code here:
         TransaksiPembelian tr = new TransaksiPembelian();
         tr.showJf();
    }//GEN-LAST:event_table_laporanPembelianMouseClicked

    private void label_setTokoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_setTokoMouseClicked
          // TODO add your handling code here:
//         MainConten.removeAll();
//         MainConten.add(contenToko);
//         MainConten.repaint();
//         MainConten.revalidate();
//         
//         label_setToko.setForeground(new Color(111, 59, 160));
//         label_setProfile.setForeground(new Color(90, 90, 90));
         
    }//GEN-LAST:event_label_setTokoMouseClicked

    private void label_setProfileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_setProfileMouseClicked
         // TODO add your handling code here:
//         MainConten.removeAll();
//         MainConten.add(contenProfile);
//         MainConten.repaint();
//         MainConten.revalidate();
//         
//         label_setToko.setForeground(new Color(90, 90, 90));
//         label_setProfile.setForeground(new Color(111, 59, 160));
         
    }//GEN-LAST:event_label_setProfileMouseClicked

    private void jButton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseClicked
        // TODO add your handling code here:
        barangService br = new barangService();
        br.showBarang(table_barang);
        br.deleteBarangWhenStokHabis();
    }//GEN-LAST:event_jButton6MouseClicked

    private void btn_BayarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_BayarMouseClicked
          // TODO add your handling code here:
         
         
         KonfirmasiBayar konfirmsai = new KonfirmasiBayar();
         KonfirmasiBayarService bayar = new KonfirmasiBayarService();
         Id id = new Id();
         String nilaiSubTotal = bayar.setSubtotal();
        
         
         KonfirmasiBayar.txt_SubTotal.setText(nilaiSubTotal);
         KonfirmasiBayar.txt_totalHarga.setText(nilaiSubTotal);
        
         
         if(KonfirmasiBayar.txt_SubTotal.getText().equals("0")){
            JOptionPane.showMessageDialog(null, "Mohon Tambahkan Product terlebih dahulu", "Eror", JOptionPane.INFORMATION_MESSAGE,eroricon); 
         }else{
              konfirmsai.Action();
              
              String result = id.IdTransaksi();
              konfirmsai.tx_idTransaksi.setText(result);
              
         }
        
         
        
    }//GEN-LAST:event_btn_BayarMouseClicked

    private void table_barangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_barangMouseClicked
         // TODO add your handling code here:
        DataBarangTambah dt = new DataBarangTambah();
        dt.Action("edit");
        barangService br = new barangService();
        String kode="";
        String kode_lama= br.setKodeLamaBarangEdit(kode, table_barang);
        dt.setKodeLama(kode_lama);
        if(dt.getKodeLama().equals("")){
            JOptionPane.showMessageDialog(null, "Terjadi Kesalahan, Tidak ada product dalam data", "Eror", JOptionPane.OK_OPTION);
            dt.dispose();
        }else{
            dt.editBarang("edit");
        }

    }//GEN-LAST:event_table_barangMouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void btn_exportPenjualanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exportPenjualanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_exportPenjualanActionPerformed

    private void btn_tambahSupplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_tambahSupplierMouseClicked
        // TODO add your handling code here:
        
       DataTambahSupplier supplier = new DataTambahSupplier();
       supplier.Action("add");
    }//GEN-LAST:event_btn_tambahSupplierMouseClicked

    private void jScrollPane4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane4MouseClicked
         // TODO add your handling code here:
         
    }//GEN-LAST:event_jScrollPane4MouseClicked

    private void panel_contenKasirKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_panel_contenKasirKeyPressed
        
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            
        }else if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            KonfirmasiBayar konirmasi = new KonfirmasiBayar();
            konirmasi.setVisible(true);
            System.out.println("key");
        }else if(evt.getKeyCode()==KeyEvent.VK_F5){
            barangService barang = new barangService();
            barang.resetKeranjang();
        }
    }//GEN-LAST:event_panel_contenKasirKeyPressed

    private void jLabel23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseClicked
        // TODO add your handling code here:
        OrderService order = new OrderService();
        order.getBarang(txt_cariDataOrder.getText().toString());
    }//GEN-LAST:event_jLabel23MouseClicked

    private void btn_resetKeranjangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_resetKeranjangMouseClicked
        // TODO add your handling code here:
        OrderService order = new OrderService();
        order.resetKeranjang();
        
       
      
        txt_cariDataOrder.setText("");
        
    }//GEN-LAST:event_btn_resetKeranjangMouseClicked

    private void btn_resetKeranjangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resetKeranjangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_resetKeranjangActionPerformed

    private void txt_cariDataOrderKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cariDataOrderKeyPressed
        // TODO add your handling code here:
        OrderService order = new OrderService();
        if(order.getBarang(txt_cariDataOrder.getText().toString())==true){
            
        }else{
            txt_cariDataOrder.setText("");
        }
       
    }//GEN-LAST:event_txt_cariDataOrderKeyPressed

    private void table_cariBelanjaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_cariBelanjaMouseClicked
        // TODO add your handling code here:
        
        KonfirmasiOrder konfirmasi = new KonfirmasiOrder();
        OrderService order = new OrderService();
        String kodeProduct =order.setKodeLamaBarangEdit("", table_cariBelanja);
        konfirmasi.setKodeLama(kodeProduct);
        konfirmasi.setVisible(true);
        
        String nama_product="";
        System.out.println(nama_product);
        KonfirmasiOrder.txt_namaProductOrder.setText(nama_product);
        System.out.println(nama_product);
        
        konfirmasi.addQty("edit");
        
    }//GEN-LAST:event_table_cariBelanjaMouseClicked

    private void table_belanjaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_belanjaMouseClicked
         // TODO add your handling code here:
         
         
    }//GEN-LAST:event_table_belanjaMouseClicked

    private void table_belanjaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_table_belanjaKeyPressed
         // TODO add your handling code here:
         
         
         if(evt.getKeyCode() ==evt.VK_ENTER){
              KonfirmasiBayar konfirmsai = new KonfirmasiBayar();
         KonfirmasiBayarService bayar = new KonfirmasiBayarService();
         Id id = new Id();
         konfirmsai.txt_SubTotal.setText(bayar.setSubtotal());
         
         if(KonfirmasiBayar.txt_SubTotal.getText().equals("0")){
            JOptionPane.showMessageDialog(null, "Mohon Tambahkan Product terlebih dahulu", "Eror", JOptionPane.INFORMATION_MESSAGE,eroricon); 
         }else{
              konfirmsai.Action();
              
              String result = id.IdTransaksi();
              konfirmsai.tx_idTransaksi.setText(result);
         }
         }
         else if(evt.getKeyCode()==evt.VK_F5){
              if(table_belanja.getSelectedRowCount()==1){
                if(!table_belanja.getValueAt(0, 0).toString().equals("")){
                    if(table_belanja.getRowCount() == 1){
                        System.out.println("--");
                        Order.tbOrder.setRowCount(0);
                        Order.tbOrder.addRow(new Object[]{
                            "","","","","","",""
                        });
                    }else{
                        Order.tbOrder.removeRow(table_belanja.getSelectedRow());
                    }
                }
            }else{
                JOptionPane.showMessageDialog(null, "Harap Pilih Salah Satu Baris !", "Terjadi Kesalahan !", JOptionPane.INFORMATION_MESSAGE);
            }
         }
    }//GEN-LAST:event_table_belanjaKeyPressed

    public void showBarangWhenClick(){
        
        barangService br = new barangService();
        br.showBarang(table_barang);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Dashbord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashbord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashbord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashbord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashbord("").setVisible(true);
            }
        });
    }
    
    class RoundedPanel extends JPanel
    {
        private Color backgroundColor;
        private int cornerRadius = 15;
        public RoundedPanel(LayoutManager layout, int radius) {
            super(layout);
            cornerRadius = radius;
        }
        public RoundedPanel(LayoutManager layout, int radius, Color bgColor) {
            super(layout);
            cornerRadius = radius;
            backgroundColor = bgColor;
        }
        public RoundedPanel(int radius) {
            super();
            cornerRadius = radius;
            
        }
        public RoundedPanel(int radius, Color bgColor) {
            super();
            cornerRadius = radius;
            backgroundColor = bgColor;
        }
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Dimension arcs = new Dimension(cornerRadius, cornerRadius);
            int width = getWidth();
            int height = getHeight();
            Graphics2D graphics = (Graphics2D) g;
            graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            //Draws the rounded panel with borders.
            if (backgroundColor != null) {
                graphics.setColor(backgroundColor);
            } else {
                graphics.setColor(getBackground());
            }
            graphics.fillRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height); //paint background
            graphics.setColor(getForeground());
//            graphics.drawRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height); //paint border
//             
        }
        
        
    }
    public class RoundJTextField extends JTextField {
    private Shape shape;
    public RoundJTextField(int size) {
        super(size);
        setOpaque(false); // As suggested by @AVD in comment.
    }
    protected void paintComponent(Graphics g) {
         g.setColor(getBackground());
         g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
         super.paintComponent(g);
    }
    protected void paintBorder(Graphics g) {
         g.setColor(getForeground());
         g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
    }
    public boolean contains(int x, int y) {
         if (shape == null || !shape.getBounds().equals(getBounds())) {
             shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, 15, 15);
         }
         return shape.contains(x, y);
    }
}
  
    
 public class Barchart extends JPanel{
     
     
     
     
 }
    
 public void showChart(){
    
    DefaultCategoryDataset data = new DefaultCategoryDataset();
    data.setValue(1000, "Total Penghasilan ", "January");
    data.setValue(2000, "Total Penghasilan ", "February");
    data.setValue(3000, "Total Penghasilan ", "March");
    data.setValue(4000, "Total Penghasilan ", "April");
    data.setValue(3000, "Total Penghasilan ", "Mei");
    data.setValue(2000, "Total Penghasilan ", "Juni");
    
    String title ="Perbandingan Penghasilan";
    
    
    JFreeChart barChart = ChartFactory.createBarChart3D("", "Monthly", "Penghasilan", data, PlotOrientation.VERTICAL, false, true, false);
    CategoryPlot plot = barChart.getCategoryPlot();
    BarRenderer3D ren = (BarRenderer3D) plot.getRenderer();
    Color color = new Color(111, 59, 160);
     
     
     ren.setSeriesPaint(0, color);
     ChartPanel barPanel = new ChartPanel(barChart);
     barPanel.setBackground(new Color(239,240,245));
    
     panel_chart.removeAll();
     panel_chart.add(barPanel);
     panel_chart.repaint();
     panel_chart.revalidate();
     
 }
    
 
    
  
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Barcode;
    private javax.swing.JPanel ConntainerPanel;
    private javax.swing.JTextField TXT_cariUser;
    private javax.swing.JButton btn_Bayar;
    private javax.swing.JButton btn_TambahBarang;
    private javax.swing.JButton btn_TambahBarang1;
    private javax.swing.JButton btn_exportPembelian;
    private javax.swing.JButton btn_exportPenjualan;
    private javax.swing.JButton btn_resetKeranjang;
    private javax.swing.JButton btn_tambahReturn;
    private javax.swing.JButton btn_tambahSupplier;
    public static javax.swing.JComboBox<String> comboBox_showBarang;
    private javax.swing.JComboBox<String> combo_boxPembelian;
    private javax.swing.JComboBox<String> combo_boxPenjualan;
    private javax.swing.JPanel container_laporanPembelian;
    private javax.swing.JPanel container_laporanPenjualan;
    private javax.swing.JPanel contenBarang;
    private javax.swing.JPanel contenKategori;
    private javax.swing.JPanel contenReturn;
    private javax.swing.JPanel contenSupplier;
    private javax.swing.JPanel conten_manajemen;
    private javax.swing.JPanel frame_logo_toko;
    private javax.swing.JPanel header_panel;
    private javax.swing.JLabel icon_cariBarang;
    private javax.swing.JLabel icon_cariKategori;
    private javax.swing.JLabel icon_cariSupplier;
    private javax.swing.JLabel icon_cariSupplier1;
    private javax.swing.JLabel icon_dashbord;
    private javax.swing.JLabel icon_kasir;
    private javax.swing.JLabel icon_kategori;
    private javax.swing.JLabel icon_pengSebulan;
    private javax.swing.JPanel icon_penghasilanSebulan;
    private javax.swing.JLabel icon_penjualanSebulan;
    private javax.swing.JLabel icon_return;
    private javax.swing.JLabel icon_totalReturn;
    private javax.swing.JLabel icon_user;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTable jTable4;
    public static javax.swing.JLabel label_idPegawai;
    private javax.swing.JLabel label_laporanPemebelian;
    private javax.swing.JLabel label_laporan_penjualan;
    public static javax.swing.JLabel label_namaPegawai;
    private javax.swing.JLabel label_namatoko;
    private javax.swing.JLabel label_navigasi_Kategori;
    private javax.swing.JLabel label_navigasi_barang;
    private javax.swing.JLabel label_navigasi_return;
    private javax.swing.JLabel label_navigasi_supplier;
    private javax.swing.JLabel label_page;
    public static javax.swing.JLabel label_role;
    private javax.swing.JLabel label_setProfile;
    private javax.swing.JLabel label_setToko;
    private javax.swing.JLabel label_tanggal;
    private javax.swing.JLabel label_totalBarang;
    private javax.swing.JLabel label_totalBarang4;
    private javax.swing.JLabel label_totalKategori;
    private javax.swing.JLabel label_totalReturn;
    private javax.swing.JPanel navigasi_panel;
    private javax.swing.JPanel panel_TxtField;
    private javax.swing.JPanel panel_cariBarang;
    private javax.swing.JPanel panel_cariKasir;
    private javax.swing.JPanel panel_cariKategori;
    private javax.swing.JPanel panel_cariReturn;
    private javax.swing.JPanel panel_cariSupplier;
    private javax.swing.JPanel panel_chart;
    private javax.swing.JPanel panel_containerLaporan;
    private javax.swing.JPanel panel_contenBarang;
    private javax.swing.JPanel panel_contenDashbord;
    private javax.swing.JPanel panel_contenKasir;
    private javax.swing.JPanel panel_contenLaporan;
    private javax.swing.JPanel panel_contenManageUser;
    private javax.swing.JPanel panel_contenSetting;
    private javax.swing.JPanel panel_dashbord;
    private javax.swing.JPanel panel_hasilCari;
    private javax.swing.JLabel panel_iconLaporan;
    private javax.swing.JLabel panel_iconManager;
    private javax.swing.JLabel panel_iconProduct;
    private javax.swing.JLabel panel_iconSetting;
    private javax.swing.JPanel panel_info;
    private javax.swing.JPanel panel_infoHarga;
    private javax.swing.JPanel panel_kasir;
    private javax.swing.JPanel panel_laporan;
    private javax.swing.JPanel panel_manager;
    private javax.swing.JPanel panel_navigasiBarang;
    private javax.swing.JPanel panel_navigasiLaporan;
    private javax.swing.JPanel panel_product;
    private javax.swing.JPanel panel_setting;
    private javax.swing.JPanel panel_totalBarang;
    private javax.swing.JPanel panel_totalKategori;
    private javax.swing.JPanel panel_totalReturn;
    private javax.swing.JPanel panel_totalSupplier;
    private javax.swing.JPanel panel_totalUser;
    private javax.swing.JLabel show_laporanPembelian;
    private javax.swing.JLabel show_laporanPenjualan;
    public static javax.swing.JTable tabel_kategori;
    public static javax.swing.JTable table_barang;
    public static javax.swing.JTable table_belanja;
    public static javax.swing.JTable table_cariBelanja;
    private javax.swing.JTable table_laporanPembelian;
    private javax.swing.JTable table_laporanPenjualan;
    private javax.swing.JTable table_return;
    public static javax.swing.JTable table_supplier;
    public static javax.swing.JTable table_user;
    private javax.swing.JLabel total_PenjSebulan;
    private javax.swing.JTextField txt_cariBrng;
    private javax.swing.JTextField txt_cariDataOrder;
    private javax.swing.JTextField txt_cariKategori;
    private javax.swing.JTextField txt_cariSupplier;
    private javax.swing.JTextField txt_cariSupplier1;
    public static javax.swing.JLabel txt_totalBrg;
    public static javax.swing.JLabel txt_totalKategori;
    private javax.swing.JLabel txt_totalReturn;
    public static javax.swing.JLabel txt_totalSupplier;
    // End of variables declaration//GEN-END:variables
} 
