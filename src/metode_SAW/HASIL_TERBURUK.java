/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metode_SAW;

import java.awt.Color;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Scanner;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPanel;
/**
 *
 * @author Hafizh Shafwan Rafa
 */
public class HASIL_TERBURUK extends javax.swing.JFrame {
    public Connection con;
    public Statement st;
    public ResultSet rs;
    public DefaultTableModel model;
    /**
     * Creates new form HASIL_TERBURUK
     */
    public HASIL_TERBURUK() {
        initComponents();
        String [] header = {"rank","id","buying","maint","person","lug_boot","safety","nilai v"};
        model = new DefaultTableModel (header,0);
        tabel.setModel(model);
        hitung();
    }
    
    public void hitung(){
        DecimalFormat format = new DecimalFormat ("#.##");
         Project classKoneksi = new Project ();
         try {
            con = classKoneksi.getKoneksi();
            st = con.createStatement();
            rs = st.executeQuery("Select * FROM car_evaluation1");
            int id = 1;
            int n = 300;
            String buying [] = new String [n];
            String maint [] = new String [n];
            String person [] = new String [n];
            String lug_boot [] = new String [n];
            String safety [] = new String [n]; 
            int i = 0;
            
            while (rs.next()){
                String [] row = {Integer.toString(id),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)};
                
                buying [i] = row[1];
                maint[i] = row[2];
                person[i] = row[3];
                lug_boot[i] = row[4];
                safety[i] = row[5];
                i++;
            }
            
            
             double [][] matriks = new double [n][6];
            int t = 1;
            int b = 0;
            int m = 0;
            int p = 0;
            int l = 0;
            int s = 0;
            
             for (int j = 0; j < matriks.length; j++) {
                for (int k = 0; k < matriks[0].length; k++) {
                    if (k==0) {
                        matriks [j][k] = t;
                        t++;
                    }
                    else if (k==1){
                        if (buying[b].equalsIgnoreCase("vhigh")) {
                            matriks[j][k] = 10;
                        }
                        else if (buying[b].equalsIgnoreCase("high")){
                            matriks[j][k] = 8;
                        }
                        else if (buying[b].equalsIgnoreCase("med")){
                            matriks[j][k] = 6;
                        }
                        else {
                            matriks[j][k] = 4;
                        }
                        b++;
                    }
                    else if (k==2){
                        if (maint[m].equalsIgnoreCase("vhigh")) {
                            matriks[j][k] = 10;
                        }
                        else if (maint[m].equalsIgnoreCase("high")){
                            matriks[j][k] = 8;
                        }
                        else if (maint[m].equalsIgnoreCase("med")){
                            matriks[j][k] = 6;
                        }
                        else {
                            matriks[j][k] = 4;
                        }
                        m++;
                            
                    }
                    else if (k==3){
                        if (person[p].equalsIgnoreCase("5more")) {
                            matriks[j][k] = 10;
                        }
                        else if (person[p].equalsIgnoreCase("4")) {
                            matriks[j][k] = 8;
                        }
                        else if (person[p].equalsIgnoreCase("3")) {
                            matriks[j][k] = 6;
                        }
                        else if (person[p].equalsIgnoreCase("2")) {
                            matriks[j][k] = 4;
                        }
                        p++;
                    }
                    
                    else if (k==4){
                        if (lug_boot[l].equalsIgnoreCase("small")) {
                            matriks[j][k] = 6;
                        }
                        else if (lug_boot[l].equalsIgnoreCase("med")) {
                            matriks[j][k] = 8;
                        }
                        else {
                            matriks[j][k] = 10;
                        }
                        
                        l++;
                    }
                    else if(k==5){
                        if (safety[s].equalsIgnoreCase("low")) {
                            matriks[j][k] = 6;
                        }
                        else if (safety[s].equalsIgnoreCase("med")) {
                            matriks[j][k] = 8;
                        }
                        else {
                            matriks[j][k] = 10;
                        }
                        
                        s++;
                        
                    }
                }
               
            }
             
             
            
             for (int j = 0; j < matriks.length; j++) {
                for (int k = 1; k < matriks[0].length; k++) {
                    if (k==1) {
                        matriks[j][k] = 4/matriks[j][k];
                    }
                    else if (k==2){
                        matriks[j][k] = 4/matriks[j][k];
                    }
                    else if (k==3){
                        matriks[j][k] = matriks[j][k]/10;
                    }
                    else if (k==4){
                        matriks[j][k] = matriks[j][k]/10;
                    }
                    else if (k==5){
                        matriks[j][k] = matriks[j][k]/10;
                    }
                    
                }
            }
             
              
            
            double v[][] = new double [2][n];
            int q = 0;
            
            for (int j = 0; j < v[0].length; j++) {
                v[0][j] = j;
            }
            
            for (int j = 0; j < v[0].length; j++,q++) {
              v[1][j] = (matriks[q][1]*10/100)+(matriks[q][2]*10/100)+(matriks[q][3]*25/100)+(matriks[q][4]*20/100)+(matriks[q][5]*35/100);  
            }
            
             int h = 1;
        
            for (int j = 0; j < v[0].length*65; j++) {
                int r = 0;
                int f = 0;
                for (int k = 0; k < v[0].length-1; k++) {
                    if (v[h][k]<v[h][k+1]) {
                        r = k;
                        f = k+1;
                    }
                }
                double z = v[h][f];
                v[h][f] = v[h][r];
                v[h][r] = z;
                double zz = v[h-1][f];
                v[h-1][f] = v[h-1][r];
                v[h-1][r] = zz;
                
            }
            
             
            
             int r = 199;
            
           
            int d [] = new int [n];
            for (int j = 0; j < d.length; j++) {
                d[j] = (int) v[0][j];
            }
             
            int hh = 199;
            int nm=200;
            while (hh<300){
                String [] row = {Integer.toString(nm),Integer.toString(d[r]),buying[d[r]],maint[d[r]],person[d[r]],lug_boot[d[r]],safety[d[r]],String.format("%.3f",v[1][r])};
                model.addRow(row);
                id++;
                hh++;
                r++;
                nm++;
                
            }
            tabel.setModel(model);
             
             
            
        }catch (SQLException ex){
            
        }
        
         
         
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ATAS = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        KIRI = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tmblexit = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        tmblhome = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        ATAS_bawah2 = new javax.swing.JPanel();
        tmbl_nilai2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        tmbl_hasil2 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        tmbl_data2 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        HASIL = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        BAWAH = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ATAS.setBackground(new java.awt.Color(0, 102, 102));
        ATAS.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.darkGray, java.awt.Color.lightGray, java.awt.Color.darkGray, java.awt.Color.lightGray));
        ATAS.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS G531GW\\Pictures\\Icon\\designing (1).png")); // NOI18N
        ATAS.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jLabel17.setFont(new java.awt.Font("Elephant", 0, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("METODE SAW");
        ATAS.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 1070, 60));

        jLabel18.setBackground(new java.awt.Color(51, 255, 0));
        jLabel18.setFont(new java.awt.Font("Garamond", 1, 48)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Sistem Pendukung Keputusan ");
        ATAS.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1070, 90));

        KIRI.setBackground(new java.awt.Color(0, 153, 153));
        KIRI.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.darkGray, java.awt.Color.lightGray, java.awt.Color.darkGray, java.awt.Color.lightGray));
        KIRI.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS G531GW\\Pictures\\Icon\\car.png")); // NOI18N
        KIRI.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 270, 250));

        jLabel1.setFont(new java.awt.Font("Felix Titling", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("TERBAIK");
        KIRI.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 250, -1));

        jLabel2.setFont(new java.awt.Font("Felix Titling", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("PEMILIHAN MOBIL ");
        KIRI.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 250, -1));

        tmblexit.setBackground(new java.awt.Color(153, 0, 51));
        tmblexit.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.darkGray, java.awt.Color.lightGray, java.awt.Color.darkGray, java.awt.Color.lightGray));
        tmblexit.setPreferredSize(new java.awt.Dimension(149, 43));
        tmblexit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tmblexitMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tmblexitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tmblexitMouseExited(evt);
            }
        });
        tmblexit.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Dubai", 1, 25)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("   Exit");
        tmblexit.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 246, 40));

        KIRI.add(tmblexit, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 550, 250, -1));

        tmblhome.setBackground(new java.awt.Color(0, 0, 255));
        tmblhome.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.darkGray, java.awt.Color.lightGray, java.awt.Color.darkGray, java.awt.Color.lightGray));
        tmblhome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tmblhomeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tmblhomeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tmblhomeMouseExited(evt);
            }
        });
        tmblhome.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Dubai", 1, 25)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("    Home");
        tmblhome.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 40));

        KIRI.add(tmblhome, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 500, 250, 40));

        ATAS_bawah2.setBackground(new java.awt.Color(51, 102, 0));
        ATAS_bawah2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        ATAS_bawah2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tmbl_nilai2.setBackground(new java.awt.Color(204, 0, 0));
        tmbl_nilai2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.darkGray, java.awt.Color.lightGray, java.awt.Color.darkGray, java.awt.Color.lightGray));
        tmbl_nilai2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tmbl_nilai2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tmbl_nilai2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tmbl_nilai2MouseExited(evt);
            }
        });
        tmbl_nilai2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Dubai Light", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("NILAI KRITERIA");
        tmbl_nilai2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 2, 260, 60));

        ATAS_bawah2.add(tmbl_nilai2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 260, 60));

        tmbl_hasil2.setBackground(new java.awt.Color(204, 0, 0));
        tmbl_hasil2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.darkGray, java.awt.Color.lightGray, java.awt.Color.darkGray, java.awt.Color.lightGray));
        tmbl_hasil2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tmbl_hasil2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tmbl_hasil2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tmbl_hasil2MouseExited(evt);
            }
        });
        tmbl_hasil2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Dubai Light", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("HASIL KEPUTUSAN");
        tmbl_hasil2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 4, 280, 60));

        ATAS_bawah2.add(tmbl_hasil2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 0, 280, 60));

        tmbl_data2.setBackground(new java.awt.Color(204, 0, 0));
        tmbl_data2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.darkGray, java.awt.Color.lightGray, java.awt.Color.darkGray, java.awt.Color.lightGray));
        tmbl_data2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tmbl_data2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tmbl_data2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tmbl_data2MouseExited(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Dubai Light", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("DATA");

        javax.swing.GroupLayout tmbl_data2Layout = new javax.swing.GroupLayout(tmbl_data2);
        tmbl_data2.setLayout(tmbl_data2Layout);
        tmbl_data2Layout.setHorizontalGroup(
            tmbl_data2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
        );
        tmbl_data2Layout.setVerticalGroup(
            tmbl_data2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
        );

        ATAS_bawah2.add(tmbl_data2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 60));

        HASIL.setBackground(new java.awt.Color(102, 102, 102));
        HASIL.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.darkGray, java.awt.Color.lightGray, java.awt.Color.darkGray, java.awt.Color.lightGray));
        HASIL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HASILMouseClicked(evt);
            }
        });
        HASIL.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabel.setAutoCreateRowSorter(true);
        tabel.setBackground(new java.awt.Color(204, 204, 204));
        tabel.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, java.awt.Color.lightGray));
        tabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        tabel.setForeground(new java.awt.Color(0, 0, 255));
        tabel.setModel(new javax.swing.table.DefaultTableModel(
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
        tabel.setColumnSelectionAllowed(true);
        tabel.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabel);

        HASIL.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 690, 510));

        jLabel5.setFont(new java.awt.Font("Exotc350 DmBd BT", 3, 25)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("HASIL PERANKINGAN DARI TERBURUK");
        HASIL.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 510, 50));

        BAWAH.setBackground(new java.awt.Color(0, 102, 102));
        BAWAH.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.darkGray, java.awt.Color.lightGray, java.awt.Color.darkGray, java.awt.Color.lightGray));
        BAWAH.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Dungeon", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("@ Kelompok Tujuh - Managed by Hafizh");
        BAWAH.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(375, 29, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1090, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(ATAS, javax.swing.GroupLayout.PREFERRED_SIZE, 1090, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(KIRI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(ATAS_bawah2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(HASIL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(BAWAH, javax.swing.GroupLayout.PREFERRED_SIZE, 1090, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 940, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(ATAS, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(KIRI, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(ATAS_bawah2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(HASIL, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(BAWAH, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tmblexitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tmblexitMouseClicked
        int dialogBtn = JOptionPane.YES_NO_OPTION;
        int dialogResult=JOptionPane.showConfirmDialog(this,"Anda Yakin Ingin Keluar?","PERINGATAN",dialogBtn);

        if(dialogBtn == 0){
            System.exit(0);
        }
        else{

        }
    }//GEN-LAST:event_tmblexitMouseClicked

    private void tmblhomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tmblhomeMouseClicked
        HOME x=new HOME();
        x.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_tmblhomeMouseClicked

    private void tmbl_nilai2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tmbl_nilai2MouseClicked
        NILAI x= new NILAI();
        x.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_tmbl_nilai2MouseClicked

    private void tmbl_nilai2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tmbl_nilai2MouseEntered
        tmbl_nilai2.setBackground(new Color(85, 107, 47));
    }//GEN-LAST:event_tmbl_nilai2MouseEntered

    private void tmbl_nilai2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tmbl_nilai2MouseExited
        tmbl_nilai2.setBackground(new Color(204,0,0));
    }//GEN-LAST:event_tmbl_nilai2MouseExited

    private void tmbl_hasil2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tmbl_hasil2MouseClicked
        Tombol x= new Tombol();
        x.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_tmbl_hasil2MouseClicked

    private void tmbl_hasil2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tmbl_hasil2MouseEntered
        tmbl_hasil2.setBackground(new Color(85, 107, 47));
    }//GEN-LAST:event_tmbl_hasil2MouseEntered

    private void tmbl_hasil2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tmbl_hasil2MouseExited
        tmbl_hasil2.setBackground(new Color(204,0,0));
    }//GEN-LAST:event_tmbl_hasil2MouseExited

    private void tmbl_data2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tmbl_data2MouseClicked
        DATA x= new DATA();
        x.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_tmbl_data2MouseClicked

    private void tmbl_data2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tmbl_data2MouseEntered
        tmbl_data2.setBackground(new Color(85, 107, 47));
    }//GEN-LAST:event_tmbl_data2MouseEntered

    private void tmbl_data2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tmbl_data2MouseExited
        tmbl_data2.setBackground(new Color(204,0,0));
    }//GEN-LAST:event_tmbl_data2MouseExited

    private void HASILMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HASILMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_HASILMouseClicked

    private void tmblexitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tmblexitMouseEntered
        tmblexit.setBackground(new Color(225, 217, 147));
    }//GEN-LAST:event_tmblexitMouseEntered

    private void tmblexitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tmblexitMouseExited
        tmblexit.setBackground(new Color(153,0,51));
    }//GEN-LAST:event_tmblexitMouseExited

    private void tmblhomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tmblhomeMouseEntered
        tmblhome.setBackground(new Color(205, 47, 47));
    }//GEN-LAST:event_tmblhomeMouseEntered

    private void tmblhomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tmblhomeMouseExited
        tmblhome.setBackground(new Color(0,0,255));
    }//GEN-LAST:event_tmblhomeMouseExited

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
            java.util.logging.Logger.getLogger(HASIL_TERBURUK.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HASIL_TERBURUK.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HASIL_TERBURUK.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HASIL_TERBURUK.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HASIL_TERBURUK().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ATAS;
    private javax.swing.JPanel ATAS_bawah2;
    private javax.swing.JPanel BAWAH;
    private javax.swing.JPanel HASIL;
    private javax.swing.JPanel KIRI;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabel;
    private javax.swing.JPanel tmbl_data2;
    private javax.swing.JPanel tmbl_hasil2;
    private javax.swing.JPanel tmbl_nilai2;
    private javax.swing.JPanel tmblexit;
    private javax.swing.JPanel tmblhome;
    // End of variables declaration//GEN-END:variables
}
