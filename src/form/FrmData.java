package form;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FrmData extends javax.swing.JFrame {

    public Statement st;
    public ResultSet rs;
    Connection cn = koneksi.KoneksiDatabase.Koneksi();

    public FrmData() {
        setTitle("Klinik Fadilla");
        initComponents();
        
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                exit(); 
            }
        });
        
        showData();
    }

    private void reset() {
        txtNoTelp.setText("");
        txtNama.setText("");
        txtNIK.setText("");
        txtAlamat.setText("");
        txtNoTelp.setText("");
        inputTglLahir.setDate(null);
        
        btnSimpan.setText("Simpan");
        txtNIK.setEditable(true);
    }
    
    private void showData() {
        try {
            st = cn.createStatement();
            rs = st.executeQuery("SELECT * FROM PASIEN");

            DefaultTableModel tblModel = new DefaultTableModel();
            tblModel.addColumn("No.");
            tblModel.addColumn("NIK");
            tblModel.addColumn("Nama");
            tblModel.addColumn("Alamat");
            tblModel.addColumn("Tanggal Lahir");
            tblModel.addColumn("Nomor Telepon");

            tblModel.getDataVector().removeAllElements();
            tblModel.fireTableDataChanged();
            tblModel.setRowCount(0);

            int no = 1;
            while (rs.next()) {
                Object[] data = new Object[]{
                    no,
                    rs.getString("NIK"),
                    rs.getString("NAMA"),
                    rs.getString("ALAMAT"),
                    new SimpleDateFormat("yyyy-MMM-dd").format(rs.getDate("TANGGAL_LAHIR")),
                    rs.getString("NO_TLP"),};
                tblModel.addRow(data);
                tblPasien.setModel(tblModel);
                no++;
            }

        } catch (Exception ex) {

        }
    }
    
    private void exit() {
        int response = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin keluar?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (response == JOptionPane.YES_OPTION) {
            System.exit(0);
        }else{
            return;
        }
    }

    private void search() {
        try {
            String key = cmbCari.getSelectedItem().toString();
            if(key.equalsIgnoreCase("Nomor telepon")){
                key = "NO_TLP";
            }
            
            st = cn.createStatement();
            rs = st.executeQuery("SELECT * FROM PASIEN WHERE " + key + " LIKE '%" + txtCari.getText().toString() + "%'");

            DefaultTableModel tblModel = new DefaultTableModel();
            tblModel.addColumn("No.");
            tblModel.addColumn("NIK");
            tblModel.addColumn("Nama");
            tblModel.addColumn("Alamat");
            tblModel.addColumn("Tanggal Lahir");
            tblModel.addColumn("Nomor Telepon");

            tblModel.getDataVector().removeAllElements();
            tblModel.fireTableDataChanged();
            tblModel.setRowCount(0);

            int no = 1;
            while (rs.next()) {
                Object[] data = new Object[]{
                    no,
                    rs.getString("NIK"),
                    rs.getString("NAMA"),
                    rs.getString("ALAMAT"),
                    new SimpleDateFormat("yyyy-MMM-dd").format(rs.getDate("TANGGAL_LAHIR")),
                    rs.getString("NO_TLP"),};
                tblModel.addRow(data);
                tblPasien.setModel(tblModel);
                no++;
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNIK = new javax.swing.JTextField();
        txtNama = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNoTelp = new javax.swing.JTextField();
        inputTglLahir = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPasien = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        cmbCari = new javax.swing.JComboBox<>();
        txtCari = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAlamat = new javax.swing.JTextArea();
        btnSimpan = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("NIK");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Nama");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Nomor Telepon");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Tanggal Lahir");

        tblPasien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "No", "NIK", "Nama", "Alamat", "Tanggal Lahir", "Nomor Telepon"
            }
        ));
        tblPasien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPasienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPasien);
        if (tblPasien.getColumnModel().getColumnCount() > 0) {
            tblPasien.getColumnModel().getColumn(0).setResizable(false);
            tblPasien.getColumnModel().getColumn(0).setPreferredWidth(30);
        }

        jLabel4.setText("Cari Data");

        cmbCari.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nik", "Nama", "Nomor Telepon" }));

        txtCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCariKeyPressed(evt);
            }
        });

        jLabel6.setText("Alamat");

        txtAlamat.setColumns(20);
        txtAlamat.setRows(5);
        jScrollPane2.setViewportView(txtAlamat);

        btnSimpan.setBackground(new java.awt.Color(56, 75, 244));
        btnSimpan.setForeground(new java.awt.Color(255, 255, 255));
        btnSimpan.setText("Simpan");
        btnSimpan.setPreferredSize(new java.awt.Dimension(110, 35));
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnHapus.setBackground(new java.awt.Color(56, 75, 244));
        btnHapus.setForeground(new java.awt.Color(255, 255, 255));
        btnHapus.setText("Hapus");
        btnHapus.setPreferredSize(new java.awt.Dimension(110, 35));
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnBatal.setBackground(new java.awt.Color(56, 75, 244));
        btnBatal.setForeground(new java.awt.Color(255, 255, 255));
        btnBatal.setText("Batal");
        btnBatal.setPreferredSize(new java.awt.Dimension(110, 35));
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(56, 75, 244));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Keluar");
        jButton1.setPreferredSize(new java.awt.Dimension(72, 35));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(cmbCari, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtCari))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE))
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel6))
                                .addGap(49, 49, 49)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnSimpan, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnHapus, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnBatal, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE))
                                    .addComponent(inputTglLahir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtNIK)
                                    .addComponent(txtNama)
                                    .addComponent(txtNoTelp)
                                    .addComponent(jScrollPane2))))))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1)
                    .addComponent(txtNIK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtNoTelp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(inputTglLahir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBatal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel4)
                    .addComponent(cmbCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnBatal, btnHapus, btnSimpan});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        try {
            st = cn.createStatement();
            if (txtNIK.getText().equals("")
                    || txtNama.getText().equals("")
                    || txtAlamat.getText().equals("")
                    || txtNoTelp.getText().equals("")
                    || inputTglLahir.getDate() == null) {
                JOptionPane.showMessageDialog(this, "Data tidak boleh kosong, silahkan lengkapi data!", "Validasi Data", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            if (txtNIK.getText().length() != 15) {
                JOptionPane.showMessageDialog(this, "NIK harus terdiri dari 15 digit, silahkan input ulang!", "Validasi Data", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            if (btnSimpan.getText() == "Simpan") {
                String cekNIK = "SELECT * FROM PASIEN WHERE NIK = '" + txtNIK.getText() + "'";
                rs = st.executeQuery(cekNIK);
                if (rs.next()) {
                    JOptionPane.showMessageDialog(this, "Mohon maaf, NIK tersebut sudah ada!");
                } else {
                    String tglLahir = new SimpleDateFormat("yyyy-MM-dd").format(inputTglLahir.getDate());
                    String sqlInsert = "INSERT INTO PASIEN (NAMA, ALAMAT, NIK, TANGGAL_LAHIR, NO_TLP) VALUES ('" + txtNama.getText()
                            + "','" + txtAlamat.getText() + "','" + txtNIK.getText()
                            + "','" + tglLahir + "','" + txtNoTelp.getText()
                            + "')";
                    st.executeUpdate(sqlInsert);
                    JOptionPane.showMessageDialog(this, "Data pasien berhasil disimpan!");
                    reset();
                    showData();
                }
            } else {
                String tglLahir = new SimpleDateFormat("yyyy-MM-dd").format(inputTglLahir.getDate());
                String sqlUpdate = "UPDATE PASIEN SET "
                    + "NAMA = '" + txtNama.getText() + "', "
                    + "ALAMAT = '" + txtAlamat.getText() + "', "
                    + "TANGGAL_LAHIR = '" + tglLahir + "', "
                    + "NO_TLP = '" + txtNoTelp.getText() + "' "
                    + "WHERE NIK = '" + txtNIK.getText() + "'";
                st.executeUpdate(sqlUpdate);
                JOptionPane.showMessageDialog(this, "Data pasien berhasil diubah!");
                reset();
                showData();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        if(txtNIK.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Silahkan pilih data yang akan dihapus terlebih dahulu!");
        }else{
            int konfirmasi = JOptionPane.showConfirmDialog(this, "Apakah anda yakin menghapus data ini ?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            if(konfirmasi == JOptionPane.YES_OPTION){
                try{
                    st = cn.createStatement();
                    String sql = "DELETE FROM PASIEN WHERE NIK = '" + txtNIK.getText() + "'";
                    st.executeUpdate(sql);
                    JOptionPane.showMessageDialog(this, "Data pasien berhasil dihapus!");
                    showData();
                    reset();
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(this, ex);
                }
            }
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        reset();
    }//GEN-LAST:event_btnBatalActionPerformed

    private void tblPasienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPasienMouseClicked
        txtNIK.setText(tblPasien.getValueAt(tblPasien.getSelectedRow(), 1).toString());
        txtNama.setText(tblPasien.getValueAt(tblPasien.getSelectedRow(), 2).toString());
        txtAlamat.setText(tblPasien.getValueAt(tblPasien.getSelectedRow(), 3).toString());
        txtNoTelp.setText(tblPasien.getValueAt(tblPasien.getSelectedRow(), 5).toString());
        String dateString = (String) tblPasien.getValueAt(tblPasien.getSelectedRow(), 4);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MMM-dd"); 
        try {
            java.util.Date utilDate = format.parse(dateString); 
            Date sqlDate = new Date(utilDate.getTime()); 
            inputTglLahir.setDate(sqlDate);
        } catch (ParseException e) {
            e.printStackTrace(); 
        }

        txtNIK.setEditable(false);
        btnSimpan.setText("Ubah");
    }//GEN-LAST:event_tblPasienMouseClicked

    private void txtCariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariKeyPressed
        search();
    }//GEN-LAST:event_txtCariKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        exit();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(FrmData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmData().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JComboBox<String> cmbCari;
    private com.toedter.calendar.JDateChooser inputTglLahir;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tblPasien;
    private javax.swing.JTextArea txtAlamat;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtNIK;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtNoTelp;
    // End of variables declaration//GEN-END:variables
}
