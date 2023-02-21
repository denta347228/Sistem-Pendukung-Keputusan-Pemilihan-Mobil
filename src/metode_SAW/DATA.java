/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metode_SAW;
import java.awt.Color;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Hafizh Shafwan Rafa
 */
public class DATA extends javax.swing.JFrame {
    public Connection con;
    public Statement st;
    public ResultSet rs;
    public DefaultTableModel model;
    /**
     * Creates new form DATA
     */
    public DATA() {
        initComponents();
         String [] header = {"id","buying","maint","person","lug_boot","safety"};
        model = new DefaultTableModel (header,0);
        jTable1.setModel(model);
        tampil();
    }
        public void tampil (){
        Project classKoneksi = new Project ();
        try {
            con = classKoneksi.getKoneksi();
            st = con.createStatement();
            rs = st.executeQuery("Select * FROM car_evaluation1");
            int id = 1;
            while (rs.next()){
                String [] row = {Integer.toString(id),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)};
                model.addRow(row);
                id++;
            }
            jTable1.setModel(model);
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
        jLabel10 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        BAWAH = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        KIRI = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tmblexit = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        tmblhome = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        ATAS_bawah = new javax.swing.JPanel();
        tmbl_nilai = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        tmbl_hasil = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        tmbl_data = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        DATA = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        ATAS.setBackground(new java.awt.Color(0, 102, 102));
        ATAS.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.darkGray, java.awt.Color.lightGray, java.awt.Color.darkGray, java.awt.Color.lightGray));
        ATAS.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS G531GW\\Pictures\\Icon\\designing (1).png")); // NOI18N
        ATAS.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jLabel14.setFont(new java.awt.Font("Elephant", 0, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("METODE SAW");
        ATAS.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 1090, 70));

        jLabel13.setBackground(new java.awt.Color(51, 255, 0));
        jLabel13.setFont(new java.awt.Font("Garamond", 1, 48)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Sistem Pendukung Keputusan ");
        ATAS.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1090, 90));

        BAWAH.setBackground(new java.awt.Color(0, 102, 102));
        BAWAH.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.darkGray, java.awt.Color.lightGray, java.awt.Color.darkGray, java.awt.Color.lightGray));
        BAWAH.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Dungeon", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("@ Kelompok Tujuh - Managed by Hafizh");
        BAWAH.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(375, 29, -1, -1));

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

        ATAS_bawah.setBackground(new java.awt.Color(51, 102, 0));
        ATAS_bawah.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.darkGray, java.awt.Color.lightGray, java.awt.Color.darkGray, java.awt.Color.lightGray));
        ATAS_bawah.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tmbl_nilai.setBackground(new java.awt.Color(204, 0, 0));
        tmbl_nilai.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.darkGray, java.awt.Color.lightGray, java.awt.Color.darkGray, java.awt.Color.lightGray));
        tmbl_nilai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tmbl_nilaiMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tmbl_nilaiMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tmbl_nilaiMouseExited(evt);
            }
        });
        tmbl_nilai.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Dubai Light", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("NILAI KRITERIA");
        tmbl_nilai.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 2, 260, 60));

        ATAS_bawah.add(tmbl_nilai, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 260, 60));

        tmbl_hasil.setBackground(new java.awt.Color(204, 0, 0));
        tmbl_hasil.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.darkGray, java.awt.Color.lightGray, java.awt.Color.darkGray, java.awt.Color.lightGray));
        tmbl_hasil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tmbl_hasilMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tmbl_hasilMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tmbl_hasilMouseExited(evt);
            }
        });
        tmbl_hasil.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Dubai Light", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("HASIL KEPUTUSAN");
        tmbl_hasil.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 4, 280, 60));

        ATAS_bawah.add(tmbl_hasil, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 0, 280, 60));

        tmbl_data.setBackground(new java.awt.Color(204, 0, 0));
        tmbl_data.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.darkGray, java.awt.Color.lightGray, java.awt.Color.darkGray, java.awt.Color.lightGray));
        tmbl_data.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tmbl_dataMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tmbl_dataMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tmbl_dataMouseExited(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Dubai Light", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("DATA");

        javax.swing.GroupLayout tmbl_dataLayout = new javax.swing.GroupLayout(tmbl_data);
        tmbl_data.setLayout(tmbl_dataLayout);
        tmbl_dataLayout.setHorizontalGroup(
            tmbl_dataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
        );
        tmbl_dataLayout.setVerticalGroup(
            tmbl_dataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
        );

        ATAS_bawah.add(tmbl_data, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 60));

        DATA.setBackground(new java.awt.Color(102, 102, 102));
        DATA.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.darkGray, java.awt.Color.lightGray, java.awt.Color.darkGray, java.awt.Color.lightGray));
        DATA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DATAMouseClicked(evt);
            }
        });
        DATA.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setBackground(new java.awt.Color(204, 204, 204));
        jTable1.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, null));
        jTable1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jTable1.setForeground(new java.awt.Color(0, 0, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
        }

        DATA.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 670, 500));

        jLabel5.setFont(new java.awt.Font("Exotc350 DmBd BT", 3, 25)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("DATA KRITERIA");
        DATA.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 230, -1));

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
                                .addComponent(ATAS_bawah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(DATA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
                            .addComponent(ATAS_bawah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(DATA, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)))
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

    private void tmbl_nilaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tmbl_nilaiMouseClicked
        NILAI x= new NILAI();
        x.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_tmbl_nilaiMouseClicked

    private void tmbl_hasilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tmbl_hasilMouseClicked
        Tombol x= new Tombol();
        x.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_tmbl_hasilMouseClicked

    private void tmbl_dataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tmbl_dataMouseClicked
        
    }//GEN-LAST:event_tmbl_dataMouseClicked

    private void DATAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DATAMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_DATAMouseClicked

    private void tmbl_nilaiMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tmbl_nilaiMouseEntered
        tmbl_nilai.setBackground(new Color(85, 107, 47));
    }//GEN-LAST:event_tmbl_nilaiMouseEntered

    private void tmbl_nilaiMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tmbl_nilaiMouseExited
       tmbl_nilai.setBackground(new Color(204,0,0));
    }//GEN-LAST:event_tmbl_nilaiMouseExited

    private void tmbl_hasilMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tmbl_hasilMouseEntered
        tmbl_hasil.setBackground(new Color(85, 107, 47));
    }//GEN-LAST:event_tmbl_hasilMouseEntered

    private void tmbl_hasilMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tmbl_hasilMouseExited
         tmbl_hasil.setBackground(new Color(204,0,0));
    }//GEN-LAST:event_tmbl_hasilMouseExited

    private void tmbl_dataMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tmbl_dataMouseEntered
         tmbl_data.setBackground(new Color(85, 107, 47));
    }//GEN-LAST:event_tmbl_dataMouseEntered

    private void tmbl_dataMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tmbl_dataMouseExited
        tmbl_data.setBackground(new Color(204,0,0));
    }//GEN-LAST:event_tmbl_dataMouseExited

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
            java.util.logging.Logger.getLogger(DATA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DATA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DATA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DATA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DATA().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ATAS;
    private javax.swing.JPanel ATAS_bawah;
    private javax.swing.JPanel BAWAH;
    private javax.swing.JPanel DATA;
    private javax.swing.JPanel KIRI;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel tmbl_data;
    private javax.swing.JPanel tmbl_hasil;
    private javax.swing.JPanel tmbl_nilai;
    private javax.swing.JPanel tmblexit;
    private javax.swing.JPanel tmblhome;
    // End of variables declaration//GEN-END:variables
}