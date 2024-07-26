/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.mycompany.ui;

import com.mycompany.dao.ChuyenDeDAO;
import com.mycompany.dao.HocVienDAO;
import com.mycompany.dao.KhoaHocDAO;
import com.mycompany.dao.NguoiHocDAO;
import com.mycompany.entity.ChuyenDe;
import com.mycompany.entity.HocVien;
import com.mycompany.entity.KhoaHoc;
import com.mycompany.entity.NguoiHoc;

import com.mycompany.utils.Auth;
import com.mycompany.utils.MsgBox;
import com.mycompany.utils.XImage;

import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;


public class HocVienJDialog extends javax.swing.JDialog {

    ChuyenDeDAO cdDAO = new ChuyenDeDAO();
    KhoaHocDAO khDAO = new KhoaHocDAO();
    NguoiHocDAO nhDAO = new NguoiHocDAO();
    HocVienDAO hvDAO = new HocVienDAO();

    private int selectedMaKH = -1;

    /**
     * Creates new form HocVienJDialog
     */
    public HocVienJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        init();
    }

    void init() {
        setIconImage(XImage.getAppIcon());
        setLocationRelativeTo(null);
        setTitle("Edusys - Quản Lý Học Viên");
        fillComboBoxChuyenDe();
    }

    void fillComboBoxChuyenDe() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cbo_chuyende.getModel();
        model.removeAllElements();
        try {
            List<ChuyenDe> list = cdDAO.selectAll();
            for (ChuyenDe cd : list) {
                model.addElement(cd);
            }
            fillComboBoxKhoaHoc();
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi truy vấn dữ liệu");
        }
    }

    void fillComboBoxKhoaHoc() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cbo_khoahoc.getModel();
        model.removeAllElements();
        try {
            ChuyenDe chuyenDe = (ChuyenDe) cbo_chuyende.getSelectedItem();
            if (chuyenDe != null) {
                List<KhoaHoc> list = khDAO.selectKhoaHocByChuyenDe(chuyenDe.getMaCD());
                for (KhoaHoc khoaHoc : list) {
                    model.addElement(khoaHoc);
                }
            }
            fillTableHocVien();
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi truy vấn dữ liệu");
        }
    }

    //nguoihoc
    public void fillTableNguoiHoc() {
        DefaultTableModel model = (DefaultTableModel) tblNguoiHoc.getModel();
        model.setRowCount(0);
        try {
            KhoaHoc kh = (KhoaHoc) cbo_khoahoc.getSelectedItem();
//                System.out.println("MaKH11:" + kh.getMaKH());
            if (kh != null) {
                System.out.println("MaKH:" + kh.getMaKH());
//                 String keyword = txt_timkiem.getText();
                List<NguoiHoc> list = nhDAO.selectNotInCourse(kh.getMaKH());
                for (NguoiHoc nh : list) {
                    model.addRow(new Object[]{
                        nh.getMaNH(),
                        nh.getHoTen(),
                        nh.isGioiTinh() ? "Nam" : "Nữ",
                        nh.getNgaySinh(),
                        nh.getDienThoai(),
                        nh.getEmail()
                    });
                }

//                   System.out.println("test");
            }
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi truy vấn dữ liệu! fillNguoHoc");
        }
    }

    public void fillTableHocVien() {
        DefaultTableModel model = (DefaultTableModel) tblHocVien.getModel();
        model.setRowCount(0);
        try {
            KhoaHoc kh = (KhoaHoc) cbo_khoahoc.getSelectedItem();
            if (kh != null) {
                System.out.println("filltableHocvien MaKH: " + kh.getMaKH());
                List<HocVien> list = hvDAO.selectByKHoaHoc(kh.getMaKH());
                System.out.println("list: " + list.size());
                for (int i = 0; i < list.size(); i++) {
                    HocVien hv = list.get(i);
                    String hoTen = nhDAO.selectById(hv.getMaNH()).getHoTen();
                    Object[] row = {
                        i + 1, hv.getMaHV(), hv.getMaNH(), hoTen, hv.getDiem()
                    };
                    model.addRow(row);
                }
            }
            fillTableNguoiHoc();
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi truy vẫn dữ liệu! bangHocVien");
        }
    }

    void findByName() {
        DefaultTableModel model = (DefaultTableModel) tblNguoiHoc.getModel();
        model.setRowCount(0);
        try {
            KhoaHoc kh = (KhoaHoc) cbo_khoahoc.getSelectedItem();
            if (kh != null) {
                String name = txt_timkiem.getText();
                List<NguoiHoc> list = nhDAO.selectByKeyWordAndKH(kh.getMaKH(), name);
                System.out.println("listFind:" + list.size());
                for (NguoiHoc nguoiHoc : list) {
                    model.addRow(new Object[]{
                        nguoiHoc.getMaNH(),
                        nguoiHoc.getHoTen(),
                        nguoiHoc.isGioiTinh() ? "Nam" : "Nữ",
                        nguoiHoc.getNgaySinh(),
                        nguoiHoc.getDienThoai(),
                        nguoiHoc.getEmail()
                    });
                }
            }
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi tìm kiếm theo tên!");
        }
    }

    //chức năng
    void addHocVien() {
        KhoaHoc khoaHoc = (KhoaHoc) cbo_khoahoc.getSelectedItem();
        for (int row : tblNguoiHoc.getSelectedRows()) {
            HocVien hv = new HocVien();
            hv.setMaKH(khoaHoc.getMaKH());
            hv.setDiem(0);
            hv.setMaNH((String) tblNguoiHoc.getValueAt(row, 0));
            System.out.println("=>" + hv.getMaHV() + "-" + hv.getMaNH() + "-" + hv.getDiem());
            hvDAO.insert(hv);
        }
        fillTableHocVien();
        fillTableNguoiHoc();
        tabs.setSelectedIndex(0);
    }

    void removeHocVien() {
        if (!Auth.isManager()) {
            MsgBox.alert(this, "Bạn không có quyền xóa học viên !");
        } else {
            int[] rows = tblHocVien.getSelectedRows();
            if (rows.length > 0 && MsgBox.confirm(this, "Bạn muốn xóa các nhân viên được chọn !")) {
                for (int row : rows) {
                    int mahv = (Integer) tblHocVien.getValueAt(row, 1);
                    hvDAO.delete(mahv);
                }
                this.fillTableHocVien();
            }
        }
    }

    void updateDiem() {
        int n = tblHocVien.getRowCount();
        for (int i = 0; i < n; i++) {
            int maHV = (Integer) tblHocVien.getValueAt(i, 1);
            double diem = Double.parseDouble(tblHocVien.getValueAt(i, 4) + "");
            HocVien hv = hvDAO.selectById(maHV);
            hv.setDiem(diem);
            hvDAO.update(hv);
        }
        MsgBox.alert(this, "Cập nhập điểm thành công !");
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pn_chuyende = new javax.swing.JPanel();
        cbo_chuyende = new javax.swing.JComboBox<>();
        pn_khoahoc = new javax.swing.JPanel();
        cbo_khoahoc = new javax.swing.JComboBox<>();
        tabs = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHocVien = new javax.swing.JTable();
        btn_xoaKhoaHoc = new javax.swing.JButton();
        btn_capnhatdiemKhoaHoc = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblNguoiHoc = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        txt_timkiem = new javax.swing.JTextField();
        btn_themvaoKhoaHoc = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pn_chuyende.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CHUYÊN ĐỀ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        cbo_chuyende.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbo_chuyende.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_chuyendeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pn_chuyendeLayout = new javax.swing.GroupLayout(pn_chuyende);
        pn_chuyende.setLayout(pn_chuyendeLayout);
        pn_chuyendeLayout.setHorizontalGroup(
            pn_chuyendeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_chuyendeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbo_chuyende, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pn_chuyendeLayout.setVerticalGroup(
            pn_chuyendeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_chuyendeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbo_chuyende, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                .addContainerGap())
        );

        pn_khoahoc.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "KHÓA HỌC", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        cbo_khoahoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbo_khoahoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_khoahocActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pn_khoahocLayout = new javax.swing.GroupLayout(pn_khoahoc);
        pn_khoahoc.setLayout(pn_khoahocLayout);
        pn_khoahocLayout.setHorizontalGroup(
            pn_khoahocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_khoahocLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cbo_khoahoc, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pn_khoahocLayout.setVerticalGroup(
            pn_khoahocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_khoahocLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbo_khoahoc, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                .addContainerGap())
        );

        tblHocVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "TT", "Mã Học Viên", "Mã Người Học", "Họ Tên", "Điểm"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHocVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHocVienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHocVien);
        if (tblHocVien.getColumnModel().getColumnCount() > 0) {
            tblHocVien.getColumnModel().getColumn(0).setResizable(false);
            tblHocVien.getColumnModel().getColumn(0).setPreferredWidth(10);
            tblHocVien.getColumnModel().getColumn(1).setResizable(false);
            tblHocVien.getColumnModel().getColumn(1).setPreferredWidth(16);
            tblHocVien.getColumnModel().getColumn(2).setResizable(false);
            tblHocVien.getColumnModel().getColumn(2).setPreferredWidth(16);
            tblHocVien.getColumnModel().getColumn(3).setPreferredWidth(200);
            tblHocVien.getColumnModel().getColumn(4).setResizable(false);
            tblHocVien.getColumnModel().getColumn(4).setPreferredWidth(15);
        }

        btn_xoaKhoaHoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/icon/Delete.png"))); // NOI18N
        btn_xoaKhoaHoc.setText("Xóa Khỏi Khóa Học");
        btn_xoaKhoaHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaKhoaHocActionPerformed(evt);
            }
        });

        btn_capnhatdiemKhoaHoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/icon/Edit.png"))); // NOI18N
        btn_capnhatdiemKhoaHoc.setText("Cập Nhật Điểm");
        btn_capnhatdiemKhoaHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_capnhatdiemKhoaHocActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 695, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_xoaKhoaHoc)
                        .addGap(27, 27, 27)
                        .addComponent(btn_capnhatdiemKhoaHoc)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_capnhatdiemKhoaHoc)
                    .addComponent(btn_xoaKhoaHoc))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabs.addTab("Học Viên", jPanel1);

        tblNguoiHoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Người Học", "Họ Tên", "Giới Tính", "Ngày Sinh", "Điện Thoại", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblNguoiHoc);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        txt_timkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_timkiemActionPerformed(evt);
            }
        });
        txt_timkiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_timkiemKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_timkiemKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_timkiem)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(txt_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        btn_themvaoKhoaHoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/icon/Add.png"))); // NOI18N
        btn_themvaoKhoaHoc.setText("Thêm Vào Khóa Học");
        btn_themvaoKhoaHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themvaoKhoaHocActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(0, 528, Short.MAX_VALUE)
                                .addComponent(btn_themvaoKhoaHoc)))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btn_themvaoKhoaHoc)
                .addGap(11, 11, 11))
        );

        tabs.addTab("Người Học", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tabs, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pn_chuyende, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pn_khoahoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pn_khoahoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pn_chuyende, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabs)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_capnhatdiemKhoaHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_capnhatdiemKhoaHocActionPerformed
        updateDiem();
    }//GEN-LAST:event_btn_capnhatdiemKhoaHocActionPerformed

    private void btn_xoaKhoaHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaKhoaHocActionPerformed
        removeHocVien();
    }//GEN-LAST:event_btn_xoaKhoaHocActionPerformed

    private void cbo_chuyendeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_chuyendeActionPerformed
        fillComboBoxKhoaHoc();
    }//GEN-LAST:event_cbo_chuyendeActionPerformed

    private void btn_themvaoKhoaHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themvaoKhoaHocActionPerformed
        addHocVien();
    }//GEN-LAST:event_btn_themvaoKhoaHocActionPerformed

    private void cbo_khoahocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_khoahocActionPerformed
        fillTableHocVien();


    }//GEN-LAST:event_cbo_khoahocActionPerformed

    private void txt_timkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_timkiemActionPerformed
        findByName();
    }//GEN-LAST:event_txt_timkiemActionPerformed

    private void txt_timkiemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_timkiemKeyPressed
        
    }//GEN-LAST:event_txt_timkiemKeyPressed

    private void txt_timkiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_timkiemKeyReleased
        findByName();
    }//GEN-LAST:event_txt_timkiemKeyReleased

    private void tblHocVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHocVienMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblHocVienMouseClicked

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
            java.util.logging.Logger.getLogger(HocVienJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HocVienJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HocVienJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HocVienJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                HocVienJDialog dialog = new HocVienJDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_capnhatdiemKhoaHoc;
    private javax.swing.JButton btn_themvaoKhoaHoc;
    private javax.swing.JButton btn_xoaKhoaHoc;
    private javax.swing.JComboBox<String> cbo_chuyende;
    private javax.swing.JComboBox<String> cbo_khoahoc;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel pn_chuyende;
    private javax.swing.JPanel pn_khoahoc;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JTable tblHocVien;
    private javax.swing.JTable tblNguoiHoc;
    private javax.swing.JTextField txt_timkiem;
    // End of variables declaration//GEN-END:variables
}
