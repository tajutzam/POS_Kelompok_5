/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.RenderingHints;
import javax.swing.JPanel;
import service.barangService;
import Util.Id;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class TambahBanyakBarang extends javax.swing.JFrame {

    /**
     * Creates new form TambahBanyakBarang
     */
    String time = Timestamp.valueOf(LocalDateTime.now()).toString();
        int row=0;
           ImageIcon eroricon =  new ImageIcon(getClass().getResource("/picture/warning.png"));
    public TambahBanyakBarang() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.kode_barang_addBnyak.setEditable(false);
        this.label_idSupplier.setVisible(false);
        
    }
    String kode_kategori ;

    public String getKode_kategori() {
        return kode_kategori;
    }

    public void setKode_kategori(JComboBox box) {
        this.kode_kategori = box.getSelectedItem().toString();
    }
    
    
    
    public void Action(String opsi){
        
        if(opsi.equals("open")){
            this.setVisible(true);
        }
    }
    public void setIdSupplier(String id){
        this.label_idSupplier.setText(id);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label_navigasi = new RoundedPanel(8, new Color(255, 255, 255));
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        id_transaksiBeli = new javax.swing.JLabel();
        label_idSupplier = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nama_supplier = new javax.swing.JLabel();
        nama_kategori = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        label_Kode_kategori = new javax.swing.JLabel();
        jPanel1 = new RoundedPanel(8, new Color(255, 255, 255));
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        kode_barang_addBnyak = new javax.swing.JTextField();
        nama_barang_addBanyak = new javax.swing.JTextField();
        stok_addBanyak = new javax.swing.JTextField();
        harga_beli_addBanyak = new javax.swing.JTextField();
        harga_jual_addBanyak = new javax.swing.JTextField();
        rusak = new javax.swing.JTextField();
        btn_clearAddBanyak = new javax.swing.JButton();
        btn_addBanyak = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_addBanyak = new javax.swing.JTable();
        jPanel2 = new RoundedPanel(8,  new Color(255, 255, 255));
        btn_simpanAddBanyak = new javax.swing.JButton();
        btn_cancelAddBanyak = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(239, 240, 245));

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(90, 90, 90));
        jLabel1.setText("Barang > Tambah Banyak Barang");

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(90, 90, 90));
        jLabel2.setText("ID TRANSAKSI    :");

        id_transaksiBeli.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        id_transaksiBeli.setForeground(new java.awt.Color(90, 90, 90));
        id_transaksiBeli.setText("TRB05100987");

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(90, 90, 90));
        jLabel3.setText("SUPPLIER :");

        nama_supplier.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        nama_supplier.setForeground(new java.awt.Color(90, 90, 90));
        nama_supplier.setText("TRB05100987");

        nama_kategori.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        nama_kategori.setForeground(new java.awt.Color(90, 90, 90));
        nama_kategori.setText("TRB05100987");

        jLabel10.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(90, 90, 90));
        jLabel10.setText("KATEGORI :");

        label_Kode_kategori.setText("jLabel11");

        javax.swing.GroupLayout label_navigasiLayout = new javax.swing.GroupLayout(label_navigasi);
        label_navigasi.setLayout(label_navigasiLayout);
        label_navigasiLayout.setHorizontalGroup(
            label_navigasiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(label_navigasiLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(93, 93, 93)
                .addComponent(label_Kode_kategori)
                .addGap(134, 134, 134)
                .addComponent(label_idSupplier)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(nama_kategori)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nama_supplier)
                .addGap(39, 39, 39)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(id_transaksiBeli)
                .addGap(29, 29, 29))
        );
        label_navigasiLayout.setVerticalGroup(
            label_navigasiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, label_navigasiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(label_navigasiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(jLabel2)
                    .addComponent(id_transaksiBeli)
                    .addComponent(label_idSupplier)
                    .addComponent(jLabel3)
                    .addComponent(nama_supplier)
                    .addComponent(nama_kategori)
                    .addComponent(jLabel10)
                    .addComponent(label_Kode_kategori))
                .addContainerGap())
        );

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(90, 90, 90));
        jLabel4.setText("Kode Barang");

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(90, 90, 90));
        jLabel5.setText("Nama Barang");

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(90, 90, 90));
        jLabel6.setText("Stok");

        jLabel7.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(90, 90, 90));
        jLabel7.setText("Harga Beli");

        jLabel8.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(90, 90, 90));
        jLabel8.setText("Harga Jual");

        jLabel9.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(90, 90, 90));
        jLabel9.setText("Barang Rusak");

        kode_barang_addBnyak.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        nama_barang_addBanyak.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        stok_addBanyak.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        harga_beli_addBanyak.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        harga_jual_addBanyak.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        rusak.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        btn_clearAddBanyak.setBackground(new java.awt.Color(51, 45, 45));
        btn_clearAddBanyak.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        btn_clearAddBanyak.setForeground(new java.awt.Color(255, 255, 255));
        btn_clearAddBanyak.setText("Clear");

        btn_addBanyak.setBackground(new java.awt.Color(96, 96, 96));
        btn_addBanyak.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        btn_addBanyak.setForeground(new java.awt.Color(255, 255, 255));
        btn_addBanyak.setText("Tambah");
        btn_addBanyak.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_addBanyakMouseClicked(evt);
            }
        });

        tabel_addBanyak.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabel_addBanyak);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1068, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(kode_barang_addBnyak, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(45, 45, 45)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(nama_barang_addBanyak, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5))
                            .addGap(45, 45, 45)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(stok_addBanyak, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6))
                            .addGap(45, 45, 45)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7)
                                .addComponent(harga_beli_addBanyak, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(45, 45, 45)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(harga_jual_addBanyak, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8))
                            .addGap(45, 45, 45)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(rusak, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel9))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_addBanyak, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_clearAddBanyak, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel9)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kode_barang_addBnyak, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nama_barang_addBanyak, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stok_addBanyak, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(harga_beli_addBanyak, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(harga_jual_addBanyak, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rusak, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_clearAddBanyak, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_addBanyak, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
                .addContainerGap())
        );

        btn_simpanAddBanyak.setBackground(new java.awt.Color(111, 59, 160));
        btn_simpanAddBanyak.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        btn_simpanAddBanyak.setForeground(new java.awt.Color(255, 255, 255));
        btn_simpanAddBanyak.setText("Simpan");
        btn_simpanAddBanyak.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_simpanAddBanyakMouseClicked(evt);
            }
        });

        btn_cancelAddBanyak.setBackground(new java.awt.Color(204, 0, 0));
        btn_cancelAddBanyak.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        btn_cancelAddBanyak.setForeground(new java.awt.Color(255, 255, 255));
        btn_cancelAddBanyak.setText("Cancel");
        btn_cancelAddBanyak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelAddBanyakActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_simpanAddBanyak, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_cancelAddBanyak, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_simpanAddBanyak, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cancelAddBanyak, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label_navigasi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_navigasi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cancelAddBanyakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelAddBanyakActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_cancelAddBanyakActionPerformed

    private void btn_simpanAddBanyakMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_simpanAddBanyakMouseClicked
         // TODO add your handling code here:
         
         //insert Transaksi
         boolean isSuces=false;
        
         DataBarangTambah dt = new DataBarangTambah();
         if(tabel_addBanyak.getRowCount()==0){
           
             JOptionPane.showMessageDialog(null, "Harap Isi Product Terlebih dahulu", "Terjadi Kesalahan !", JOptionPane.ERROR_MESSAGE, eroricon); 
         }else{
             barangService barang = new barangService();
             barang.insertIdTransaksiBeli(this.id_transaksiBeli.getText().toString(), this.label_idSupplier.getText().toString(), time ,label_Kode_kategori.getText() );
             for(int i=0; i<tabel_addBanyak.getRowCount();i++){
                  
                String nama=tabel_addBanyak.getValueAt(i, 2).toString();
                String kode_product=tabel_addBanyak.getValueAt(i, 1).toString();
                String harga_beli=tabel_addBanyak.getValueAt(i, 6).toString();
                String harga_jual=tabel_addBanyak.getValueAt(i, 7).toString();
                String stok=tabel_addBanyak.getValueAt(i, 4).toString();
                String barang_rusak=tabel_addBanyak.getValueAt(i,5 ).toString();
                String kategori=label_Kode_kategori.getText();
                String supplier=label_idSupplier.getText();
                isSuces=barang.addBarangBanyak(nama, kode_product, harga_beli, harga_jual, stok, barang_rusak, kategori, supplier, dt);
               // barang.addBarang(nama, kode_product, harga_beli, harga_jual, stok, barang_rusak, kategori, supplier, dt);
                barang.insertDataTambahBanyakProduct(id_transaksiBeli.getText(), stok, kode_product);
              
 
             }
             if(isSuces==true){
                
                JOptionPane.showMessageDialog(null, "berhasil Menambahkan Barang dengan id transaksi "+id_transaksiBeli.getText().toString(),"Susces",JOptionPane.INFORMATION_MESSAGE);
                barang.showBarang(Dashbord.table_barang);
                this.dispose();

             }
             
             
         }
         
         
    }//GEN-LAST:event_btn_simpanAddBanyakMouseClicked

    public void setBarangRusak(){
        this.rusak.setText("0");
    }
    public void setKodeKategori(String kode){
        this.label_Kode_kategori.setText(kode);
    }
    private void btn_addBanyakMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_addBanyakMouseClicked
         // TODO add your handling code here:
         
         barangService barang = new barangService();
         
         String kode=this.kode_barang_addBnyak.getText().toString();
         String nama_barang =this.nama_barang_addBanyak.getText();
         String stok =this.stok_addBanyak.getText();
         String harga_beli =this.harga_beli_addBanyak.getText();
         String harga_jual =this.harga_jual_addBanyak.getText();
         String rusak =this.rusak.getText();
         System.out.println(kode);
         System.out.println(tabel_addBanyak.getRowCount());
         System.out.println(this.row);
         System.out.println(this.getKode_kategori());
         if(tabel_addBanyak.getRowCount()==this.row){
             System.out.println("nol");
           
               if(barang.tambahDataKetabel(kode, nama_barang, stok, harga_beli, harga_jual, rusak, this.getKode_kategori())==true) {
                    String kodeBaru =barang.getIdTableAfterAdd(false, KonfirmasiSupplier.combo_addKategori, tabel_addBanyak);
                 System.out.println(kodeBaru);
                this.kode_barang_addBnyak.setText(kodeBaru); 
                this.row++;
                this.nama_barang_addBanyak.setText("");
                this.stok_addBanyak.setText("");
                this.harga_beli_addBanyak.setText("");
                this.harga_jual_addBanyak.setText("");
                this.setBarangRusak();
               }
               

         }
         System.out.println("aksi");
           
        
         
        
    }//GEN-LAST:event_btn_addBanyakMouseClicked

    public void setNamaSupplier(String nama){
        this.nama_supplier.setText(nama);
    }
    public void setIdTransaksi(String id){
        this.id_transaksiBeli.setText(id);
    }
    public String getKodeSupplier(){
        return this.label_idSupplier.getText().toString();
    }
    public void setNamaKategori(String kategori){
        this.nama_kategori.setText(kategori);
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
            java.util.logging.Logger.getLogger(TambahBanyakBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TambahBanyakBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TambahBanyakBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TambahBanyakBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TambahBanyakBarang().setVisible(true);
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
    
    public void setIdtransaksi(String id){
        this.id_transaksiBeli.setText(id);
    }
    public void setKodeBarang(String kode){
        this.kode_barang_addBnyak.setText(kode);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_addBanyak;
    private javax.swing.JButton btn_cancelAddBanyak;
    private javax.swing.JButton btn_clearAddBanyak;
    private javax.swing.JButton btn_simpanAddBanyak;
    private javax.swing.JTextField harga_beli_addBanyak;
    private javax.swing.JTextField harga_jual_addBanyak;
    private javax.swing.JLabel id_transaksiBeli;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField kode_barang_addBnyak;
    private javax.swing.JLabel label_Kode_kategori;
    public static javax.swing.JLabel label_idSupplier;
    private javax.swing.JPanel label_navigasi;
    private javax.swing.JTextField nama_barang_addBanyak;
    private javax.swing.JLabel nama_kategori;
    private javax.swing.JLabel nama_supplier;
    private javax.swing.JTextField rusak;
    private javax.swing.JTextField stok_addBanyak;
    public static javax.swing.JTable tabel_addBanyak;
    // End of variables declaration//GEN-END:variables
}
